package com.simulacion.ecosistema.hulk.code.patterns.observer;

public interface Observable {
	public void addObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers(Object args);
}
