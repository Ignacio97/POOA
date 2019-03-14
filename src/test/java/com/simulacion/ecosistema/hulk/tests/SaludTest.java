package com.simulacion.ecosistema.hulk.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.simulacion.ecosistema.hulk.modelo.Salud;
class SaludTest {

	@Test
	public void TestSalud() {

		assertEquals("ALTA", Salud.ALTA.name());
		assertEquals("MEDIA", Salud.MEDIA.name());
		assertEquals("BAJA", Salud.BAJA.name());
	}

}
