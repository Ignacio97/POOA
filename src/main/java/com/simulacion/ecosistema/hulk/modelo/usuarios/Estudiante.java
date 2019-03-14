package com.simulacion.ecosistema.hulk.modelo.usuarios;

public class Estudiante extends Usuario{
	private int calificacion;
	private RegistroPartida registroPartidas;
	
	public Estudiante(String nombre, String password) {
		super(nombre, password);
		calificacion = -1;			
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	
}
