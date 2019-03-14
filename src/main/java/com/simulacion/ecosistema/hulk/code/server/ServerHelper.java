package com.simulacion.ecosistema.hulk.code.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import com.simulacion.ecosistema.hulk.code.patterns.observer.Observer;
import com.simulacion.ecosistema.hulk.modelo.usuarios.Usuario;

public class ServerHelper extends Thread implements Observer {
	private Socket s = null;
	private ObjectInputStream in = null;
	private ObjectOutputStream out = null;
	private boolean alive;
	private Server server = null;

	public ServerHelper(Socket s) {
		this.s = s;
		this.alive = false;
	}

	public void stopService() {
		if (!this.alive)
			return;
		this.alive = false;
	}

	public void startService() {
		if (this.alive)
			return;

		this.alive = true;
		this.start();

	}

	@Override
	public void run() {
		List<Usuario> usrlist = this.server.getUsers();
		while (this.alive) {

			try {
				System.out.println("esperando mensaje");
				this.in = new ObjectInputStream(this.s.getInputStream());
				Message message = (Message) this.in.readObject();

				if (message.getType() == MessageType.GAME) {
					this.server.getRoom().notifyObservers(message);
				} else if (message.getType() == MessageType.LOG_IN_REQUEST) {
					this.out = new ObjectOutputStream(this.s.getOutputStream());

					if (usrlist.contains((Usuario) message.getValue())) {
						this.out.writeObject(new Message(MessageType.LOG_IN_APPROVED));
					} else {
						this.out.writeObject(new Message(MessageType.LOG_IN_REJECTED));
					}
				} else if (message.getType() == MessageType.SIGN_IN_REQUEST) {

					this.out = new ObjectOutputStream(this.s.getOutputStream());

					
					for(Usuario u:usrlist) {
						if (u.getNombre().equals(((Usuario)message.getValue()).getNombre())) {
							this.out.writeObject(new Message(MessageType.SIGN_IN_REJECTED));
							return;
						}
					}
					
						this.out.writeObject(new Message(MessageType.SIGN_IN_APPROVED));
						usrlist.add((Usuario) message.getValue());
				
				}

			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception o) {
				o.printStackTrace();
			}

		}
	}

	public void update(Object args) {
		ObjectOutputStream o = null;
		try {
			o = new ObjectOutputStream(this.s.getOutputStream());
			o.writeObject(args);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setServer(Server server) {
		this.server = server;
	}

}
