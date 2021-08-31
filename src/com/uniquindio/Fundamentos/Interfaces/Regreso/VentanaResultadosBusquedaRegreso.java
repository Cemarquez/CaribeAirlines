package com.uniquindio.Fundamentos.Interfaces.Regreso;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.uniquindio.Fundamentos.Interfaces.VentanaPago;
import com.uniquindio.Fundamentos.Interfaces.VentanaPrincipal;
import com.uniquindio.Fundamentos.Interfaces.Paneles.PanelResultadoRegreso;
import com.uniquindio.Fundamentos.Interfaces.Reservas.VentanaReservas;
import com.uniquindio.Fundamentos.Mundo.Cliente;
import com.uniquindio.Fundamentos.Mundo.Pasajero;
import com.uniquindio.Fundamentos.Mundo.Vuelo;

@SuppressWarnings("serial")
public class VentanaResultadosBusquedaRegreso extends JFrame {

	private JPanel contentPane;
	private JPanel panelMedio;
	private JTable table;
	private JPanel panel;
	private JTable tablaResultados;
	private VentanaPrincipal miVentanaPrincipal;

	private String clase;
	private String origen;
	private String destino;
	private String modalidad;
	private int cantPasajeros;
	private String fechaaIda;
	private String fechaaRegreso;
	private ArrayList<Vuelo> vueloEncontrado;
	private JLabel label_1;
	private JLabel lblModoVuelo;
	private JLabel lblLabelOrigen;
	private JPanel panelDestino;
	private JLabel labelFotoDestino;
	private JLabel labelDestino;
	private JPanel panelOrigen;
	private JPanel panel_1;
	private JLabel lblLabelfoto;
	private JLabel lblNewLabel;
	private JPanel panel_3;
	private JLabel label_2;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;
   private Cliente miCliente;
   private ArrayList<Pasajero> pasajeros;



	public VentanaResultadosBusquedaRegreso(VentanaPrincipal miVentanaPrincipal,VentanaPago miVentanaPago, Cliente miCliente ) {
		this.miVentanaPrincipal = miVentanaPrincipal;
		pasajeros = miVentanaPago.getPasajeros();
	this.miCliente = miCliente;
		origen = miVentanaPago.getOrigenRegreso();
		destino = miVentanaPago.getDestinoRegreso();
		cantPasajeros = pasajeros.size();
		
		fechaaRegreso =miVentanaPago.getFechaRegreso();
		vueloEncontrado = miVentanaPago.getVuelosRegreso();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 222);
		contentPane = new JPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaReservas.class.getResource("/imagenes/plane.png")));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		constBaner();
		constMedio();
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(Color.WHITE);
		for(int i =0; i< vueloEncontrado.size(); i++)
		{
			panelTitulo.add(new PanelResultadoRegreso(vueloEncontrado.get(i), this.miVentanaPrincipal, this, this.miCliente));
		}
		panelTitulo.setLayout(new BoxLayout(panelTitulo, BoxLayout.Y_AXIS));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		{
			lblModoVuelo = new JLabel("modo - vuelo");
			contentPane.add(lblModoVuelo);
			lblModoVuelo.setHorizontalAlignment(SwingConstants.LEFT);
		}
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(panelOrigen);
		panelOrigen.setLayout(new BoxLayout(panelOrigen, BoxLayout.X_AXIS));
		panelOrigen.add(label_1);
		panelOrigen.add(lblLabelOrigen);
		panelOrigen.add(panelDestino);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panelOrigen.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		label_2 = new JLabel("                ");
		panel_3.add(label_2);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panelOrigen.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		lblLabelfoto = new JLabel("");
		lblLabelfoto.setIcon(new ImageIcon(VentanaResultadosBusquedaRegreso.class.getResource("/imagenes/icons8-calendario-32.png")));
		panel_1.add(lblLabelfoto);
		
		lblNewLabel = new JLabel(fechaaRegreso);
		panel_1.add(lblNewLabel);
		contentPane.add(panelTitulo);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		setLocationRelativeTo(null);
		setResizable(false);

	}

	public void constBaner() {

	}

	public void constMedio() {

		{

			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			{
				panelOrigen = new JPanel();
				panelOrigen.setBackground(Color.WHITE);
				label_1 = new JLabel("");
				label_1.setVerticalAlignment(SwingConstants.TOP);
				label_1.setIcon(new ImageIcon(VentanaResultadosBusquedaRegreso.class.getResource("/imagenes/icons8-aeropuerto-26.png")));
				
				lblLabelOrigen = new JLabel(origen);
				lblLabelOrigen.setBorder(new EmptyBorder(0, 10, 0, 0));
				lblLabelOrigen.setVerticalAlignment(SwingConstants.TOP);
				lblLabelOrigen.setFont(new Font("Tahoma", Font.BOLD, 11));
				
				panelDestino = new JPanel();
				panelDestino.setBackground(Color.WHITE);
				panelDestino.setBorder(new EmptyBorder(0, 10, 0, 0));
				panelDestino.setLayout(new BoxLayout(panelDestino, BoxLayout.X_AXIS));
				
				labelFotoDestino = new JLabel("");
				labelFotoDestino.setIcon(new ImageIcon(VentanaResultadosBusquedaRegreso.class.getResource("/imagenes/icons8-flecha-24.png")));
				panelDestino.add(labelFotoDestino);
				
				labelDestino = new JLabel(destino);
				labelDestino.setBorder(new EmptyBorder(0, 10, 0, 0));
				labelDestino.setFont(new Font("Tahoma", Font.BOLD, 11));
				panelDestino.add(labelDestino);
				{
					
					
					
				}
				
			}

			
			
			
			
			
			
			
			
			
			
		}

	}
	
	public Cliente getMiCliente()
	{
		return miCliente;
	}
	public String getClase() {
		return clase;
	}

	public String getOrigen() {
		return origen;
	}

	public String getModalidad() {
		return modalidad;
	}

	public int getCantPasajeros() {
		return cantPasajeros;
	}

	public String getFechaaRegreso() {
		return fechaaRegreso;
	}

	public ArrayList<Vuelo> getVueloEncontrado() {
		return vueloEncontrado;
	}
	public ArrayList<Pasajero> getPasajeros() {
		return pasajeros;
	}
	
	public String getDestino()
	{
		return destino;
	}
}
