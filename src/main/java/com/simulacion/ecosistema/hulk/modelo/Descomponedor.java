package com.simulacion.ecosistema.hulk.modelo;

public class Descomponedor extends Organismo implements Movible {

	private TipoDescomponedor tipoDescomponedor;

	public Descomponedor(String nombre, int vidaPromedio, String alimentoPrincipal, Reproduccion tipoReproduccion,
			int tasaReproduccion, int tiempoReproduccion, Energia energia, Salud salud, boolean hambre,
			int cantidadAlimento, String pathImagen, TipoDescomponedor tipoDescomponedor) {

		super(nombre, vidaPromedio, alimentoPrincipal, tipoReproduccion, tasaReproduccion, tiempoReproduccion, energia,
				salud, hambre, cantidadAlimento, pathImagen);
		this.tipoDescomponedor = tipoDescomponedor;
	}
	
	public Descomponedor(String nombre, int vidaPromedio, String alimentoPrincipal, int tasaReproduccionAnual, boolean hambre, int cantidadAlimento, String pathImagen) {
		super(nombre,vidaPromedio,alimentoPrincipal,Reproduccion.SEXUAL,tasaReproduccionAnual,hambre,cantidadAlimento,pathImagen);
	}

	// Metodos
	public void moverse() {
		// Cuerpo del metodo
	}

	public void descomponerOrganismo() {
		// Cuerpo del metodo
	}

	// Getters and Setters
	public TipoDescomponedor getTipoDescomponedor() {
		return tipoDescomponedor;
	}

	public void setTipoDescomponedor(TipoDescomponedor tipoDescomponedor) {
		this.tipoDescomponedor = tipoDescomponedor;
	}
}
