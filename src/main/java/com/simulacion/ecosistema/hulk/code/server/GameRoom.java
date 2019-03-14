package com.simulacion.ecosistema.hulk.code.server;

import java.util.ArrayList;

import com.simulacion.ecosistema.hulk.code.patterns.observer.*;

public class GameRoom implements Observable {
	
	private int id;
	private ArrayList<Observer> players = null;
	
	

	public GameRoom(int id) {
		this.players = new ArrayList<Observer>();
		this.id = id;
	}

	public void addObserver(Observer o) {
		this.players.add(o);
	}

	public void removeObserver(Observer o) {
		int i = this.players.indexOf(o);
		
		if (i >= 0) {
			this.players.remove(i);
		}
	}
	public void notifyObservers(Object args) {
		for (Observer o : this.players) {
			o.update(args);
		}

	}

}
