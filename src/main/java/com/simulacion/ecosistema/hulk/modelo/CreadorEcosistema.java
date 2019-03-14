package com.simulacion.ecosistema.hulk.modelo;

public class CreadorEcosistema {
	
	public static Ecosistema plantillaBosque() {
		Ecosistema ecosistema;
		Biotopo biotopo;
		Biocenosis biocenosis;
		
		biotopo = new Biotopo("Biotopo Bosque", Temperatura.TEMPLADO, FreqPrecipitacion.SEMANA);
		biocenosis = new Biocenosis();

		// Anadiendo a los organismos productores
		biocenosis.addProductor(new Productor("Arbol", 100, "Sol",3, false, 100,"/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/flora/arbol.png"));
		biocenosis.addProductor(new Productor("Arbusto", 5, "Sol",5, true, 50,"/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/flora/arbusto.png"));
		biocenosis.addProductor(new Productor("Orquidea", 1, "CO2",10, true, 20,"/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/flora/orquidea.png"));
		biocenosis.addProductor(new Productor("Pino", 200, "Sol", 2, false, 120,"/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/flora/pino.png"));
		
		// Anadiendo a los organismos consumidores
		biocenosis.addConsumidor(new Consumidor("Oso", 10, "Lince", 25, false, 3, "/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/fauna/oso.png",TipoConsumidor.TERCIARIO, GradoSuperioridad.MUYALTO));
		biocenosis.addConsumidor(new Consumidor("Venado", 7, "Arbusto",15, false, 5, "/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/fauna/venado.png",TipoConsumidor.PRIMARIO, GradoSuperioridad.MEDIO));
		biocenosis.addConsumidor(new Consumidor("Conejo", 3, "Arbusto",30, false, 5, "/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/fauna/conejo.png",TipoConsumidor.PRIMARIO, GradoSuperioridad.BAJO));
		biocenosis.addConsumidor(new Consumidor("Catarina", 1, "Orquidea",100, true, 2, "/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/fauna/catarina.png",TipoConsumidor.PRIMARIO, GradoSuperioridad.MUYBAJO));
		biocenosis.addConsumidor(new Consumidor("Arana", 2, "Catarina",50, false, 10, "/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/fauna/arana.png",TipoConsumidor.SECUNDARIO, GradoSuperioridad.BAJO));
		biocenosis.addConsumidor(new Consumidor("Ardilla", 4, "Arbusto", 5, true, 5, "/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/fauna/ardilla.png",TipoConsumidor.SECUNDARIO, GradoSuperioridad.ALTO));
		biocenosis.addConsumidor(new Consumidor("Armadillo", 5, "Lombriz", 15, false, 10, "/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/fauna/armadillo.png",TipoConsumidor.PRIMARIO, GradoSuperioridad.BAJO));
		biocenosis.addConsumidor(new Consumidor("Buho", 5, "Arana", 12, true, 10, "/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/fauna/buho.png",TipoConsumidor.PRIMARIO, GradoSuperioridad.MUYBAJO));
		biocenosis.addConsumidor(new Consumidor("Lince", 10, "Venado", 10, false, 1, "/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/fauna/lince.png",TipoConsumidor.TERCIARIO, GradoSuperioridad.MUYALTO));
		biocenosis.addConsumidor(new Consumidor("Lombriz", 12, "Residuos",5, true, 5, "/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/fauna/lombriz.png",TipoConsumidor.SECUNDARIO, GradoSuperioridad.ALTO));
		biocenosis.addConsumidor(new Consumidor("Mapache", 5, "Mariposa", 5, false, 7, "/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/fauna/mapache.png",TipoConsumidor.PRIMARIO, GradoSuperioridad.BAJO));
		biocenosis.addConsumidor(new Consumidor("Mariposa", 5, "Orquidea", 30, false, 2, "/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/fauna/mariposa.png",TipoConsumidor.PRIMARIO, GradoSuperioridad.BAJO));
		biocenosis.addConsumidor(new Consumidor("Pajaro Carpintero", 1, "Lombriz", 10, true, 5, "/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/fauna/pajaroCarpintero.png",TipoConsumidor.PRIMARIO, GradoSuperioridad.MUYBAJO));
		biocenosis.addConsumidor(new Consumidor("Zorro", 10, "Ardilla",10,false, 5, "/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/fauna/zorro.png",TipoConsumidor.TERCIARIO, GradoSuperioridad.MUYALTO));
		
		// Anadiendo a los organismos descomponedores
		biocenosis.addDescomponedor(new Descomponedor("Hongo", 5, "Materia Organica", 30, false, 10,"/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/flora/hongo.png"));
		ecosistema = new Ecosistema("Bosque", biotopo, biocenosis, TipoEcosistema.TERRESTRE,
				"/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/bosque.png");
		return ecosistema;
	}
	
