package com.simulacion.ecosistema.hulk.gui.appProfesor;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class PanelProfesor extends JPanel{
	
	private JTable tableRooms;
	private DefaultTableModel modelTable;

	private String[][] contenido = { { "Bosque", "", "", "Activo" }, { "Mar", "", "", "Activo" },
			{ "Desierto", "", "", "Activo" }, { "Estepa", "", "", "Activo" }, { "Sabana", "", "", "Activo" },
			{ "Tundra", "", "", "Activo" } };
	private String[] header = { "Nombre Ecosistema", "Estudiante #1", "Estudiante #2", "Estado (Activo/Inactivo)" };

	private JList listEstudiantesConectados;
	private DefaultListModel<String> modeloEstudiantesConectados = new DefaultListModel<String>();

	private JList listPuntuacionEstudiante;
	private DefaultListModel<String> modeloPuntuacionEstudiante = new DefaultListModel<String>();
	
	public PanelProfesor() {
		setLayout(null);
		
		modelTable = new DefaultTableModel(contenido, header);
		setLayout(null);

		JLabel lblEstudiantesConectados = new JLabel("Estudiantes Conectados");
		lblEstudiantesConectados.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstudiantesConectados.setFont(new Font("Roboto", Font.BOLD, 18));
		lblEstudiantesConectados.setBounds(78, 44, 283, 34);
		add(lblEstudiantesConectados);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 105, 283, 278);
		add(scrollPane);

		listEstudiantesConectados = new JList();
		scrollPane.setViewportView(listEstudiantesConectados);

		JLabel lblPuntuacionDelEstudiante = new JLabel("Puntuacion del Estudiante");
		lblPuntuacionDelEstudiante.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntuacionDelEstudiante.setFont(new Font("Roboto", Font.BOLD, 18));
		lblPuntuacionDelEstudiante.setBounds(78, 410, 283, 34);
		add(lblPuntuacionDelEstudiante);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(78, 470, 283, 233);
		add(scrollPane_1);

		listPuntuacionEstudiante = new JList();
		scrollPane_1.setViewportView(listPuntuacionEstudiante);

		JLabel lblRoomsDeJuego = new JLabel("Rooms de Juego");
		lblRoomsDeJuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoomsDeJuego.setFont(new Font("Roboto", Font.BOLD, 18));
		lblRoomsDeJuego.setBounds(668, 172, 283, 34);
		add(lblRoomsDeJuego);

		JLabel lblEcosistema = new JLabel("Nombre del Ecosistema");
		lblEcosistema.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblEcosistema.setBounds(526, 255, 201, 34);
		add(lblEcosistema);

		JLabel lblEstudiante = new JLabel("Estudiante #1");
		lblEstudiante.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblEstudiante.setBounds(842, 255, 109, 34);
		add(lblEstudiante);

		JLabel lblEstudiante_1 = new JLabel("Estudiante #2");
		lblEstudiante_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblEstudiante_1.setBounds(694, 252, 175, 41);
		add(lblEstudiante_1);

		JLabel lblActivoinactivo = new JLabel("Activo/Inactivo");
		lblActivoinactivo.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblActivoinactivo.setBounds(984, 248, 123, 48);
		add(lblActivoinactivo);

		tableRooms = new JTable();
		tableRooms.setEnabled(false);
		tableRooms.setFont(new Font("Roboto", Font.PLAIN, 14));
		tableRooms.setBounds(526, 300, 590, 103);
		tableRooms.setModel(modelTable);
		add(tableRooms);
		
		JButton btnTerminarSesion = new JButton("Terminar Sesion");
		btnTerminarSesion.setBounds(615, 431, 175, 34);
		add(btnTerminarSesion);
		
		JButton btnAgregarEstudiantes = new JButton("Agregar Estudiantes");
		btnAgregarEstudiantes.setBounds(840, 431, 175, 34);
		add(btnAgregarEstudiantes);
		
	}

	public DefaultTableModel getModelTable() {
		return modelTable;
	}

	public void setModelTable(DefaultTableModel modelTable) {
		this.modelTable = modelTable;
	}

	public String[][] getContenido() {
		return contenido;
	}

	public void setContenido(String[][] contenido) {
		this.contenido = contenido;
	}

	public DefaultListModel<String> getModeloEstudiantesConectados() {
		return modeloEstudiantesConectados;
	}

	public void setModeloEstudiantesConectados(DefaultListModel<String> modeloEstudiantesConectados) {
		this.modeloEstudiantesConectados = modeloEstudiantesConectados;
	}

	public DefaultListModel<String> getModeloPuntuacionEstudiante() {
		return modeloPuntuacionEstudiante;
	}

	public void setModeloPuntuacionEstudiante(DefaultListModel<String> modeloPuntuacionEstudiante) {
		this.modeloPuntuacionEstudiante = modeloPuntuacionEstudiante;
	}
	
}
