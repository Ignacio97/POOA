package com.simulacion.ecosistema.hulk.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.simulacion.ecosistema.hulk.modelo.GradoSuperioridad;


class GradoSuperioridadTest {

	@Test
	public void TestGradoSuperioridad() {
		
		assertEquals("MUYBAJO", GradoSuperioridad.MUYBAJO.name());
		assertEquals("BAJO", GradoSuperioridad.BAJO.name());
		assertEquals("MEDIO", GradoSuperioridad.MEDIO.name());
		assertEquals("MEDIOALTO", GradoSuperioridad.MEDIOALTO.name());
		assertEquals("ALTO", GradoSuperioridad.ALTO.name());
	
	}
	/*private GradoSuperioridad(int nivel) {
		this.nivel = nivel;
	}*/
	
	@Test
	public void GetNivelTest(){
		
		GradoSuperioridad miGradoSuper =  GradoSuperioridad.ALTO;
		miGradoSuper.setNivel(2);
		assertTrue(miGradoSuper.getNivel() == 2);
		
	}
	
	@Test
	public void SetNivelTest() {
		
		GradoSuperioridad miGradoSuper =  GradoSuperioridad.BAJO;
		miGradoSuper.setNivel(3);
		assertTrue(miGradoSuper.getNivel() == 3);
		
		
	}

}
