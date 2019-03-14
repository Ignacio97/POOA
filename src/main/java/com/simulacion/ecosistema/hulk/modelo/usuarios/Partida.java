package com.simulacion.ecosistema.hulk.modelo.usuarios;

import java.io.Serializable;

public class Partida implements Serializable{
	private String ecosistemaPartida;
	private int tiempo;
	private int puntuacion;
	
	public Partida(String ecosistemaPartida, int tiempo, int puntuacion) {
		this.ecosistemaPartida = ecosistemaPartida;
		this.tiempo = tiempo;
		this.puntuacion = puntuacion;
	}
	
	public Partida(String ecosistemaPartida) {
		this.ecosistemaPartida = ecosistemaPartida;
		this.tiempo = 0;
		this.puntuacion = 0;
	}

	public String getEcosistemaPartida() {
		return ecosistemaPartida;
	}

	public void setEcosistemaPartida(String ecosistemaPartida) {
		this.ecosistemaPartida = ecosistemaPartida;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
}
