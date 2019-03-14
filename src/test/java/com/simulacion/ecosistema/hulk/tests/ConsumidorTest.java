package com.simulacion.ecosistema.hulk.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.simulacion.ecosistema.hulk.modelo.Consumidor;
import com.simulacion.ecosistema.hulk.modelo.Energia;
import com.simulacion.ecosistema.hulk.modelo.GradoSuperioridad;
import com.simulacion.ecosistema.hulk.modelo.Reproduccion;
import com.simulacion.ecosistema.hulk.modelo.Salud;
import com.simulacion.ecosistema.hulk.modelo.TipoConsumidor;;

class ConsumidorTest {

	Consumidor cons = new Consumidor("Oso", 10, "Lince", 25, false, 3, "/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/fauna/oso.png",TipoConsumidor.TERCIARIO, GradoSuperioridad.MUYALTO);
	Consumidor cons2 = new Consumidor("Venado", 7, "Arbusto",Reproduccion.SEXUAL,15, 90, Energia.ALTA, Salud.ALTA, true, 5, "/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/fauna/venado.png",TipoConsumidor.PRIMARIO, GradoSuperioridad.MEDIOALTO, 6);
	@Test
	public void testAtributosConstructorCorto() {
		assertEquals("Oso",cons.getNombre());
		assertEquals(10,cons.getVidaPromedio());
		assertEquals("Lince",cons.getAlimentoPrincipal());
		assertEquals(25,cons.getTasaReproduccionAnual());
		assertEquals(false,cons.isHambre());
		assertEquals(3,cons.getCantidadAlimento());
		assertEquals("/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/fauna/oso.png",cons.getPathImagen());
		assertEquals(TipoConsumidor.TERCIARIO,cons.getTipoConsumidor());
		assertEquals(Reproduccion.SEXUAL,cons.getTipoReproduccion());
		assertEquals(Energia.ALTA,cons.getEnergia());
		assertEquals(Salud.ALTA,cons.getSalud());
		assertEquals(GradoSuperioridad.MUYALTO, cons.getGradoSuperioridad());
	}
	
	@Test
	public void testAtributosConstructorLargo() {
		assertEquals("Venado",cons2.getNombre());
		assertEquals(7,cons2.getVidaPromedio());
		assertEquals("Arbusto",cons2.getAlimentoPrincipal());
		assertEquals(15,cons2.getTasaReproduccionAnual());
		assertEquals(90,cons2.getTiempoReproduccion());
		assertEquals(Energia.ALTA,cons2.getEnergia());
		assertEquals(Salud.ALTA,cons2.getSalud());
		assertEquals(true,cons2.isHambre());
		assertEquals(5,cons2.getCantidadAlimento());
		assertEquals("/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/fauna/venado.png",cons2.getPathImagen());
		assertEquals(TipoConsumidor.PRIMARIO,cons2.getTipoConsumidor());
		assertEquals(Reproduccion.SEXUAL,cons2.getTipoReproduccion());
		assertEquals(GradoSuperioridad.MEDIOALTO, cons2.getGradoSuperioridad());
		assertEquals(6, cons2.getHorasSueno());
	}
}
