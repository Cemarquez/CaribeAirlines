package com.uniquindio.Fundamentos.Interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.uniquindio.Fundamentos.Interfaces.Paneles.PanelFactura;
import com.uniquindio.Fundamentos.Interfaces.Reservas.VentanaReservas;
import com.uniquindio.Fundamentos.Mundo.Cliente;
import com.uniquindio.Fundamentos.Mundo.Factura;
@SuppressWarnings("serial")
public class VentanaFacturas extends JFrame implements ActionListener {

	private JPanel contentPane;
private Cliente miCliente;

private ArrayList<Factura> facturas;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaFuncionesCliente miVentanaFuncionesCliente;
	private JButton btnVolver;
	public VentanaFacturas(VentanaPrincipal miVentanaPrincipal,Cliente miCliente, VentanaFuncionesCliente miVentanaFuncionesCliente) {
		this.miVentanaPrincipal = miVentanaPrincipal;
		this.miCliente = miCliente;
		this.miVentanaFuncionesCliente = miVentanaFuncionesCliente;
		this.facturas = miCliente.getFacturas();
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaReservas.class.getResource("/imagenes/plane.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 358);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		construirPanelSuperior();
		construirPanelFacturas();
		construirPanelInferior();
		setResizable(false);
		setLocationRelativeTo(null);		
	}
	
	public void construirPanelSuperior()
	{
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.WHITE);
		
		
		contentPane.add(panelSuperior);
		panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.X_AXIS));
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(VentanaFacturas.class.getResource("/imagenes/banerFactura.png")));
			panelSuperior.add(label);
		}
	}
	
	public void construirPanelFacturas()
	{
	
          JPanel panelFacturas = new JPanel();
          panelFacturas.setBackground(Color.WHITE);
          panelFacturas.setBorder(new EmptyBorder(10, 0, 0, 0));
          JScrollPane scroll = new JScrollPane(panelFacturas);
          JLabel labelInfor = new JLabel("                                 No hay facturas en lista");
			labelInfor.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			if(facturas.isEmpty()==true)
			{
				panelFacturas.add(labelInfor);
			}
		 for(int i=0;i<facturas.size();i++)
		 {
			 panelFacturas.add(new PanelFactura(miCliente, facturas.get(i)));
		 }
		
		contentPane.add(scroll);
		panelFacturas.setLayout(new BoxLayout(panelFacturas, BoxLayout.Y_AXIS));
	}
	
	public void construirPanelInferior()
	{
		
       JPanel panelInferior = new JPanel();
		
		
		contentPane.add(panelInferior); 
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
		{
		 btnVolver = new JButton("Volver");
			btnVolver.addActionListener(this);
			btnVolver.setBackground(Color.YELLOW);
			btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
			panelInferior.add(btnVolver);
		}
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnVolver)
		{
			miVentanaFuncionesCliente.setVisible(true);
			this.dispose();
		}
		
	}
}
