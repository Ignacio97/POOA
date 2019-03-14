package com.simulacion.ecosistema.hulk.gui.appEstudiante;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.awt.SystemColor;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.JList;
import javax.swing.JOptionPane;

import com.simulacion.ecosistema.hulk.modelo.Consumidor;
import com.simulacion.ecosistema.hulk.modelo.CreadorEcosistema;
import com.simulacion.ecosistema.hulk.modelo.Descomponedor;
import com.simulacion.ecosistema.hulk.modelo.Ecosistema;
import com.simulacion.ecosistema.hulk.modelo.Organismo;
import com.simulacion.ecosistema.hulk.modelo.Productor;
import com.simulacion.ecosistema.hulk.modelo.simulacion.CoordenadaOrganismo;
import com.simulacion.ecosistema.hulk.modelo.usuarios.Estudiante;
import com.simulacion.ecosistema.hulk.modelo.usuarios.Usuario;
import com.simulacion.ecosistema.hulk.code.server.*;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class EstudianteApp extends JFrame {
	private Ecosistema ecosistema;

	private CardLayout cardLayout = new CardLayout();
	
	private PanelLogIn panelLogin = new PanelLogIn();
	private PanelRegistro panelRegistro = new PanelRegistro();
    private JPanel vistaJuego;
    
    private JPanel contentPane;
    
	private JTextField txtJugador1;
	private JTextField txtJugador2;

	private JList listProductores;
	private DefaultListModel<String> modelProductores = new DefaultListModel<String>();

	private JList listConsumidores;
	private DefaultListModel<String> modelConsumidores = new DefaultListModel<String>();

	private JList listDescomponedores;
	private DefaultListModel<String> modelDescomponedores = new DefaultListModel<String>();

	private Client cliente;
	final PanelSimulacion panelJuego;
	
	Thread threadSimulacion = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstudianteApp frame = new EstudianteApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EstudianteApp() {
		int port = Integer.parseInt(
				JOptionPane.showInputDialog(this,new String("Numero de puerto")));
				
		inicializarEcosistema(); // se inicializa con un ecosistema con biocenosis y biotopo definido
		inicializarJListsOrganismos();

		setResizable(false);
		setTitle("Aplicacion Estudiante / Ecosistema (SELVA) / ROOM 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 732);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(cardLayout);
		
		vistaJuego = new JPanel();
		vistaJuego.setLayout(null);
		
		// Añadiendo paneles necesarios a nuestro CardLayout
		contentPane.add(panelLogin);
		contentPane.add(panelRegistro);
		contentPane.add(vistaJuego);
		
		// Listeners de los paneles de Login y Registro
		// Panel de Login
		panelLogin.getBtnLogIn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!panelLogin.getTxtFieldUsername().getText().isEmpty()
						&& !panelLogin.getTxtFieldPass().getText().isEmpty()) {
					
					String name = panelLogin.getTxtFieldUsername().getText();
					String pass = panelLogin.getTxtFieldPass().getText();
					
					cliente.sendMessage(new Message(MessageType.LOG_IN_REQUEST, new Estudiante(name, pass)));
					
					/*if() {
						// Aqui se debera implementar una verificacion leyendo los archivos serializados que contengan los usuarios registrados
						cardLayout.last(contentPane);
					}*/
				}
			}
		});
		
		panelLogin.getLblRegistrarse().addMouseListener(new MouseInputAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelLogin.getTxtFieldUsername().setText("");
				panelLogin.getTxtFieldPass().setText("");
				cardLayout.next(contentPane);
			}
		});

		// Panel de Registro
		panelRegistro.getBtnRegistrarse().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!panelRegistro.getTxtFieldUsername().getText().isEmpty()
						&& !panelRegistro.getTxtFieldPass().getText().isEmpty()
						&& !panelRegistro.getTxtFieldConfirmPass().getText().isEmpty()) {
					
					String name = panelRegistro.getTxtFieldUsername().getText();
					String passw = panelRegistro.getTxtFieldPass().getText();
					String passw2 = panelRegistro.getTxtFieldPass().getText();
					
					if(passw.equals(passw2)) {
						Usuario usr = new Estudiante(name, passw);
						cliente.sendMessage(new Message(MessageType.SIGN_IN_REQUEST,usr));
					}
					else {
						JOptionPane.showMessageDialog(panelRegistro,"Contrasenias no coinciden","Contrasenia incorrecta",JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
			}
		});

		panelRegistro.getBtnVolver().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRegistro.getTxtFieldUsername().setText("");
				panelRegistro.getTxtFieldPass().setText("");
				panelRegistro.getTxtFieldConfirmPass().setText("");
				
				panelLogin.getTxtFieldUsername().setText("");
				panelLogin.getTxtFieldPass().setText("");
				cardLayout.previous(contentPane);
			}
		});
		
		panelJuego = new PanelSimulacion(ecosistema);// final para poder usar la variable PanelSimulacion dentro de los listeners
		panelJuego.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int x = arg0.getX();
				int y = arg0.getY();
				boolean entro = false;
				Organismo o = null ;
				
				System.out.println("Coordenada en x: " + x + " y coordenada en y: " + y);
				
				if (listProductores.getSelectedValue() != null) {
					entro= true;
					o = buscarListaOrganismos((String) listProductores.getSelectedValue(),
							ecosistema.getBiocenosis().getProductores());
				} else if (listConsumidores.getSelectedValue() != null) {
					entro= true;
					o = buscarListaOrganismos((String) listConsumidores.getSelectedValue(),
							ecosistema.getBiocenosis().getConsumidores());
				} else if (listDescomponedores.getSelectedValue() != null) {
					entro= true;
					o = buscarListaOrganismos((String) listDescomponedores.getSelectedValue(),
							ecosistema.getBiocenosis().getDescomponedores());
				}
				
				if(entro) {
					CoordenadaOrganismo cor = new CoordenadaOrganismo(o, x, y);
					Message m = new Message(MessageType.GAME,cor);
					cliente.sendMessage(m);
				}
				
			}
		});
		
		panelJuego.setBackground(SystemColor.window);
		panelJuego.setBounds(274, 0, 1000, 580);
		vistaJuego.add(panelJuego);
		panelJuego.setLayout(null);

		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(SystemColor.activeCaption);
		panelBotones.setBounds(274, 580, 1000, 123);
		vistaJuego.add(panelBotones);
		panelBotones.setLayout(null);

		JButton btnIniciarSimulacion = new JButton("Iniciar Simulaci\u00F3n");
		btnIniciarSimulacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(threadSimulacion == null) {
					threadSimulacion = new Thread(panelJuego);
					threadSimulacion.start();					
				}
				
				if(panelJuego.isRunning == false) {
					threadSimulacion = new Thread(panelJuego);
					threadSimulacion.start();	
				}
					
				panelJuego.isRunning = true;
			}
		});
		btnIniciarSimulacion.setFont(new Font("Roboto", Font.BOLD, 14));
		btnIniciarSimulacion.setBounds(306, 50, 182, 23);
		panelBotones.add(btnIniciarSimulacion);

		JButton btnDetenerSimulacion = new JButton("Detener Simulaci\u00F3n");
		btnDetenerSimulacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelJuego.isRunning = false;
			}
		});
		btnDetenerSimulacion.setFont(new Font("Roboto", Font.BOLD, 14));
		btnDetenerSimulacion.setBounds(510, 50, 182, 23);
		panelBotones.add(btnDetenerSimulacion);

		JLabel lblJugadores = new JLabel("JUGADORES");
		lblJugadores.setFont(new Font("Roboto", Font.BOLD, 14));
		lblJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadores.setBounds(26, 23, 214, 14);
		vistaJuego.add(lblJugadores);

		txtJugador1 = new JTextField();
		txtJugador1.setFont(new Font("Roboto", Font.PLAIN, 13));
		txtJugador1.setEditable(false);
		txtJugador1.setText("Jugador1");
		txtJugador1.setBounds(26, 55, 214, 20);
		vistaJuego.add(txtJugador1);
		txtJugador1.setColumns(10);

		txtJugador2 = new JTextField();
		txtJugador2.setFont(new Font("Roboto", Font.PLAIN, 13));
		txtJugador2.setEditable(false);
		txtJugador2.setText("Jugador2");
		txtJugador2.setBounds(26, 86, 214, 20);
		vistaJuego.add(txtJugador2);
		txtJugador2.setColumns(10);

		JPanel panelOrganismos = new JPanel();
		panelOrganismos.setBackground(SystemColor.inactiveCaption);
		panelOrganismos.setBounds(0, 138, 274, 633);
		vistaJuego.add(panelOrganismos);
		panelOrganismos.setLayout(null);

		JLabel lblNewLabel = new JLabel("PRODUCTORES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel.setBounds(0, 11, 274, 27);
		panelOrganismos.add(lblNewLabel);

		JLabel lblConsumidores = new JLabel("CONSUMIDORES");
		lblConsumidores.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsumidores.setFont(new Font("Roboto", Font.BOLD, 14));
		lblConsumidores.setBounds(0, 195, 274, 27);
		panelOrganismos.add(lblConsumidores);

		JLabel lblDescomponedores = new JLabel("DESCOMPONEDORES");
		lblDescomponedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescomponedores.setFont(new Font("Roboto", Font.BOLD, 14));
		lblDescomponedores.setBounds(0, 380, 274, 27);
		panelOrganismos.add(lblDescomponedores);

		JScrollPane scrollPaneConsumidores = new JScrollPane();
		scrollPaneConsumidores.setBounds(18, 233, 237, 126);
		panelOrganismos.add(scrollPaneConsumidores);

		listConsumidores = new JList(modelConsumidores);
		scrollPaneConsumidores.setViewportView(listConsumidores);
		listConsumidores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listConsumidores.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (event.getValueIsAdjusting())
					return; // Ignorando los eventos intermedios (Mouse presionado)
				if (listConsumidores.getSelectedValue() != null) {
					System.out.println("Consumidor seleccionado: " + listConsumidores.getSelectedValue());
					if (listProductores.getSelectedValue() != null)
						listProductores.clearSelection();
					if (listDescomponedores.getSelectedValue() != null)
						listDescomponedores.clearSelection();
				}
			}
		});

		listConsumidores.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 16));

		JScrollPane scrollPaneProductores = new JScrollPane();
		scrollPaneProductores.setBounds(18, 49, 237, 126);
		panelOrganismos.add(scrollPaneProductores);

		listProductores = new JList(modelProductores);
		scrollPaneProductores.setViewportView(listProductores);
		listProductores.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (event.getValueIsAdjusting())
					return; // Ignorando los eventos intermedios (Mouse presionado)
				if (listProductores.getSelectedValue() != null) {
					System.out.println("Productor seleccionado: " + listProductores.getSelectedValue());
					if (listConsumidores.getSelectedValue() != null)
						listConsumidores.clearSelection();
					if (listDescomponedores.getSelectedValue() != null)
						listDescomponedores.clearSelection();
				}
			}
		});
		listProductores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listProductores.setVisibleRowCount(2);
		listProductores.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 16));

		JScrollPane scrollPaneDescomponedores = new JScrollPane();
		scrollPaneDescomponedores.setBounds(18, 418, 237, 126);
		panelOrganismos.add(scrollPaneDescomponedores);

		listDescomponedores = new JList(modelDescomponedores);
		scrollPaneDescomponedores.setViewportView(listDescomponedores);
		listDescomponedores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listDescomponedores.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (event.getValueIsAdjusting())
					return; // Ignorando los eventos intermedios (Mouse presionado)
				if (listDescomponedores.getSelectedValue() != null) {
					System.out.println("Descomponedor seleccionado: " + listDescomponedores.getSelectedValue());
					if (listConsumidores.getSelectedValue() != null)
						listConsumidores.clearSelection();
					if (listProductores.getSelectedValue() != null)
						listProductores.clearSelection();
				}
			}
		});

		this.cliente = new Client(port);
		this.cliente.setPanel(panelJuego);
		this.cliente.setPanelLog(this.panelLogin);
		this.cliente.setPanelSign(this.panelRegistro);
		this.cliente.setApp(this);
		JButton btnTerminarPartida = new JButton("Terminar Partida");
		btnTerminarPartida.setFont(new Font("Roboto", Font.BOLD, 14));
		btnTerminarPartida.setBounds(815, 11, 162, 33);
		panelJuego.add(btnTerminarPartida);
		this.cliente.startClient();
		listDescomponedores.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 16));
	}


	private void inicializarJListsOrganismos() {
		for (Productor prod : ecosistema.getBiocenosis().getProductores())
			modelProductores.addElement(prod.getNombre());

		for (Consumidor cons : ecosistema.getBiocenosis().getConsumidores())
			modelConsumidores.addElement(cons.getNombre());

		for (Descomponedor desc : ecosistema.getBiocenosis().getDescomponedores())
			modelDescomponedores.addElement(desc.getNombre());

	}

	private Organismo buscarListaOrganismos(String name, ArrayList arrayList) {
		for (Organismo org : (ArrayList<Organismo>) arrayList) {
			if (name == org.getNombre())
				return org;
		}
		return null;
	}

	private void inicializarEcosistema() {
		ecosistema = CreadorEcosistema.plantillaBosque();
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public JPanel getContentPane() {
		return contentPane;
	}
	
	
}
