package com.simulacion.ecosistema.hulk.gui.appEstudiante;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JPanel;

import com.simulacion.ecosistema.hulk.modelo.Descomponedor;
import com.simulacion.ecosistema.hulk.modelo.Ecosistema;
import com.simulacion.ecosistema.hulk.modelo.Organismo;
import com.simulacion.ecosistema.hulk.modelo.Productor;
import com.simulacion.ecosistema.hulk.modelo.simulacion.ImagenRectangulo;
import com.simulacion.ecosistema.hulk.modelo.simulacion.OrganismoRectangulo;

public class PanelSimulacion extends JPanel implements Runnable {

	Ecosistema ecoistema;
	ImagenRectangulo imgBackground = null;
	ArrayList<OrganismoRectangulo> imgsOrganismos;
	boolean isRunning = true;
	boolean interseccion = false;

	public PanelSimulacion(Ecosistema ecosistema) {

		this.ecoistema = ecosistema;
		setEcoistemaBackground(ecosistema);

		imgsOrganismos = new ArrayList<OrganismoRectangulo>();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		imgBackground.draw((Graphics2D) g, this);
		for (OrganismoRectangulo orgImg : imgsOrganismos) {
			orgImg.draw((Graphics2D) g, this);
		}
	}

	public void addImagenOrganismo(Organismo org, int x, int y) {
		imgsOrganismos.add(new OrganismoRectangulo(org, getPathImage(org.getPathImagen()), x, 10, y, 10));
	}

	private void setEcoistemaBackground(Ecosistema ecosistema) {
		Image tempImage = null;
		URL imageURL = PanelSimulacion.class.getResource(ecosistema.getPathImagen());
		tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		imgBackground = new ImagenRectangulo(tempImage, 0, 0);
	}

	public Image getPathImage(String path) {
		Image tempImage = null;
		URL imageURL = null;

		imageURL = PanelSimulacion.class.getResource(path);
		tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		return tempImage;
	}

	private void mover() {
		for (OrganismoRectangulo orgRect : imgsOrganismos) {
			if (!(orgRect.getOrganismo() instanceof Productor)) { // Los organismos productores no se moverán
				if (orgRect.getOrganismo() instanceof Descomponedor) {
					if (orgRect.getRect().y <= 0)
						orgRect.setDy(-orgRect.getDy());
					if (orgRect.getRect().y + orgRect.getRect().getHeight() >= 580)
						orgRect.setDy(-orgRect.getDy());
					orgRect.move(orgRect.getRect().x, orgRect.getRect().y + orgRect.getDy());
				} else {
					if (orgRect.getRect().x + orgRect.getRect().width >= 1000)
						orgRect.setDx(-orgRect.getDx());
					if (orgRect.getRect().y + orgRect.getRect().getHeight() >= 580)
						orgRect.setDy(-orgRect.getDy());
					if (orgRect.getRect().y <= 0)
						orgRect.setDy(-orgRect.getDy());
					if (orgRect.getRect().x <= 0)
						orgRect.setDx(-orgRect.getDx());

					if (orgRect.getRect().x < 0)
						orgRect.getRect().x = 0;
					if (orgRect.getRect().y < 0)
						orgRect.getRect().y = 0;

					orgRect.move(orgRect.getRect().x + orgRect.getDx(), orgRect.getRect().y + orgRect.getDy());
				}
			}
		}
	}

	public void intersectar() {
		for (int i = 0; i < imgsOrganismos.size(); i++) {
			for (int j = 0; j < imgsOrganismos.size(); j++) {

				if (!imgsOrganismos.get(i).equals(imgsOrganismos.get(j))
						&& imgsOrganismos.get(i).getRect().intersects(imgsOrganismos.get(j).getRect())) { // Si hay una interseccion
					// Se omiten los organismos productores
//					if (!(imgsOrganismos.get(i).getOrganismo() instanceof Productor)) {
//
//						if (imgsOrganismos.get(i).getOrganismo() instanceof Consumidor) {
//							Consumidor cons = (Consumidor) imgsOrganismos.get(i).getOrganismo();
//							Consumidor cons2 = (Consumidor) imgsOrganismos.get(j).getOrganismo();
//							if (cons.getTipoConsumidor() == TipoConsumidor.TERCIARIO) {
//								if (cons2.getTipoConsumidor() == TipoConsumidor.SECUNDARIO)
//									imgsOrganismos.remove(imgsOrganismos.get(j));
//							}
//
//						} else {
							System.out.println("Interseccion entre " + imgsOrganismos.get(i).getOrganismo().getNombre()
									+ " y " + imgsOrganismos.get(j).getOrganismo().getNombre());
							int dx = imgsOrganismos.get(i).getDx();
							int dy = imgsOrganismos.get(i).getDy();

							// Se cambian la direccion de ambos organismos para que parezca un choque
							imgsOrganismos.get(i).setDx(imgsOrganismos.get(j).getDx());
							imgsOrganismos.get(i).setDy(imgsOrganismos.get(j).getDy());

							imgsOrganismos.get(j).setDx(dx);
							imgsOrganismos.get(j).setDy(dy);
							mover();
//						}
						interseccion = true;
					}
				}
			}
		}
//		for(OrganismoRectangulo orgRect: imgsOrganismos) {
//			for(OrganismoRectangulo orgRect2: imgsOrganismos) {
//				if(!orgRect.equals(orgRect2) && orgRect.getRect().intersects(orgRect2.getRect())) {
//					if(!(orgRect.getOrganismo() instanceof Productor)) {
//						
//						if(orgRect.getOrganismo() instanceof Consumidor) {
//							Consumidor cons = (Consumidor) orgRect.getOrganismo();
//							Consumidor cons2 = (Consumidor) orgRect2.getOrganismo();
//							if(cons.getTipoConsumidor() == TipoConsumidor.TERCIARIO) {
//								if(cons2.getTipoConsumidor() == TipoConsumidor.SECUNDARIO)
//									imgsOrganismos.remove(orgRect2);
//							}
//							
//							
//						}
//						System.out.println("Interseccion entre "+orgRect.getOrganismo().getNombre()+ " y "+orgRect2.getOrganismo().getNombre());
//						int dx = orgRect.getDx();
//						int dy = orgRect.getDy();
//						
//						// Se cambian la direccion de ambos organismos para que parezca un choque
//						orgRect.setDx(orgRect2.getDx());
//						orgRect.setDy(orgRect2.getDy());
//						
//						orgRect2.setDx(dx);
//						orgRect2.setDy(dy);
//						mover();
//						interseccion = true;
//					}
//				}
//			}
//		}
//	}
	
	

	// Metodos del hilo
	public void run() {
		while (isRunning) {
			intersectar();
			if (!interseccion)
				mover();
			repaint();
			try {
				Thread.sleep(950);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			interseccion = false;
		}
	}

	public ArrayList<OrganismoRectangulo> getImgsOrganismos() {
		return imgsOrganismos;
	}

}
