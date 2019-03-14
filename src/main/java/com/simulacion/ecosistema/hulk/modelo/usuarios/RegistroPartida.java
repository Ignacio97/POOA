package com.simulacion.ecosistema.hulk.modelo.usuarios;

import java.io.Serializable;

public class RegistroPartida implements Serializable {
	private Partida[] partidas;
	
	public RegistroPartida () {
		partidas = new Partida[6];
		partidas[0] = new Partida("Bosque");
		partidas[1] = new Partida("Mar");
		partidas[2] = new Partida("Desierto");
		partidas[3] = new Partida("Estepa");
		partidas[4] = new Partida("Sabana");
		partidas[5] = new Partida("Tundra");
	}

	// Metodo getter
	public Partida[] getPartidas() {
		return partidas;
	}
	
	// Metodos para la puntuacion de la partida
	public int getPuntuacionBosque() {
		return partidas[0].getPuntuacion();
	}
	public int getPuntuacionMar() {
		return partidas[1].getPuntuacion();
	}
	public int getPuntuacionDesierto() {
		return partidas[2].getPuntuacion();
	}
	public int getPuntuacionEstepa() {
		return partidas[3].getPuntuacion();
	}
	public int getPuntuacionSabana() {
		return partidas[4].getPuntuacion();
	}
	public int getPuntuacionTundra() {
		return partidas[5].getPuntuacion();
	}
	
	public void setPuntuacionBosque(int tiempo) {
		partidas[0].setPuntuacion(tiempo);
	}
	public void setPuntuacionMar(int tiempo) {
		partidas[1].setPuntuacion(tiempo);
	}
	public void setPuntuacionDesierto(int tiempo) {
		partidas[2].setPuntuacion(tiempo);
	}
	public void setPuntuacionEstepa(int tiempo) {
		partidas[3].setPuntuacion(tiempo);
	}
	public void setPuntuacionSabana(int tiempo) {
		partidas[4].setPuntuacion(tiempo);
	}
	public void setPuntuacionTundra(int tiempo) {
		partidas[5].setPuntuacion(tiempo);
	}
	
	// Metodos para el tiempo de la partida
	public int getTiempoBosque() {
		return partidas[0].getTiempo();
	}
	public int getTiempoMar() {
		return partidas[1].getTiempo();
	}
	public int getTiempoDesierto() {
		return partidas[2].getTiempo();
	}
	public int getTiempoEstepa() {
		return partidas[3].getTiempo();
	}
	public int getTiempoSabana() {
		return partidas[4].getTiempo();
	}
	public int getTiempoTundra() {
		return partidas[5].getTiempo();
	}
	
	public void setTiempoBosque(int tiempo) {
		partidas[0].setPuntuacion(tiempo);
	}
	public void setTiempoMar(int tiempo) {
		partidas[1].setPuntuacion(tiempo);
	}
	public void setTiempoDesierto(int tiempo) {
		partidas[2].setPuntuacion(tiempo);
	}
	public void setTiempoEstepa(int tiempo) {
		partidas[3].setPuntuacion(tiempo);
	}
	public void setTiempoSabana(int tiempo) {
		partidas[4].setPuntuacion(tiempo);
	}
	public void setTiempoTundra(int tiempo) {
		partidas[5].setPuntuacion(tiempo);
	}
	
}
