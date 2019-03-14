package com.simulacion.ecosistema.hulk.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.simulacion.ecosistema.hulk.modelo.Energia;

class EnergiaTest {

	@Test
	public void TestEnergia() {
		assertEquals("ALTA", Energia.ALTA.name());
		assertEquals("MEDIA", Energia.MEDIA.name());
		assertEquals("BAJA", Energia.BAJA.name());
	}

}
