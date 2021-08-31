package com.uniquindio.Fundamentos.Interfaces.Paneles;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

import com.uniquindio.Fundamentos.Interfaces.VentanaPrincipal;
import com.uniquindio.Fundamentos.Interfaces.Informes.VentanaListaTrayectos;
import com.uniquindio.Fundamentos.Interfaces.Informes.VentanaListaTripulantes;
import com.uniquindio.Fundamentos.Mundo.Trayecto;

@SuppressWarnings("serial")
public class PanelTrayecto extends JPanel implements ActionListener {
	private JButton botonAcceder;
private Trayecto trayecto; private VentanaPrincipal miVentanaPrincipal; private VentanaListaTrayectos miVLT;
	/**
	 * Create the panel.
	 */
	public PanelTrayecto(Trayecto trayecto, VentanaPrincipal miVentanaPrincipal, VentanaListaTrayectos miVLT) {
		this.trayecto = trayecto;
		this.miVentanaPrincipal = miVentanaPrincipal;
		this.miVLT = miVLT;
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JLabel lblOrigenDestino = new JLabel(trayecto.getOrigen() +  " - " + trayecto.getDestino());
		add(lblOrigenDestino);
		
		JLabel label = new JLabel("                   ");
		add(label);
		
		JLabel lblDuracion = new JLabel(trayecto.getDuracionMin() + "");
		add(lblDuracion);
		
		JLabel label_1 = new JLabel("        ");
		add(label_1);
		
		JLabel lblNumTripulantes = new JLabel(trayecto.getTripulacion().numTripulantes() + "");
		add(lblNumTripulantes);
		
		JLabel label_2 = new JLabel("                        ");
		add(label_2);
		
		botonAcceder = new JButton("");
		botonAcceder.setBorder(null);
		botonAcceder.setFocusPainted(false);
		botonAcceder.setContentAreaFilled(false);
		botonAcceder.addActionListener(this);
		botonAcceder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAcceder.setBorderPainted(false);
		botonAcceder.setIcon(new ImageIcon(PanelTrayecto.class.getResource("/imagenes/icons8-flecha-24.png")));
		add(botonAcceder);
		
		JLabel label_3 = new JLabel("   ");
		add(label_3);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botonAcceder)
		{
			VentanaListaTripulantes miV = new VentanaListaTripulantes(trayecto, miVentanaPrincipal, miVLT);
			miV.setVisible(true);
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
    		frame.dispose();
		}
		
	}

}
