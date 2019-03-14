package com.simulacion.ecosistema.hulk.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.simulacion.ecosistema.hulk.modelo.TipoPlanta;

class TipoPlantaTest {

	@Test
	public void TestTipoPlanta() {
		assertEquals("ARBUSTO", TipoPlanta.ARBUSTO.name());
		assertEquals("MATA", TipoPlanta.MATA.name());
		assertEquals("HIERBA", TipoPlanta.HIERBA.name());
		assertEquals("ARBOL", TipoPlanta.ARBOL.name());
	}

	
}
