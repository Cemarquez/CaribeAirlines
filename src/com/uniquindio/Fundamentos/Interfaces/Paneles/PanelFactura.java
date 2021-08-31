package com.uniquindio.Fundamentos.Interfaces.Paneles;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.uniquindio.Fundamentos.Mundo.Cliente;
import com.uniquindio.Fundamentos.Mundo.Factura;
import com.uniquindio.Fundamentos.Util.Util;

@SuppressWarnings("serial")
public class PanelFactura extends JPanel implements ActionListener{
	private JButton botonVisualizar;
	private Cliente miCliente;
	private Factura factura;
	/**
	 * Create the panel.
	 */
	public PanelFactura(Cliente miCliente, Factura factura) {
		setBackground(Color.WHITE);
		this.miCliente = miCliente;
		this.factura = factura;
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JLabel label = new JLabel("  ");
		add(label);
		
		JLabel labelNombreApellido = new JLabel(miCliente.getNombre() +  " " + miCliente.getApellido());
		add(labelNombreApellido);
		
		JLabel label_1 = new JLabel("               ");
		add(label_1);
		
		JLabel labelFecha = new JLabel(Util.convertirFechaAString(factura.getFecha()));
		add(labelFecha);
		
		JLabel lblFact = new JLabel("              Fact# ");
		add(lblFact);
		
		JLabel labelNumFactura = new JLabel(factura.getNumeroFactura() +  "");
		add(labelNumFactura);
		
		JLabel label_2 = new JLabel("                                    ");
		add(label_2);
		
		botonVisualizar = new JButton("");
		botonVisualizar.setFocusPainted(false);
		botonVisualizar.addActionListener(this);
		botonVisualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonVisualizar.setContentAreaFilled(false);
		botonVisualizar.setBorderPainted(false);
		botonVisualizar.setIcon(new ImageIcon(PanelFactura.class.getResource("/imagenes/analitica.png")));
		add(botonVisualizar);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botonVisualizar)
		{
			String ruta = Util.disco() + "CaribeAirlines/Facturas/Factura_" + miCliente.getNombre() +"_" + factura.getNumeroFactura() +  ".pdf";
			try {
			     File path = new File (ruta);
			     Desktop.getDesktop().open(path);
			}catch (IOException ex) {
			     ex.printStackTrace();
			}
		}
		
		
		
	}

}
