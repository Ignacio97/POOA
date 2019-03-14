package com.simulacion.ecosistema.hulk.code.server;

import java.awt.Component;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import com.simulacion.ecosistema.hulk.gui.appEstudiante.EstudianteApp;
import com.simulacion.ecosistema.hulk.gui.appEstudiante.PanelLogIn;
import com.simulacion.ecosistema.hulk.gui.appEstudiante.PanelRegistro;

import com.simulacion.ecosistema.hulk.gui.appEstudiante.PanelSimulacion;
import com.simulacion.ecosistema.hulk.modelo.simulacion.CoordenadaOrganismo;

public class Client extends Thread {
	private String host = null;
	private int port;
	private Socket socket = null;
	private boolean alive;
	private ObjectOutputStream out = null;
	private ObjectInputStream in = null;
	private PanelSimulacion panelJuego;
	private PanelLogIn panelLog;
	private PanelRegistro panelSign;
	private EstudianteApp app;
	
	
	public void setPanelLog(PanelLogIn panelLog) {
		this.panelLog = panelLog;
	}

	public void setPanelSign(PanelRegistro panelSign) {
		this.panelSign = panelSign;
	}

	
	public void setApp(EstudianteApp app) {
		this.app = app;
	}

	public Client(String host, int port) {
		this.host = host;
		this.port = port;
		this.alive = false;
	}

	// sets a default host
	public Client(int port) {
		this("127.0.0.1", port);
	}

	public void sendMessage(Message msg) {
		try {
			this.out = new ObjectOutputStream(this.socket.getOutputStream());
			this.out.writeObject(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void startClient() {
		if (this.alive) return;
		
		try {
			this.socket = new Socket(this.host, this.port);
		} catch (IOException e) {
			e.printStackTrace();
		}  
		finally {
			this.alive = true;
			this.start();
		}
	}

	public void stopClient() {
		if(!this.alive) return;
		try {
			this.socket.close();
			this.out.close();
			this.in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			this.alive = false;
		}
	}

	
	
	public void setPanel(PanelSimulacion panel) {
		this.panelJuego = panel;
	}

	@Override
	public void run() {

		while (this.alive) {
			try {
				this.in = new ObjectInputStream(this.socket.getInputStream());
				Message msg = (Message)this.in.readObject();
				
				if (msg.getType() == MessageType.GAME) {
					((PanelSimulacion)this.panelJuego).addImagenOrganismo(((CoordenadaOrganismo)msg.getValue()).getOrg(), 
					((CoordenadaOrganismo)msg.getValue()).getX(),
					((CoordenadaOrganismo)msg.getValue()).getY());
					this.panelJuego.repaint();
				}
				else if (msg.getType() == MessageType.SIGN_IN_APPROVED) {
					this.panelSign.getTxtFieldUsername().setText("");
					this.panelSign.getTxtFieldPass().setText("");
					this.panelSign.getTxtFieldConfirmPass().setText("");
					this.app.getCardLayout().previous(this.app.getContentPane());
				}
				else if (msg.getType() == MessageType.SIGN_IN_REJECTED) {
					JOptionPane.showMessageDialog(this.app, new String("POR FAVOR, ELIJA OTRO USUARIO"),new String("SIGN IN FAILED"), JOptionPane.ERROR_MESSAGE);
				}
				else if(msg.getType() == MessageType.LOG_IN_APPROVED) {
					this.app.getCardLayout().last(this.app.getContentPane());
				}
				else if(msg.getType() == MessageType.LOG_IN_REJECTED) {
					JOptionPane.showMessageDialog(this.app, new String("Usuario o Contraseña INVALIDO!!"),new String("LOG IN FAILED"), JOptionPane.ERROR_MESSAGE);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch(Exception o) {
				System.out.println("cacho el error");
			}
			
		}
	}

}
