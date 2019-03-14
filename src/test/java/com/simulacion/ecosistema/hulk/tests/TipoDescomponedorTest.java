package com.simulacion.ecosistema.hulk.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.simulacion.ecosistema.hulk.modelo.TipoDescomponedor;;

class TipoDescomponedorTest {

	@Test
	public void TestTipoDescomponedor() {
		
		assertEquals("HONGO", TipoDescomponedor.HONGO.name());
		assertEquals("BACTERIA", TipoDescomponedor.BACTERIA.name());
	}

}
