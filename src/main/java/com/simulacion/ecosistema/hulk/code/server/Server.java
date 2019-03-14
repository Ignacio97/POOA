package com.simulacion.ecosistema.hulk.code.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.simulacion.ecosistema.hulk.code.patterns.observer.*;

import com.simulacion.ecosistema.hulk.code.server.*;
import com.simulacion.ecosistema.hulk.modelo.usuarios.Usuario;



public class Server implements Runnable {

	private int port;
	private ServerSocket sSocket = null;
	private Socket incoming = null; // client
	private Thread thread;
	private volatile boolean alive;
	//private ArrayList<GameRoom> rooms = null;
	private GameRoom room; 
	private ArrayList<Usuario> users = null;
	
	public Server(int port) {
		this.port = port;
		
		try {
			this.sSocket = new ServerSocket(this.port);
		} catch (IOException e) {
			System.out.println("Error creating the ServerSocket");
			e.printStackTrace();
		}
		
		this.room = new GameRoom(1234);
		this.alive = false;
		this.thread = new Thread(this); // creating the new thread.
		//this.users = new ArrayList<Usuario>();
	}	

	public void startServer() {
		if(this.alive) return;
		this.alive = true;
		this.thread.start();
		
		try {

			FileInputStream file = new FileInputStream("data.dat");
			ObjectInputStream in = new ObjectInputStream(file);
			ArrayList<Usuario> u = (ArrayList<Usuario>) in.readObject();
			setUsers(u);
			in.close();
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println("no se pudo leer data.dat");
			setUsers(new ArrayList<Usuario>());
		}
	}

	public void stopServer() {
		if(!this.alive) return;
		this.alive = false;
	}

	public void run() {
			int i=0;
		while (this.alive) {

			try {
				System.out.println("esperandoo cliente "+ (i++));
				this.incoming = this.sSocket.accept();
				 ServerHelper helper = new ServerHelper(this.incoming);
				 this.room.addObserver(helper);
				 helper.setServer(this);
				 helper.startService();
				 System.out.println("cliente "+(i-1)+" atendido");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		try {
			this.sSocket.close();
		} catch (IOException e) {
			System.out.println("Error when closing the serverSocket!");
			e.printStackTrace();
		}
	}

	public Observable getRoom() {
		return room;
	}

	public ArrayList<Usuario> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<Usuario> users) {
		this.users = users;
	}



	

	
	

}
