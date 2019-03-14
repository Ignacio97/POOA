package com.simulacion.ecosistema.hulk.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.simulacion.ecosistema.hulk.modelo.Temperatura;;

class TemperaturaTest {

	@Test
	public void TestTemperatura() {

		assertEquals("FRIO", Temperatura.FRIO.name());
		assertEquals("TEMPLADO", Temperatura.TEMPLADO.name());
		assertEquals("CALIENTE", Temperatura.CALIENTE.name());
	}

}
