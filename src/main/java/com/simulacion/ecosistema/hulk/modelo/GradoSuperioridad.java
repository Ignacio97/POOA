package com.simulacion.ecosistema.hulk.modelo;

public enum GradoSuperioridad {
	MUYBAJO(1),BAJO(2),MEDIO(3),MEDIOALTO(4),ALTO(5),MUYALTO(6);
	
	private int nivel;
	
	private GradoSuperioridad(int nivel) {
		this.nivel = nivel;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
}
