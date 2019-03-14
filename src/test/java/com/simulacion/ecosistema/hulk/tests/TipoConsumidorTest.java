package com.simulacion.ecosistema.hulk.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.simulacion.ecosistema.hulk.modelo.TipoConsumidor;;

class TipoConsumidorTest {

	@Test
	public void TestTipoConsumidor() {
		
		assertEquals("PRIMARIO", TipoConsumidor.PRIMARIO.name());
		assertEquals("SECUNDARIO", TipoConsumidor.SECUNDARIO.name());
		assertEquals("TERCIARIO", TipoConsumidor.TERCIARIO.name());
		
	}

}
