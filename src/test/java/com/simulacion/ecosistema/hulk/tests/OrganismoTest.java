package com.simulacion.ecosistema.hulk.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.simulacion.ecosistema.hulk.modelo.Energia;
import com.simulacion.ecosistema.hulk.modelo.Organismo;
import com.simulacion.ecosistema.hulk.modelo.Reproduccion;
import com.simulacion.ecosistema.hulk.modelo.Salud;

class OrganismoTest {
	
	EspecieDeOrganismo organismo = new EspecieDeOrganismo("Perro",10,"Croquetas",Reproduccion.SEXUAL,8,60,Energia.ALTA,Salud.ALTA,true,50);
	
	@Test
	public void testAtributos() {
		assertEquals("Perro",organismo.getNombre());
		assertEquals(10,organismo.getVidaPromedio());
		assertEquals("Croquetas",organismo.getAlimentoPrincipal());
		assertEquals(Reproduccion.SEXUAL,organismo.getTipoReproduccion());
		assertEquals(8,organismo.getTasaReproduccionAnual());
		assertEquals(60,organismo.getTiempoReproduccion());
		assertEquals(Energia.ALTA,organismo.getEnergia());
		assertEquals(Salud.ALTA,organismo.getSalud());
		assertEquals(true,organismo.isHambre());
		assertEquals(50,organismo.getCantidadAlimento());
		assertEquals(null,organismo.getPathImagen());
	}
	
	@Test
	public void testMetodosInterfaz() {
		assertEquals("Perro se esta alimentando de Croquetas", organismo.alimentarse());
		assertEquals("Perro se reproduce en un tiempo de 60 8 veces al anyo", organismo.reproducirse());
		assertEquals("Perro ha muerto tras haber vivido 10", organismo.morir());
	}

}

class EspecieDeOrganismo extends Organismo {
	public EspecieDeOrganismo(String nombre, int vidaPromedio, String alimentoPrincipal, Reproduccion tipoReproduccion,
			int tasaReproduccionAnual, int tiempoReproduccion, Energia energia, Salud salud, boolean hambre,
			int cantidadAlimento) {
			super(nombre,vidaPromedio,alimentoPrincipal,tipoReproduccion,tasaReproduccionAnual,
				tiempoReproduccion,energia,salud,hambre,cantidadAlimento,null);
	}
	
	@Override
	public String alimentarse() {
		return (nombre+" se esta alimentando de "+alimentoPrincipal);
	}
	
	@Override
	public String reproducirse() {
		return(nombre+" se reproduce en un tiempo de "+tiempoReproduccion+" "+tasaReproduccionAnual+" veces al anyo");
	}
	
	@Override
	public String morir() {
		return(nombre+" ha muerto tras haber vivido "+vidaPromedio);
	}
}
