package com.uniquindio.Fundamentos.Interfaces.Informes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.uniquindio.Fundamentos.Interfaces.VentanaPrincipal;
import com.uniquindio.Fundamentos.Interfaces.Paneles.PanelTripulante;
import com.uniquindio.Fundamentos.Mundo.Trayecto;
import com.uniquindio.Fundamentos.Mundo.Tripulacion;

import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VentanaListaTripulantes extends JFrame {

	private JPanel contentPane;
	private JButton btnBotonvolver;

	public VentanaListaTripulantes(Trayecto trayecto, VentanaPrincipal miVentanaPrincipal, VentanaListaTrayectos VLT) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 329);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setResizable(false);
		setLocationRelativeTo(null);	
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaListaTripulantes.class.getResource("/imagenes/registratbaner.jpg")));
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		Tripulacion tripulacion= trayecto.getTripulacion();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		panel_1.add(new PanelTripulante(tripulacion.getrPiloto(), miVentanaPrincipal, this));
		panel_1.add(new PanelTripulante(tripulacion.getCopiloto(), miVentanaPrincipal, this));
		panel_1.add(new PanelTripulante(tripulacion.getAuxiliar1(), miVentanaPrincipal, this));
		panel_1.add(new PanelTripulante(tripulacion.getAuxiliar2(), miVentanaPrincipal, this));
		panel_1.add(new PanelTripulante(tripulacion.getAuxiliar3(), miVentanaPrincipal, this));
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		btnBotonvolver = new JButton("Volver");
		btnBotonvolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VLT.setVisible(true);
				dispose();
			}
		});
		btnBotonvolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBotonvolver.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		btnBotonvolver.setBackground(new Color(255, 204, 0));
		btnBotonvolver.setForeground(Color.WHITE);
		panel_2.add(btnBotonvolver);
	}

}
