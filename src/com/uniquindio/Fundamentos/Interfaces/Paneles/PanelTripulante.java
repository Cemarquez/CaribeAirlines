package com.uniquindio.Fundamentos.Interfaces.Paneles;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.uniquindio.Fundamentos.Interfaces.VentanaPrincipal;
import com.uniquindio.Fundamentos.Interfaces.Informes.VentanaListaTripulantes;
import com.uniquindio.Fundamentos.Interfaces.Informes.VentanaModificarTripulante;
import com.uniquindio.Fundamentos.Mundo.Tripulante;
import com.uniquindio.Fundamentos.Mundo.Tripulante.Estudios;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Cursor;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class PanelTripulante extends JPanel implements ActionListener{
	private JButton botonModificar;
private Tripulante tripulante; private VentanaPrincipal miVentanaPrincipal; private VentanaListaTripulantes miVLTRi;
	/**
	 * Create the panel.
	 */
	public PanelTripulante(Tripulante tripulante, VentanaPrincipal miVentanaPrincipal, VentanaListaTripulantes miVLTRi) {
		this.tripulante = tripulante;
		this.miVentanaPrincipal = miVentanaPrincipal;
		this.miVLTRi = miVLTRi;
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		
			
		JLabel lblNombre = new JLabel(tripulante.getNombre() + " " +  tripulante.getApellido() );
		add(lblNombre);
		
		JLabel label = new JLabel("          ");
		add(label);
		
		JLabel lblId = new JLabel(tripulante.getId());
		add(lblId);
		
		JLabel label_1 = new JLabel("                 ");
		add(label_1);
		String estudios = "";
		if(tripulante.getEstudios() == Estudios.AUXILIAR)
		{
			estudios = "Auxiliar";
		}else if(tripulante.getEstudios() == Estudios.COPILOTO)
		{
			estudios = "Copiloto";
		}else if(tripulante.getEstudios() == Estudios.PILOTO)
		{
			estudios = "Piloto";
		}
		JLabel lblEstudios = new JLabel(estudios);
		add(lblEstudios);
		
		JLabel label_2 = new JLabel("                                 ");
		add(label_2);
		
		botonModificar = new JButton("");
		botonModificar.setIcon(new ImageIcon(PanelTripulante.class.getResource("/imagenes/icons8-ver-archivo-16.png")));
		botonModificar.setFocusPainted(false);
		botonModificar.setContentAreaFilled(false);
		botonModificar.setBorderPainted(false);
		botonModificar.addActionListener(this);
		botonModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(botonModificar);
		if(tripulante.getId() == null)
		{
			lblNombre.setVisible(false);
			lblNombre.setEnabled(false);
			lblEstudios.setVisible(false);
			lblEstudios.setEnabled(false);
			lblId.setVisible(false);
			lblId.setEnabled(false);
			label.setVisible(false);
			label.setEnabled(false);
			label_1.setVisible(false);
			label_1.setEnabled(false);
			label_2.setVisible(false);
			label_2.setEnabled(false);
			add(new Label("No existe este tripulante"));
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource() == botonModificar)
		{
			VentanaModificarTripulante miV = new VentanaModificarTripulante(tripulante, miVentanaPrincipal, miVLTRi);
			miV.setVisible(true);
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
    		frame.dispose();
		}
		
	}

}
