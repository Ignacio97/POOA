package com.simulacion.ecosistema.hulk.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.simulacion.ecosistema.hulk.modelo.TipoEcosistema;

class TipoEcosistemaTest {

	@Test
	public void TestTipoEcosistema() {
		
		assertEquals("ACUATICO", TipoEcosistema.ACUATICO.name());
		assertEquals("TERRESTRE", TipoEcosistema.TERRESTRE.name());
		
		
	}

}
