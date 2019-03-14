package com.simulacion.ecosistema.hulk.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.simulacion.ecosistema.hulk.modelo.FreqPrecipitacion;
class FreqPrecipitacionTest {

	@Test
	public void TestFreqPrecipitacion() {
		assertEquals("DIA", FreqPrecipitacion.DIA.name());
		assertEquals("MES", FreqPrecipitacion.MES.name());
		assertEquals("ANYO", FreqPrecipitacion.ANYO.name());
	}

}
