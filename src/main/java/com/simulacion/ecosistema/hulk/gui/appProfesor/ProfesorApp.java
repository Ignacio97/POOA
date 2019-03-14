package com.simulacion.ecosistema.hulk.gui.appProfesor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.simulacion.ecosistema.hulk.gui.appEstudiante.PanelLogIn;
import com.simulacion.ecosistema.hulk.gui.appEstudiante.PanelRegistro;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.JButton;

public class ProfesorApp extends JFrame {

	private JPanel contentPane;
	private CardLayout cardLayout = new CardLayout();

	private PanelLogIn panelLogin = new PanelLogIn();
	private PanelRegistro panelRegistro = new PanelRegistro();
	private PanelProfesor panelProfesor = new PanelProfesor();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfesorApp frame = new ProfesorApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProfesorApp() {
		getContentPane().setBackground(Color.WHITE);

		setResizable(false);
		setTitle("Aplicacion del Profesor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(cardLayout);
		
		contentPane.add(panelLogin);
		contentPane.add(panelRegistro);
		contentPane.add(panelProfesor);
		
		// Listeners de los paneles de Login y Registro
		// Listeners de los paneles de Login y Registro
		// Panel de Login
		panelLogin.getBtnLogIn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!panelLogin.getTxtFieldUsername().getText().isEmpty()
						&& !panelLogin.getTxtFieldPass().getText().isEmpty()) {
					
					// Comprobacion de si el usuario y la contrasena estan correctas
					if( panelLogin.getTxtFieldUsername().getText().equals("Omar") && panelLogin.getTxtFieldPass().getText().equals("Ejemplo")) {
						// Aqui se debera implementar una verificacion leyendo los archivos serializados que contengan los usuarios registrados
						cardLayout.last(contentPane);
					}
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
					panelRegistro.getTxtFieldUsername().setText("");
					panelRegistro.getTxtFieldPass().setText("");
					panelRegistro.getTxtFieldConfirmPass().setText("");
					
					/* En esta parte se debe 
					** implementar el guardar 
					** la informacion del alumno registrado dentro de archivos serializados
					*/
					cardLayout.previous(contentPane);
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
	}
}
