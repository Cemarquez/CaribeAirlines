package com.uniquindio.Fundamentos.Interfaces.Paneles;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import com.uniquindio.Fundamentos.Interfaces.VentanaPrincipal;
import com.uniquindio.Fundamentos.Interfaces.Reservas.VentanaPagarReserva;
import com.uniquindio.Fundamentos.Interfaces.Reservas.VentanaReservas;
import com.uniquindio.Fundamentos.Mundo.Cliente;
import com.uniquindio.Fundamentos.Mundo.Reserva;
import com.uniquindio.Fundamentos.Mundo.Trayecto;
import com.uniquindio.Fundamentos.Mundo.Vuelo;

@SuppressWarnings("serial")
public class PanelReservas extends JPanel implements ActionListener {
	private JLabel labelPasajero;
	private JLabel labelVuelo;
	private JLabel lblFecha;
	private JLabel labelEstado;
	private JButton botonPagar;
	private JButton botonCancelar;
	private VentanaPrincipal miV;
	private Reserva reserva;
	private Cliente miCliente;
	
	

	/**
	 * Create the panel.
	 */
	public PanelReservas(VentanaPrincipal miV, Reserva reserva, Cliente miCliente) {
		setBackground(Color.WHITE);
		this.miCliente = miCliente;
		this.reserva = reserva;
		this.miV = miV;
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JLabel label = new JLabel("    ");
		add(label);
		Trayecto trayecto=reserva.getVueloSeleccionado().getTrayecto();
		labelPasajero = new JLabel(reserva.getPasajero().getNombre() + " " + reserva.getPasajero().getApellido());
		add(labelPasajero);
		
		JLabel label_1 = new JLabel("              ");
		add(label_1);
		
		labelVuelo = new JLabel(trayecto.getOrigen() + " - " + trayecto.getDestino());
		add(labelVuelo);
		
		JLabel label_2 = new JLabel("              ");
		add(label_2);
		Vuelo vuelo = reserva.getVueloSeleccionado();
		lblFecha = new JLabel(vuelo.getFecha());
		add(lblFecha);
		
		JLabel lblNewLabel = new JLabel("                 ");
		add(lblNewLabel);
		String estado="";
		if(reserva.isEstaPago() == true)
		{
			estado="Paga";
			
			
		}
		else
		{
			estado="Pendiente";
		}
		labelEstado = new JLabel(estado);
		add(labelEstado);
		
		JLabel lblNewLabel_2 = new JLabel("       ");
		add(lblNewLabel_2);
		
		botonPagar = new JButton("");
		botonPagar.setFocusPainted(false);
		botonPagar.addActionListener(this);
		botonPagar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonPagar.setBorder(null);
		botonPagar.setIcon(new ImageIcon(PanelReservas.class.getResource("/imagenes/comprar.png")));
		botonPagar.setContentAreaFilled(false);
		botonPagar.setBorderPainted(false);
		add(botonPagar);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("        ");
		add(lblNewLabel_1);
		
		botonCancelar = new JButton("");
		botonCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonCancelar.addActionListener(this);
		botonCancelar.setIcon(new ImageIcon(PanelReservas.class.getResource("/imagenes/cancelar.png")));
		botonCancelar.setFocusPainted(false);
		botonCancelar.setContentAreaFilled(false);
		botonCancelar.setBorder(null);
		add(botonCancelar);
		if(reserva.isEstaPago() == true)
		{
			botonPagar.setVisible(false);
			botonCancelar.setVisible(false);
			
		}
     
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botonPagar)
		{
			VentanaPagarReserva miVPR = new VentanaPagarReserva(reserva, miV, miCliente);
			miVPR.setVisible(true);
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
    		frame.dispose();
		}
		
		if(e.getSource() == botonCancelar)
		{
			int opcion = JOptionPane.showConfirmDialog(null, "¿Está completamente seguro de querer borrar esta reserva?", "Confirmar reserva", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(opcion == JOptionPane.YES_OPTION)
            {
				
				miCliente.borrarReserva(reserva);
				VentanaReservas miVR = new VentanaReservas(miCliente, miV);
				miVR.setVisible(true);
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
	    		frame.dispose();
	    		
				
            }
            }
				
			
		}
		
	}
	
	


