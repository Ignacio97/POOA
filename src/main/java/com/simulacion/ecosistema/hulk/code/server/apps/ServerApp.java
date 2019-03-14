package com.simulacion.ecosistema.hulk.code.server.apps;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JTextField;
import com.simulacion.ecosistema.hulk.code.server.*;
import com.simulacion.ecosistema.hulk.modelo.usuarios.Usuario;

public class ServerApp extends JFrame {
	private JButton btnStart;
	private JButton btnStop;
	private JTextField portField;
	private Server server = null;
	private JLabel lblPort = new JLabel("Port:", SwingConstants.CENTER);

	public ServerApp() {
		portField = new JTextField();
		setTitle("SERVER");
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		btnStart = new JButton("Start");
		panel.add(btnStart);
		btnStop = new JButton("Stop");
		panel.add(btnStop);
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		lblPort.setBounds(48, 83, 29, 16);
		panel_3.add(lblPort);
		portField.setBounds(106, 78, 130, 26);
		portField.setColumns(10);
		panel_3.add(portField);
		btnStart.setActionCommand("START");
		btnStop.setActionCommand("STOP");
		btnStart.addActionListener(new Controller());
		btnStop.addActionListener(new Controller());
		setSize(300, 236);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.addWindowListener(new Controller());

		
		
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerApp app = new ServerApp();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	private class Controller extends WindowAdapter implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();

			if ((command.equals("START")) && (server == null)) {
				if (portField.getText().equals("") == false) {
					int port = Integer.parseInt(portField.getText());
					server = new Server(port);
					server.startServer();
					System.out.println("Servidor Corriendo!");
					lblPort.setText("");

					portField.setText("Servidor Corriendo!");
					portField.setEnabled(false);
				}
			} else if (command.equals("STOP")) {
				if (server == null)
					return;
				server.stopServer();
				System.out.println("Server stopped!!");

				lblPort.setText("Port");

				portField.setText("");
				portField.setEnabled(true);
			}
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			super.windowClosing(e);

			try {

				FileOutputStream file = new FileOutputStream("data.dat");
				ObjectOutputStream o = new ObjectOutputStream(file);
				o.writeObject(server.getUsers());
				o.close();
				System.exit(0);
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("no se pudo guardar data.dat");
			}
		}

		
	}}
