package com.simulacion.ecosistema.hulk.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.simulacion.ecosistema.hulk.modelo.Reproduccion;

class ReproduccionTest {

	@Test
	public void TestReproduccion() {
		
		assertEquals("SEXUAL", Reproduccion.SEXUAL.name());
		assertEquals("ASEXUAL", Reproduccion.ASEXUAL.name());
	}

}
