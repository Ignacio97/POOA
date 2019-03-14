package com.simulacion.ecosistema.hulk.modelo.simulacion;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class ImagenRectangulo {

	protected Image img = null;
	protected Rectangle rect = null;
	
	public ImagenRectangulo(Image img, int x, int y) {
		this.img = img;
		ImageIcon imgIcon = new ImageIcon(img);
		this.rect = new Rectangle(x, y, imgIcon.getIconWidth(), imgIcon.getIconHeight());
	}

	public Image getImg() {
		return img;
	}

	public Rectangle getRect() {
		return rect;
	}
	
	public void setImg(Image img) {
		this.img = img;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

	public void move(int x, int y) {
		rect.setBounds(x, y, rect.width, rect.height);
	}
	
	public void draw(Graphics2D g2, ImageObserver imgObs) {
		g2.drawImage(img, rect.x, rect.y, rect.width, rect.height, imgObs);
	}
	
}
