package com.uniquindio.Fundamentos.Interfaces.Paneles;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.uniquindio.Fundamentos.Interfaces.VentanaDatosPasajero;
import com.uniquindio.Fundamentos.Interfaces.VentanaPrincipal;
import com.uniquindio.Fundamentos.Interfaces.VentanaResultadosBusqueda;
import com.uniquindio.Fundamentos.Mundo.Avion;
import com.uniquindio.Fundamentos.Mundo.Cliente;
import com.uniquindio.Fundamentos.Mundo.Vuelo;
import com.uniquindio.Fundamentos.Util.Util;

/**
 * Panel donde se mostrarán la lista de vuelos encontrados
 * @author Cesar Marquez - Brian Giraldo
 *
 */
@SuppressWarnings("serial")
public class PanelResultado extends JPanel {
	private JPanel panelEconomicas;
	private JPanel panelEjecutvas;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaResultadosBusqueda miVentanaResultadosBusqueda;
	
    private PanelResultado miPanelResultado;
    private String clase;
	private String origen;
	private String destino;
	private String modalidad;
	private int cantAdultos;
	private int cantNiños;
	private String fechaaIda;
	private String fechaaRegreso;
	private PanelResultado estePanel = this;
	private Cliente miCliente;
	
	/**
	 * Constructor que crea el panel.
	 * @param vueloEncontrado
	 * @param miVentanaPrincipal
	 * @param miVentanaResultadosBusqueda
	 * @param miVentanaLogin
	 */
	public PanelResultado(Vuelo vueloEncontrado, VentanaPrincipal miVentanaPrincipal, VentanaResultadosBusqueda miVentanaResultadosBusqueda,Cliente miCliente ) {
		clase = miVentanaResultadosBusqueda.getClase();
		origen = miVentanaResultadosBusqueda.getOrigen();
		destino = miVentanaResultadosBusqueda.getDestino();
		modalidad = miVentanaResultadosBusqueda.getModalidad();
		cantAdultos = miVentanaResultadosBusqueda.getCantAdultos();
		cantNiños  = miVentanaResultadosBusqueda.getCantNiños();
		fechaaIda = miVentanaResultadosBusqueda.getFechaaIda();
		fechaaRegreso =miVentanaResultadosBusqueda.getFechaaRegreso();
	   this.miCliente = miCliente;
		this.miVentanaPrincipal = miVentanaPrincipal;
		this.miVentanaResultadosBusqueda = miVentanaResultadosBusqueda;
		
		this.miPanelResultado = this;
		setBackground(SystemColor.menu);
		setBorder(new EmptyBorder(10, 0, 10, 10));
		Avion avion = vueloEncontrado.getAvion();
		int sillasEjecutivasLibres = 12 - avion.contarSillasEjecutivasOcupadas();
        int sillasEconominasLibes = 138 - avion.contarSillasEconomicasOcupadas();
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(SystemColor.menu);
        panelInfo.setBorder(new EmptyBorder(0, 0, 34, 8));
        panelInfo.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        add(panelInfo);
        panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
        
        JPanel panel = new JPanel();
        panel.setAlignmentX(5.0f);
        panel.setBorder(new EmptyBorder(10, 10, 0, 0));
        panelInfo.add(panel);
        
        JLabel labelHora = new JLabel(vueloEncontrado.getHoraSalida());
        labelHora.setFont(new Font("Tahoma", Font.PLAIN, 15));
        int duracionVuelo = vueloEncontrado.getTrayecto().getDuracionMin();
        JLabel horallegada = new JLabel(Util.sumarHoras(vueloEncontrado.getHoraSalida(),duracionVuelo ));
        horallegada.setBorder(new EmptyBorder(0, 0, 10, 0));
        horallegada.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(labelHora);
        panel.add(horallegada);
        
        JPanel panel_1 = new JPanel();
        panelInfo.add(panel_1);
        
        JLabel lblDuracinTotal = new JLabel("Duraci\u00F3n total  ");
        
        JLabel lblNewLabel = new JLabel(Util.convertirMinutosAHora(duracionVuelo));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
        panel_1.add(lblDuracinTotal);
        panel_1.add(lblNewLabel);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(SystemColor.control);
        add(panel_2);
        panel_2.setLayout(new GridLayout(1, 50, 20, 50));
        
        panelEconomicas = new JPanel();
        panelEconomicas.setBackground(Color.WHITE);
      
       
        panelEconomicas.setBorder(new LineBorder(SystemColor.scrollbar, 3));
        panel_2.add(panelEconomicas);
        panelEconomicas.setLayout(new BoxLayout(panelEconomicas, BoxLayout.Y_AXIS));
        
        JLayeredPane layeredEconomicas = new JLayeredPane();
        layeredEconomicas.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Vuelo miVuelo = miVentanaPrincipal.obtenerVueloSeleccionado(vueloEncontrado, vueloEncontrado.getHoraSalida());
        		VentanaDatosPasajero miVentanaDatosPasajero = new VentanaDatosPasajero(miVentanaPrincipal, miVuelo, miPanelResultado.miCliente, miPanelResultado);
        		panelEjecutvas.setBackground(Color.RED);
        		miVentanaDatosPasajero.setVisible(true);
        		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(estePanel);
        		frame.dispose();
        		
        	}
        });
        panelEconomicas.add(layeredEconomicas);
        
        JLabel label_1 = new JLabel(vueloEncontrado.getPrecio());
        label_1.setBounds(28, 50, 96, 15);
        layeredEconomicas.add(label_1);
        label_1.setHorizontalAlignment(SwingConstants.CENTER);
        label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        JLabel lblNewLabel_3 = new JLabel("Econ\u00F3mica");
        lblNewLabel_3.setBounds(52, 11, 60, 14);
        layeredEconomicas.add(lblNewLabel_3);
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        JLabel lblNewLabel_2 = new JLabel(sillasEconominasLibes + " asientos libres");
        lblNewLabel_2.setBounds(38, 89, 75, 11);
        layeredEconomicas.add(lblNewLabel_2);
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
        
        JLabel lblCop = new JLabel("COP  ");
        lblCop.setBounds(52, 25, 60, 14);
        layeredEconomicas.add(lblCop);
        lblCop.setHorizontalAlignment(SwingConstants.CENTER);
        lblCop.setForeground(Color.GRAY);
        
        panelEjecutvas = new JPanel();
        panelEjecutvas.setBackground(Color.WHITE);
        panelEjecutvas.setBorder(new LineBorder(SystemColor.scrollbar, 3));
        panel_2.add(panelEjecutvas);
        panelEjecutvas.setLayout(new BoxLayout(panelEjecutvas, BoxLayout.X_AXIS));
        
        JLayeredPane layeredEjecutivas = new JLayeredPane();
        layeredEjecutivas.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Vuelo miVuelo = miVentanaPrincipal.obtenerVueloSeleccionado(vueloEncontrado, vueloEncontrado.getHoraSalida());
        		VentanaDatosPasajero miVentanaDatosPasajero = new VentanaDatosPasajero(miVentanaPrincipal, miVuelo, miPanelResultado.miCliente, miPanelResultado);
        		panelEjecutvas.setBackground(Color.RED);
        		miVentanaDatosPasajero.setVisible(true);
        		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(estePanel);
        		frame.dispose();
        		
        		
        	}
        });
        layeredEjecutivas.setBackground(Color.RED);
        panelEjecutvas.add(layeredEjecutivas);
       
        
        JLabel label_3 = new JLabel(sillasEjecutivasLibres + " asientos libres");
        label_3.setBounds(44, 89, 70, 11);
        layeredEjecutivas.add(label_3);
        label_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
        
        JLabel lblNewLabel_4 = new JLabel("Ejecutiva");
        lblNewLabel_4.setBounds(55, 11, 52, 14);
        layeredEjecutivas.add(lblNewLabel_4);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
        int precioBase = Integer.parseInt(vueloEncontrado.getPrecio());
        int precioBaseEje = (precioBase* 10) / 100;
		precioBaseEje = precioBaseEje + precioBase;
		
        JLabel label_2 = new JLabel(precioBaseEje+"");
        label_2.setBounds(53, 50, 76, 15);
        layeredEjecutivas.add(label_2);
        label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        JLabel label = new JLabel("COP");
        label.setBounds(62, 25, 52, 14);
        layeredEjecutivas.add(label);
        label.setForeground(Color.GRAY);
     
     
    
     
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

	
	
	public String getDestino()
	{
		return destino;
	}
}
