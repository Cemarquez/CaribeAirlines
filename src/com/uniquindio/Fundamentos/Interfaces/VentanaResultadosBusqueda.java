package com.uniquindio.Fundamentos.Interfaces;

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

import com.uniquindio.Fundamentos.Interfaces.Paneles.PanelResultado;
import com.uniquindio.Fundamentos.Interfaces.Reservas.VentanaReservas;
import com.uniquindio.Fundamentos.Mundo.Cliente;
import com.uniquindio.Fundamentos.Mundo.Vuelo;

@SuppressWarnings("serial")
public class VentanaResultadosBusqueda extends JFrame {

	private JPanel contentPane;
	private JPanel panelMedio;
	private JTable table;
	private JPanel panel;
	private JTable tablaResultados;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaBusqueda miVentanaBusqueda;
	private String clase;
	private String origen;
	private String destino;
	private String modalidad;
	private int cantAdultos;
	private int cantNiños;
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


	public VentanaResultadosBusqueda(VentanaPrincipal miVentanaPrincipal,VentanaBusqueda miVentanaBusqueda, Cliente miCliente ) {
		this.miVentanaPrincipal = miVentanaPrincipal;
		this.miVentanaBusqueda = miVentanaBusqueda;
	this.miCliente = miCliente;
		clase = miVentanaBusqueda.getClase();
		origen = miVentanaBusqueda.getOrigen();
		destino = miVentanaBusqueda.getDestino();
		modalidad = miVentanaBusqueda.getModalidad();
		cantAdultos = miVentanaBusqueda.getCantAdultos();
		cantNiños  = miVentanaBusqueda.getCantNiños();
		fechaaIda = miVentanaBusqueda.getFechaaIda();
		fechaaRegreso =miVentanaBusqueda.getFechaaRegreso();
		vueloEncontrado = miVentanaBusqueda.getVueloEncontrado();
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaReservas.class.getResource("/imagenes/plane.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 222);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		constBaner();
		constMedio();
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(Color.WHITE);
		for(int i =0; i< vueloEncontrado.size(); i++)
		{
			panelTitulo.add(new PanelResultado(vueloEncontrado.get(i), this.miVentanaPrincipal, this, this.miCliente));
		}
		panelTitulo.setLayout(new BoxLayout(panelTitulo, BoxLayout.Y_AXIS));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		{
			lblModoVuelo = new JLabel("Ida");
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
		lblLabelfoto.setIcon(new ImageIcon(VentanaResultadosBusqueda.class.getResource("/imagenes/icons8-calendario-32.png")));
		panel_1.add(lblLabelfoto);
		
		lblNewLabel = new JLabel(miVentanaBusqueda.getFechaaIda());
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
				label_1.setIcon(new ImageIcon(VentanaResultadosBusqueda.class.getResource("/imagenes/icons8-aeropuerto-26.png")));
				
				lblLabelOrigen = new JLabel(miVentanaBusqueda.getOrigen());
				lblLabelOrigen.setBorder(new EmptyBorder(0, 10, 0, 0));
				lblLabelOrigen.setVerticalAlignment(SwingConstants.TOP);
				lblLabelOrigen.setFont(new Font("Tahoma", Font.BOLD, 11));
				
				panelDestino = new JPanel();
				panelDestino.setBackground(Color.WHITE);
				panelDestino.setBorder(new EmptyBorder(0, 10, 0, 0));
				panelDestino.setLayout(new BoxLayout(panelDestino, BoxLayout.X_AXIS));
				
				labelFotoDestino = new JLabel("");
				labelFotoDestino.setIcon(new ImageIcon(VentanaResultadosBusqueda.class.getResource("/imagenes/icons8-flecha-24.png")));
				panelDestino.add(labelFotoDestino);
				
				labelDestino = new JLabel(miVentanaBusqueda.getDestino());
				labelDestino.setBorder(new EmptyBorder(0, 10, 0, 0));
				labelDestino.setFont(new Font("Tahoma", Font.BOLD, 11));
				panelDestino.add(labelDestino);
				{
					
					
					
				}
				
			}

			
			
			
			
			
			
			
			
			
			
		}

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

	public int getCantAdultos() {
		return cantAdultos;
	}

	public int getCantNiños() {
		return cantNiños;
	}

	public String getFechaaIda() {
		return fechaaIda;
	}

	public String getFechaaRegreso() {
		return fechaaRegreso;
	}

	public ArrayList<Vuelo> getVueloEncontrado() {
		return vueloEncontrado;
	}
	
	public String getDestino()
	{
		return destino;
	}
}