	public static Ecosistema plantillaMar() {
		Ecosistema ecosistema;
		Biotopo biotopo;
		Biocenosis biocenosis;
		
		biotopo = new Biotopo("Biotopo Mar", Temperatura.FRIO, FreqPrecipitacion.NINGUN);
		biocenosis = new Biocenosis();

		// Anadiendo a los organismos productores
		biocenosis.addProductor(new Productor("Alga", 100, "Sol",3, false, 100,"/com/simulacion/ecosistema/hulk/assets/imgs/Bosque/flora/alga1.png"));
		biocenosis.addProductor(new Productor("Coral", 5, "Sol",5, true, 50,"/com/simulacion/ecosistema/hulk/assets/imgs/Acuatico/flora/coral1.png"));
		biocenosis.addProductor(new Productor("Estrella", 1, "CO2",10, true, 20,"/com/simulacion/ecosistema/hulk/assets/imgs/Acuatico/flora/estrella.png"));
		biocenosis.addProductor(new Productor("Nenufar", 200, "Sol", 2, false, 120,"/com/simulacion/ecosistema/hulk/assets/imgs/Acuatico/flora/nenufar.png"));
		biocenosis.addProductor(new Productor("Planta Marina", 200, "Sol", 2, false, 120,"/com/simulacion/ecosistema/hulk/assets/imgs/Acuatico/flora/planta12.png"));
		
		// Anadiendo a los organismos consumidores
		biocenosis.addConsumidor(new Consumidor("Almeja", 10, "Lince", 25, false, 3, "/com/simulacion/ecosistema/hulk/assets/imgs/Acuatico/fauna/almeja.png",TipoConsumidor.TERCIARIO, GradoSuperioridad.MUYALTO));
		biocenosis.addConsumidor(new Consumidor("Ballena", 7, "Arbusto",15, false, 5, "/com/simulacion/ecosistema/hulk/assets/imgs/Acuatico/fauna/ballena.png",TipoConsumidor.PRIMARIO, GradoSuperioridad.MEDIO));
		biocenosis.addConsumidor(new Consumidor("Caballito de Mar", 3, "Arbusto",30, false, 5, "/com/simulacion/ecosistema/hulk/assets/imgs/Acuatico/fauna/caballitoMar.png",TipoConsumidor.PRIMARIO, GradoSuperioridad.BAJO));
		biocenosis.addConsumidor(new Consumidor("Camaron", 1, "Orquidea",100, true, 2, "/com/simulacion/ecosistema/hulk/assets/imgs/Acuatico/fauna/camaron1.png",TipoConsumidor.PRIMARIO, GradoSuperioridad.MUYBAJO));
		biocenosis.addConsumidor(new Consumidor("Cangrejo", 2, "Catarina",50, false, 10, "/com/simulacion/ecosistema/hulk/assets/imgs/Acuatico/fauna/cangrejo.png",TipoConsumidor.SECUNDARIO, GradoSuperioridad.BAJO));
		biocenosis.addConsumidor(new Consumidor("Crustaceo", 4, "Arbusto", 5, true, 5, "/com/simulacion/ecosistema/hulk/assets/imgs/Acuatico/fauna/crustaceo.png",TipoConsumidor.SECUNDARIO, GradoSuperioridad.ALTO));
		biocenosis.addConsumidor(new Consumidor("Delfin", 5, "Lombriz", 15, false, 10, "/com/simulacion/ecosistema/hulk/assets/imgs/Acuatico/fauna/delfin.png",TipoConsumidor.PRIMARIO, GradoSuperioridad.BAJO));
		biocenosis.addConsumidor(new Consumidor("Foca", 5, "Arana", 12, true, 10, "/com/simulacion/ecosistema/hulk/assets/imgs/Acuatico/fauna/foca.png",TipoConsumidor.PRIMARIO, GradoSuperioridad.MUYBAJO));
		biocenosis.addConsumidor(new Consumidor("Medusa", 10, "Venado", 10, false, 1, "/com/simulacion/ecosistema/hulk/assets/imgs/Acuatico/fauna/medusa.png",TipoConsumidor.TERCIARIO, GradoSuperioridad.MUYALTO));
		biocenosis.addConsumidor(new Consumidor("Pez", 12, "Residuos",5, true, 5, "/com/simulacion/ecosistema/hulk/assets/imgs/Acuatico/fauna/pez2.png",TipoConsumidor.SECUNDARIO, GradoSuperioridad.ALTO));
		biocenosis.addConsumidor(new Consumidor("Pulpo", 5, "Mariposa", 5, false, 7, "/com/simulacion/ecosistema/hulk/assets/imgs/Acuatico/fauna/pulpo.png",TipoConsumidor.PRIMARIO, GradoSuperioridad.BAJO));
		biocenosis.addConsumidor(new Consumidor("Tiburon", 5, "Orquidea", 30, false, 2, "/com/simulacion/ecosistema/hulk/assets/imgs/Acuatico/fauna/tiburon.png",TipoConsumidor.PRIMARIO, GradoSuperioridad.BAJO));
		biocenosis.addConsumidor(new Consumidor("Tortuga", 1, "Lombriz", 10, true, 5, "/com/simulacion/ecosistema/hulk/assets/imgs/Acuatico/fauna/tortuga.png",TipoConsumidor.PRIMARIO, GradoSuperioridad.MUYBAJO));
		
		// Anadiendo a los organismos descomponedores
		biocenosis.addDescomponedor(new Descomponedor("Moho", 5, "Materia Organica", 30, false, 10,"/com/simulacion/ecosistema/hulk/assets/imgs/Acuatico/flora/moho.png"));
		biocenosis.addDescomponedor(new Descomponedor("Plancton", 5, "Materia Organica", 30, false, 10,"/com/simulacion/ecosistema/hulk/assets/imgs/Acuatico/flora/plancton.png"));
		
		ecosistema = new Ecosistema("Mar", biotopo, biocenosis, TipoEcosistema.ACUATICO,
				"/com/simulacion/ecosistema/hulk/assets/imgs/Acuatico/arrecife.png");
		return ecosistema;
	}
	
	public static Ecosistema plantillaDesierto() {
		return null;

	}
	
	public static Ecosistema plantillaEstepa() {
		return null;

	}
	
	public static Ecosistema plantillaSabana() {
		return null;

	}
	
	public static Ecosistema plantillaTundra() {
		return null;

	}
	
}
