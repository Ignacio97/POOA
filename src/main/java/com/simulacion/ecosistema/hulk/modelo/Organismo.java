package com.simulacion.ecosistema.hulk.modelo;

import java.io.Serializable;

public abstract class Organismo implements Alimentable, Reproducible, Morible,Serializable{
	protected String nombre;
	protected int vidaPromedio;
	protected String alimentoPrincipal;	// nombre del alimento principal, ya sea otro organismo o un recurso natural
	protected Reproduccion tipoReproduccion;
	protected int tasaReproduccionAnual;		// cada cuanto se reproduce
	protected int tiempoReproduccion;
	protected Energia energia;
	protected Salud salud;
	protected boolean hambre;				// si el organismo tiene hambre
	protected int cantidadAlimento;		// cuantas veces debe comer su alimento principal para que no tenga hambre
	
	protected String pathImagen;
	
	// Constructor
	public Organismo() {}
	
	public Organismo(String nombre, int vidaPromedio, String alimentoPrincipal, Reproduccion tipoReproduccion,
			int tasaReproduccionAnual, int tiempoReproduccion, Energia energia, Salud salud, boolean hambre,
			int cantidadAlimento, String pathImagen) {
		this.nombre = nombre;
		this.vidaPromedio = vidaPromedio;
		this.alimentoPrincipal = alimentoPrincipal;
		this.tipoReproduccion = tipoReproduccion;
		this.tasaReproduccionAnual = tasaReproduccionAnual;
		this.tiempoReproduccion = tiempoReproduccion;
		this.energia = Energia.ALTA;
		this.salud = Salud.ALTA;
		this.hambre = hambre;
		this.cantidadAlimento = cantidadAlimento;
		
		this.pathImagen = pathImagen;
	}
	
	public Organismo(String nombre, int vidaPromedio, String alimentoPrincipal, Reproduccion tipoReproduccion,
			int tasaReproduccionAnual, boolean hambre, int cantidadAlimento, String pathImagen) {
		this.nombre = nombre;
		this.vidaPromedio = vidaPromedio;
		this.alimentoPrincipal = alimentoPrincipal;
		this.tipoReproduccion = tipoReproduccion;
		this.tasaReproduccionAnual = tasaReproduccionAnual;
		this.energia = Energia.ALTA;
		this.salud = Salud.ALTA;
		this.hambre = hambre;
		this.cantidadAlimento = cantidadAlimento;
		
		this.pathImagen = pathImagen;
	}
	
	
	// Metodos
	public String alimentarse() {
		return "";
	}

	public String reproducirse() {
		return "";
	}

	public String morir() {
		return "";
	}

	
	// Getters and setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVidaPromedio() {
		return vidaPromedio;
	}

	public void setVidaPromedio(int vidaPromedio) {
		this.vidaPromedio = vidaPromedio;
	}

	public String getAlimentoPrincipal() {
		return alimentoPrincipal;
	}

	public void setAlimentoPrincipal(String alimentoPrincipal) {
		this.alimentoPrincipal = alimentoPrincipal;
	}

	public Reproduccion getTipoReproduccion() {
		return tipoReproduccion;
	}

	public void setTipoReproduccion(Reproduccion tipoReproduccion) {
		this.tipoReproduccion = tipoReproduccion;
	}

	public int getTasaReproduccionAnual() {
		return tasaReproduccionAnual;
	}

	public void setTasaReproduccionAnual(int tasaReproduccion) {
		this.tasaReproduccionAnual = tasaReproduccion;
	}

	public int getTiempoReproduccion() {
		return tiempoReproduccion;
	}

	public void setTiempoReproduccion(int tiempoReproduccion) {
		this.tiempoReproduccion = tiempoReproduccion;
	}

	public Energia getEnergia() {
		return energia;
	}

	public void setEnergia(Energia energia) {
		this.energia = energia;
	}

	public Salud getSalud() {
		return salud;
	}

	public void setSalud(Salud salud) {
		this.salud = salud;
	}

	public boolean isHambre() {
		return hambre;
	}

	public void setHambre(boolean hambre) {
		this.hambre = hambre;
	}

	public int getCantidadAlimento() {
		return cantidadAlimento;
	}

	public void setCantidadAlimento(int cantidadAlimento) {
		this.cantidadAlimento = cantidadAlimento;
	}

	public String getPathImagen() {
		return pathImagen;
	}

	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}
}
