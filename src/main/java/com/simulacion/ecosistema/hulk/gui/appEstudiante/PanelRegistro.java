package com.simulacion.ecosistema.hulk.gui.appEstudiante;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PanelRegistro extends JPanel {

	private JTextField txtFieldUsername;
	private JTextField txtFieldPass;
	private JTextField txtFieldConfirmPass;
	private JButton btnRegistrarse;
	private JButton btnVolver; 
	
	public PanelRegistro() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel panelFormRegistro = new JPanel();
		panelFormRegistro.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelFormRegistro.setBounds(290, 181, 668, 428);
		add(panelFormRegistro);
		panelFormRegistro.setLayout(null);
		
		txtFieldUsername = new JTextField();
		txtFieldUsername.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtFieldUsername.setBounds(108, 91, 458, 38);
		panelFormRegistro.add(txtFieldUsername);
		txtFieldUsername.setColumns(10);
		
		txtFieldPass = new JTextField();
		txtFieldPass.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtFieldPass.setColumns(10);
		txtFieldPass.setBounds(108, 187, 458, 38);
		panelFormRegistro.add(txtFieldPass);
		
		txtFieldConfirmPass = new JTextField();
		txtFieldConfirmPass.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtFieldConfirmPass.setColumns(10);
		txtFieldConfirmPass.setBounds(108, 283, 458, 38);
		panelFormRegistro.add(txtFieldConfirmPass);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario");
		lblNombreDeUsuario.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNombreDeUsuario.setBounds(108, 52, 243, 28);
		panelFormRegistro.add(lblNombreDeUsuario);
		
		JLabel labelPassword = new JLabel("Password");
		labelPassword.setFont(new Font("Roboto", Font.BOLD, 16));
		labelPassword.setBounds(108, 148, 243, 28);
		panelFormRegistro.add(labelPassword);
		
		JLabel lblConfirmarPassword = new JLabel("Confirmar Password");
		lblConfirmarPassword.setFont(new Font("Roboto", Font.BOLD, 16));
		lblConfirmarPassword.setBounds(108, 244, 279, 28);
		panelFormRegistro.add(lblConfirmarPassword);
		
		btnVolver = new JButton("Volver a inicio");
		btnVolver.setFont(new Font("Roboto", Font.BOLD, 18));
		btnVolver.setBounds(122, 347, 180, 38);
		panelFormRegistro.add(btnVolver);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Roboto", Font.BOLD, 18));
		btnRegistrarse.setBounds(366, 347, 180, 38);
		panelFormRegistro.add(btnRegistrarse);
		
		JLabel lblCrearCuenta = new JLabel("CREAR CUENTA");
		lblCrearCuenta.setBounds(466, 70, 317, 72);
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

	public JTextField getTxtFieldConfirmPass() {
		return txtFieldConfirmPass;
	}

	public void setTxtFieldConfirmPass(JTextField txtFieldConfirmPass) {
		this.txtFieldConfirmPass = txtFieldConfirmPass;
	}

	public JButton getBtnRegistrarse() {
		return btnRegistrarse;
	}

	public void setBtnRegistrarse(JButton btnRegistrarse) {
		this.btnRegistrarse = btnRegistrarse;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}
	
}
