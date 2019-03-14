package com.simulacion.ecosistema.hulk.modelo;

public class Biotopo {
	private String nombre;		// nombre del ambiente fisico / biotopo
	private Temperatura temperatura;
	private FreqPrecipitacion freqPrecipitacion;
	
	public Biotopo(String nombre, Temperatura temperatura, FreqPrecipitacion freqPrecipitacion) {
		this.nombre = nombre;
		this.temperatura = temperatura;
		this.freqPrecipitacion = freqPrecipitacion;
	}
	
	// Getters and setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Temperatura getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Temperatura temperatura) {
		this.temperatura = temperatura;
	}
	public FreqPrecipitacion getFreqPrecipitacion() {
		return freqPrecipitacion;
	}
	public void setFreqPrecipitacion(FreqPrecipitacion freqPrecipitacion) {
		this.freqPrecipitacion = freqPrecipitacion;
	}
}
