package com.simulacion.ecosistema.hulk.modelo;

import java.util.ArrayList;

public class Biocenosis {
	private ArrayList<Productor> productores;
	private ArrayList<Consumidor> consumidores;
	private ArrayList<Descomponedor> descomponedores;
	
	public Biocenosis() {
		productores = new ArrayList<Productor>();
		consumidores = new ArrayList<Consumidor>();
		descomponedores = new ArrayList<Descomponedor>();
	}
	
	// Metodos
	public int getNumProductores() {
		return productores.size();
	}
	
	public int getNumConsumidores() {
		return consumidores.size();
	}
	
	public int getNumDescomponedores() {
		return descomponedores.size();
	}

	public void addProductor(Productor productor) {
		productores.add(productor);
	}
	
	public ArrayList<Productor> getProductores() {
		return productores;
	}

	public void addConsumidor(Consumidor consumidor) {
		consumidores.add(consumidor);
	}
	
	public ArrayList<Consumidor> getConsumidores() {
		return consumidores;
	}

	public void addDescomponedor(Descomponedor descomponedor) {
		descomponedores.add(descomponedor);
	}
		
	public ArrayList<Descomponedor> getDescomponedores() {
		return descomponedores;
	}
}
