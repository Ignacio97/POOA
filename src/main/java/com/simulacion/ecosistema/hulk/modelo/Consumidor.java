package com.simulacion.ecosistema.hulk.modelo;

public class Consumidor extends Organismo implements Descansable, Movible {

	private TipoConsumidor tipoConsumidor;
	private GradoSuperioridad gradoSuperioridad;
	private int horasSueno; // horas de sueño

	public Consumidor(String nombre, int vidaPromedio, String alimentoPrincipal, Reproduccion tipoReproduccion,
			int tasaReproduccion, int tiempoReproduccion, Energia energia, Salud salud, boolean hambre,
			int cantidadAlimento, String pathImagen, TipoConsumidor tipoConsumidor, GradoSuperioridad gradoSuperioridad,
			int horasSueno) {

		super(nombre, vidaPromedio, alimentoPrincipal, tipoReproduccion, tasaReproduccion, tiempoReproduccion, energia,
				salud, hambre, cantidadAlimento, pathImagen);
		this.tipoConsumidor = tipoConsumidor;
		this.gradoSuperioridad = gradoSuperioridad;
		this.horasSueno = horasSueno;
	}
	
	public Consumidor(String nombre, int vidaPromedio, String alimentoPrincipal, int tasaReproduccionAnual, boolean hambre, int cantidadAlimento, String pathImagen, TipoConsumidor tipoConsumidor, GradoSuperioridad gradoSuperioridad) {
		super(nombre,vidaPromedio,alimentoPrincipal,Reproduccion.SEXUAL,tasaReproduccionAnual,hambre,cantidadAlimento,pathImagen);
		this.tipoConsumidor = tipoConsumidor;
		this.gradoSuperioridad = gradoSuperioridad;
	}

	// Metodos
	public void moverse() {
		// Cuerpo del metodo
	}

	public void dormir() {
		// Cuerpo del metodo
	}

	public void despertar() {
		// Cuerpo del metodo
	}

	// Getters and setters
	public TipoConsumidor getTipoConsumidor() {
		return tipoConsumidor;
	}

	public void setTipoConsumidor(TipoConsumidor tipoConsumidor) {
		this.tipoConsumidor = tipoConsumidor;
	}

	public GradoSuperioridad getGradoSuperioridad() {
		return gradoSuperioridad;
	}

	public void setGradoSuperioridad(GradoSuperioridad gradoSuperioridad) {
		this.gradoSuperioridad = gradoSuperioridad;
	}

	public int getHorasSueno() {
		return horasSueno;
	}

	public void setHorasSueno(int horasSueno) {
		this.horasSueno = horasSueno;
	}

}
