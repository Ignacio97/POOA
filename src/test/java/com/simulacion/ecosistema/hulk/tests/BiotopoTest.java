package com.simulacion.ecosistema.hulk.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.simulacion.ecosistema.hulk.modelo.Biotopo;
import com.simulacion.ecosistema.hulk.modelo.FreqPrecipitacion;
import com.simulacion.ecosistema.hulk.modelo.Temperatura;

class BiotopoTest {

	@Test
	public void getNombreTest() {
		
        Biotopo miBiotopo = new Biotopo("Biotopo Ejemplo",Temperatura.CALIENTE,FreqPrecipitacion.MES);
        miBiotopo.setNombre("Biotopo Nuevo");
        assertTrue(miBiotopo.getNombre() == "Biotopo Nuevo");
	}
	
	@Test
    public void setNombreTest(){
		
		Biotopo miBiotopo = new Biotopo(null, null, null);
        miBiotopo.setNombre("test2");
        assertTrue(miBiotopo.getNombre() == "test2");
    }

}
