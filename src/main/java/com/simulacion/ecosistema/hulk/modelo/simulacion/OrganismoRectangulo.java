package com.simulacion.ecosistema.hulk.modelo.simulacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import com.simulacion.ecosistema.hulk.modelo.Organismo;

public class OrganismoRectangulo extends ImagenRectangulo{
	private Organismo organismo = null;
	private int dx;
	private int dy;
	private boolean intersectar = false;

	public OrganismoRectangulo(Organismo organismo, Image img, int x, int dx, int y, int dy) {
		super(img, x, y);
		this.dx = dx;
		this.dy = dy;
		this.organismo = organismo;
	}

	@Override
	public void draw(Graphics2D g2, ImageObserver imgObs) {
		g2.setColor(Color.WHITE);
		g2.setFont(new Font("Dialog", Font.BOLD, 14));
		g2.drawString(organismo.getNombre(), rect.x, rect.y);
		g2.drawImage(img, rect.x, rect.y, rect.width,rect.height, imgObs);
//		g2.drawRect(rect.x, rect.y, rect.width,rect.height);
	}
	
	// Getters y setters
	public Organismo getOrganismo() {
		return organismo;
	}

	public void setOrganismo(Organismo organismo) {
		this.organismo = organismo;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public boolean isIntersectar() {
		return intersectar;
	}
}
