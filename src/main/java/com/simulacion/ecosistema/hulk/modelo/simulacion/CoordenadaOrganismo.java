package com.simulacion.ecosistema.hulk.modelo.simulacion;

import java.io.Serializable;

import com.simulacion.ecosistema.hulk.modelo.Organismo;

public class CoordenadaOrganismo implements Serializable{
		 private int x ;
		 private int y;
		 private Organismo org;
		
		 public CoordenadaOrganismo(Organismo o,int x, int y) {
			this.x = x;
			this.y = y;
			this.org = o;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public Organismo getOrg() {
			return org;
		}
		 
		 
}