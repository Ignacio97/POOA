package com.simulacion.ecosistema.hulk.modelo;

public class Productor extends Organismo {

	private boolean comestible;
	private TipoPlanta tipoPlanta;

	
	// Metodos constructores
	public Productor(String nombre, int vidaPromedio, String alimentoPrincipal, Reproduccion tipoReproduccion,
			int tasaReproduccion, int tiempoReproduccion, Energia energia, Salud salud, boolean hambre,
			int cantidadAlimento, String pathImagen, boolean comestible, TipoPlanta tipoPlanta) {
		
		super(nombre, vidaPromedio, alimentoPrincipal, tipoReproduccion, tasaReproduccion, tiempoReproduccion, energia,
				salud, hambre, cantidadAlimento, pathImagen);
		
		this.comestible = comestible;
		this.tipoPlanta = tipoPlanta;
	}
	
	public Productor(String nombre, int vidaPromedio, String alimentoPrincipal, int tasaReproduccionAnual, boolean hambre, int cantidadAlimento, String pathImagen) {
		super(nombre,vidaPromedio,alimentoPrincipal,Reproduccion.ASEXUAL,tasaReproduccionAnual,hambre,cantidadAlimento,pathImagen);
	}
	
	// Metodos
	public void fotosintesis() {
		// Cuerpo del metodo
	}

	// Getters and setters
	public boolean isComestible() {
		return comestible;
	}

	public void setComestible(boolean comestible) {
		this.comestible = comestible;
	}

	public TipoPlanta getTipoPlanta() {
		return tipoPlanta;
	}

	public void setTipoPlanta(TipoPlanta tipoPlanta) {
		this.tipoPlanta = tipoPlanta;
	}
}
