package com.uniquindio.Fundamentos.Interfaces.Informes;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;

import com.uniquindio.Fundamentos.Interfaces.VentanaFuncionesAdmin;
import com.uniquindio.Fundamentos.Interfaces.VentanaPrincipal;
import com.uniquindio.Fundamentos.Interfaces.Paneles.PanelTrayecto;
import com.uniquindio.Fundamentos.Mundo.Trayecto;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VentanaListaTrayectos extends JFrame {

	private JPanel contentPane;


	public VentanaListaTrayectos(VentanaPrincipal miVentanaPrincipal, VentanaFuncionesAdmin miVFA) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 432);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setResizable(false);
		setLocationRelativeTo(null);	
		JPanel panelBanner = new JPanel();
		panelBanner.setBorder(new EmptyBorder(0, 0, 8, 0));
		panelBanner.setBackground(Color.WHITE);
		contentPane.add(panelBanner);
		panelBanner.setLayout(new BoxLayout(panelBanner, BoxLayout.X_AXIS));
		
		JLabel lblBanner = new JLabel("Banner");
		lblBanner.setIcon(new ImageIcon(VentanaListaTrayectos.class.getResource("/imagenes/registratbaner.jpg")));
		panelBanner.add(lblBanner);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		
		contentPane.add(scrollPane);
		Trayecto[] trayectos = miVentanaPrincipal.getTrayectos();
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(10, 0, 0, 0));
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miVFA.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 204, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		panel_1.add(btnNewButton);
		for(int i=0;i<trayectos.length;i++)
		{
			panel.add(new PanelTrayecto(trayectos[i], miVentanaPrincipal, this));
		}
	}

}
