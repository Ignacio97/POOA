package com.simulacion.ecosistema.hulk.modelo;

public class Ecosistema {
	private String nombre;
	private Biotopo biotopo;
	private Biocenosis biocenosis;
	private TipoEcosistema tipoEcosistema;
	
	private String pathImagen; // path de la imagen de fondo
	private boolean creadoPorAdmin = false; // si es inventado/creado por el administrador
	
	public Ecosistema(String nombre, Biotopo biotopo, Biocenosis biocenosis, TipoEcosistema tipoEcosistema,
			String pathImagen) {
		this.nombre = nombre;
		this.biotopo = biotopo;
		this.biocenosis = biocenosis;
		this.tipoEcosistema = tipoEcosistema;
		this.pathImagen = pathImagen;
	}

	// Metodos
	public int numOrganismos() {
		// Se obtiene el numero de organismo con los que cuenta el ecosistema
		return biocenosis.getNumConsumidores()+biocenosis.getNumDescomponedores()+biocenosis.getNumProductores();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Biotopo getBiotopo() {
		return biotopo;
	}

	public void setBiotopo(Biotopo biotopo) {
		this.biotopo = biotopo;
	}

	public Biocenosis getBiocenosis() {
		return biocenosis;
	}

	public void setBiocenosis(Biocenosis biocenosis) {
		this.biocenosis = biocenosis;
	}

	public TipoEcosistema getTipoEcosistema() {
		return tipoEcosistema;
	}

	public void setTipoEcosistema(TipoEcosistema tipoEcosistema) {
		this.tipoEcosistema = tipoEcosistema;
	}

	public String getPathImagen() {
		return pathImagen;
	}

	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}

	public boolean isCreadoPorAdmin() {
		return creadoPorAdmin;
	}

	public void setCreadoPorAdmin(boolean creadoPorAdmin) {
		this.creadoPorAdmin = creadoPorAdmin;
	}
}
