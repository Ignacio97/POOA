package com.simulacion.ecosistema.hulk.gui.appEstudiante;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PanelLogIn extends JPanel {

	private JTextField txtFieldUsername;
	private JTextField txtFieldPass;
	private JButton btnLogIn;
	private JLabel lblRegistrarse;
	
	public PanelLogIn() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel panelFormLogIn = new JPanel();
		panelFormLogIn.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelFormLogIn.setBounds(290, 181, 668, 407);
		add(panelFormLogIn);
		panelFormLogIn.setLayout(null);
		
		txtFieldUsername = new JTextField();
		txtFieldUsername.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtFieldUsername.setBounds(108, 91, 458, 38);
		panelFormLogIn.add(txtFieldUsername);
		txtFieldUsername.setColumns(10);
		
		txtFieldPass = new JTextField();
		txtFieldPass.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtFieldPass.setColumns(10);
		txtFieldPass.setBounds(108, 187, 458, 38);
		panelFormLogIn.add(txtFieldPass);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario");
		lblNombreDeUsuario.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNombreDeUsuario.setBounds(108, 52, 243, 28);
		panelFormLogIn.add(lblNombreDeUsuario);
		
		JLabel labelPassword = new JLabel("Password");
		labelPassword.setFont(new Font("Roboto", Font.BOLD, 16));
		labelPassword.setBounds(108, 148, 243, 28);
		panelFormLogIn.add(labelPassword);
		
		btnLogIn = new JButton("Iniciar Sesion");
		btnLogIn.setFont(new Font("Roboto", Font.BOLD, 18));
		btnLogIn.setBounds(215, 300, 222, 38);
		panelFormLogIn.add(btnLogIn);
		
		lblRegistrarse = new JLabel("<HTML><U>Aun no tienes cuenta? Registrate</U></HTML>");
		lblRegistrarse.setForeground(new Color(0, 0, 255));
		lblRegistrarse.setFont(new Font("Roboto", Font.BOLD, 14));
		lblRegistrarse.setBounds(195, 260, 267, 14);
		panelFormLogIn.add(lblRegistrarse);
		
		JLabel lblCrearCuenta = new JLabel("INICIAR SESION");
		lblCrearCuenta.setBounds(428, 70, 366, 72);
		add(lblCrearCuenta);
		lblCrearCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrearCuenta.setFont(new Font("Oswald", Font.BOLD, 48));
	}

	public JTextField getTxtFieldUsername() {
		return txtFieldUsername;
	}

	public void setTxtFieldUsername(JTextField txtFieldUsername) {
		this.txtFieldUsername = txtFieldUsername;
	}

	public JTextField getTxtFieldPass() {
		return txtFieldPass;
	}

	public void setTxtFieldPass(JTextField txtFieldPass) {
		this.txtFieldPass = txtFieldPass;
	}

	public JButton getBtnLogIn() {
		return btnLogIn;
	}

	public void setBtnLogIn(JButton btnLogIn) {
		this.btnLogIn = btnLogIn;
	}

	public JLabel getLblRegistrarse() {
		return lblRegistrarse;
	}

	public void setLblRegistrarse(JLabel lblRegistrarse) {
		this.lblRegistrarse = lblRegistrarse;
	}
	
}
