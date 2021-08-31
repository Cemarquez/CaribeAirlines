package com.uniquindio.Fundamentos.Interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.uniquindio.Fundamentos.Interfaces.Regreso.VentanaResultadosBusquedaRegreso;
import com.uniquindio.Fundamentos.Interfaces.Reservas.VentanaReservas;
import com.uniquindio.Fundamentos.Mundo.Avion;
import com.uniquindio.Fundamentos.Mundo.Cliente;
import com.uniquindio.Fundamentos.Mundo.Pasajero;
import com.uniquindio.Fundamentos.Mundo.Reserva;
import com.uniquindio.Fundamentos.Mundo.Silla;
import com.uniquindio.Fundamentos.Mundo.Trayecto;
import com.uniquindio.Fundamentos.Mundo.Vuelo;
import com.uniquindio.Fundamentos.Util.Util;
import com.uniquindio.Fundamentos.Mundo.Silla.Clase;
@SuppressWarnings("serial")
public class VentanaPago extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panelResumenVuelo;
	private JPanel panel_1;
	private JRadioButton botonReserva;
	private JRadioButton botonTarjeta;
	private JButton btnContinuar;
	private ArrayList<Pasajero> pasajeros;
	private Vuelo vueloSeleccionado;
	private ArrayList<Silla> sillas;
	private Cliente miCliente;
	private JTextField textFieldKilosAdicionales;
	private JLabel labelPrecioEquipaje;
	private int precioEquipaje=0;
	private int precioTotal=0;
	private VentanaPrincipal miVentanaPrincipal;
	private JLabel labelPrecioTotal;
	private int precioBoletos;
	private Avion avion;
	private int kilos;
	private String modalidad;
	private String fechaaRegreso;
	private ArrayList<Vuelo> vuelosRegreso;
	private String nuevoOrigen;
	private String nuevoDestino;
	ButtonGroup grupoPago = new ButtonGroup();


	public VentanaPago(ArrayList<Pasajero> pasajeros, Vuelo vueloSeleccionado, ArrayList<Silla> sillas, Cliente miCliente, VentanaPrincipal miVentanaPrincipal, String modalidad, String fechaaRegreso) {
		this.sillas = sillas;
		this.pasajeros = pasajeros;
		this.vueloSeleccionado = vueloSeleccionado;
		this.miCliente = miCliente;
		this.miVentanaPrincipal = miVentanaPrincipal;
		this.avion = vueloSeleccionado.getAvion();
		this.modalidad = modalidad;
		this.fechaaRegreso = fechaaRegreso;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaReservas.class.getResource("/imagenes/plane.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		constPanelSuperior();
		constPanelDestinoOrigen();
		constPanelShidorris();
		setResizable(false);
		setLocationRelativeTo(null);		
		
	}
	
	public void constPanelSuperior()
	{
		panelResumenVuelo = new JPanel();
		panelResumenVuelo.setBorder(new EmptyBorder(0, 10, 0, 0));
		panelResumenVuelo.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelResumenVuelo.setBackground(Color.WHITE);
		panelResumenVuelo.setLayout(new BoxLayout(panelResumenVuelo, BoxLayout.Y_AXIS));
		JLabel labelResumenVuelo = new JLabel("Resumen del viaje");
		labelResumenVuelo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelResumenVuelo.setBackground(Color.WHITE);
		labelResumenVuelo.setForeground(Color.RED);
		labelResumenVuelo.setHorizontalAlignment(SwingConstants.LEFT);
		panelResumenVuelo.add(labelResumenVuelo);
		panelResumenVuelo.add( new JLabel("  "));
		
				
				
				
				JLabel labelInfo = new JLabel("Encuentra acontinuaci\u00F3n la informaci\u00F3n relacionada con tu compra.                                                        ");
				labelInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
				JLabel labelInfo2 = new JLabel("Detalles de tu vuelo");
				labelInfo2.setForeground(Color.RED);
				labelInfo2.setFont(new Font("Tahoma", Font.PLAIN, 20));
				
				panelResumenVuelo.add(labelInfo);
				panelResumenVuelo.add( new JLabel("  "));
				panelResumenVuelo.add(labelInfo2);
	}
	
	public void constPanelDestinoOrigen()
	{
		
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setAlignmentX(6.0f);
		panel_1.setBorder(null);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaPago.class.getResource("/imagenes/plane.png")));
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
		panel_1.add(label_1);
		JLabel labelOrigen = new JLabel(vueloSeleccionado.getTrayecto().getOrigen() + " - " + vueloSeleccionado.getTrayecto().getDestino());
		labelOrigen.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(labelOrigen);
		
		
	}
	public void constPanelShidorris() {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		JPanel panelCheck = new JPanel();
		panelCheck.setBackground(Color.WHITE);
		JLabel label = new JLabel("");
		JLabel labelCheck = new JLabel();
		labelCheck.setHorizontalAlignment(SwingConstants.CENTER);
		labelCheck.setIcon(new ImageIcon(VentanaPago.class.getResource("/imagenes/icons8-marca-de-verificaci\u00F3n-48.png")));
		JLabel label_1 = new JLabel("Vuelo seleccionado");
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setLayout(null);
		
		JLabel lblHora = new JLabel(vueloSeleccionado.getHoraSalida());
		lblHora.setForeground(Color.RED);
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHora.setBounds(23, 29, 96, 14);
		layeredPane.add(lblHora);
		GroupLayout gl_panelPrincipal = new GroupLayout(panelPrincipal);
		gl_panelPrincipal.setHorizontalGroup(
			gl_panelPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPrincipal.createSequentialGroup()
					.addComponent(panelCheck, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelPrincipal.setVerticalGroup(
			gl_panelPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPrincipal.createSequentialGroup()
					.addGroup(gl_panelPrincipal.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(layeredPane, Alignment.LEADING)
						.addComponent(panelCheck, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		GroupLayout gl_panelCheck = new GroupLayout(panelCheck);
		gl_panelCheck.setHorizontalGroup(
			gl_panelCheck.createParallelGroup(Alignment.TRAILING)
				.addComponent(label)
				.addComponent(label_1)
				.addGroup(Alignment.LEADING, gl_panelCheck.createSequentialGroup()
					.addGap(19)
					.addComponent(labelCheck)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_panelCheck.setVerticalGroup(
			gl_panelCheck.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCheck.createSequentialGroup()
					.addGroup(gl_panelCheck.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(labelCheck))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_1))
		);
		panelCheck.setLayout(gl_panelCheck);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(94, 40, 267, 2);
		layeredPane.add(separator);
		
		JLabel lblHoraLlegada = new JLabel(Util.sumarHoras(vueloSeleccionado.getHoraSalida(), vueloSeleccionado.getTrayecto().getDuracionMin()));
		lblHoraLlegada.setForeground(Color.RED);
		lblHoraLlegada.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHoraLlegada.setBounds(367, 29, 121, 14);
		layeredPane.add(lblHoraLlegada);
		
		JLabel lblNewLabel = new JLabel(vueloSeleccionado.getFecha());
		lblNewLabel.setBounds(201, 0, 79, 14);
		layeredPane.add(lblNewLabel);
		
		JLabel lblDuracion = new JLabel(vueloSeleccionado.getTrayecto().getDuracionMin() + " Minutos");
		lblDuracion.setBounds(207, 25, 46, 14);
		layeredPane.add(lblDuracion);
		panelPrincipal.setLayout(gl_panelPrincipal);
		
		JLabel lblResumenDelPago = new JLabel("Resumen del pago:");
		lblResumenDelPago.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		panel_2.setBackground(Color.WHITE);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(VentanaPago.class.getResource("/imagenes/icons8-carrito-de-compras-24.png")));
		
		JLabel lblNewLabel_1 = new JLabel("Selecciona tu m\u00E9todo de pago");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		botonReserva = new JRadioButton("");
		grupoPago.add(botonReserva);
		botonReserva.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_2 = new JLabel("RESERVA");
		
		botonTarjeta = new JRadioButton("");
		grupoPago.add(botonTarjeta);
		botonTarjeta.setBackground(Color.WHITE);
		botonReserva.addActionListener(this);
		botonTarjeta.addActionListener(this);
		JLabel lblTarjetaDeCrditodebito = new JLabel("TARJETA DE CR\u00C9DITO");
		
		JSeparator separator_2 = new JSeparator();
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(VentanaPago.class.getResource("/imagenes/icons8-reserva-50.png")));
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(VentanaPago.class.getResource("/imagenes/icons8-visa-64.png")));
		
		
			btnContinuar = new JButton("Continuar");
			btnContinuar.setForeground(Color.BLACK);
			btnContinuar.setBackground(Color.YELLOW);
			btnContinuar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnContinuar.addActionListener(this);
		
		
		
		
		JLabel lblPesoAdicionalEn = new JLabel("Peso adicional en bodega:");
		
		textFieldKilosAdicionales = new JTextField();
		textFieldKilosAdicionales.setText("0");
		textFieldKilosAdicionales.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Kg");
		
		JLabel lblenEstaCompra = new JLabel("(En esta compra puede llevar adicional hasta ");
		
		JLabel LabelKilosQuePuedeLLevar = new JLabel(avion.getKilosDisponibles() + "");
		LabelKilosQuePuedeLLevar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblKilos = new JLabel("Kilos)");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panelResumenVuelo, GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(259, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(botonReserva)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(botonTarjeta)))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_2))
								.addComponent(lblTarjetaDeCrditodebito))
							.addPreferredGap(ComponentPlacement.RELATED, 434, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_4)
								.addComponent(label_5))
							.addGap(21))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addContainerGap(496, Short.MAX_VALUE))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator_2, GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(302)
					.addComponent(btnContinuar, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(275, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(label_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblResumenDelPago)
					.addContainerGap(513, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblPesoAdicionalEn)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldKilosAdicionales, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3)
							.addGap(18)
							.addComponent(lblenEstaCompra)
							.addGap(2)
							.addComponent(LabelKilosQuePuedeLLevar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblKilos))
						.addComponent(panelPrincipal, GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelResumenVuelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelPrincipal, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPesoAdicionalEn)
								.addComponent(textFieldKilosAdicionales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3)
								.addComponent(lblenEstaCompra)
								.addComponent(LabelKilosQuePuedeLLevar)
								.addComponent(lblKilos))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblResumenDelPago)
								.addComponent(label_3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(botonReserva, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblTarjetaDeCrditodebito, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(botonTarjeta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(250)
							.addComponent(label_5)))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(btnContinuar, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
		);
		
		JLabel lblPreciosBoletos = new JLabel("Precios boletos:");
		int sillasEje = contarSillasEjeSeleccionadas();
		int sillasEco = contarSillasEcoSeleccionadas();
		 precioBoletos = hallarPrecio(sillasEco, sillasEje);
		JLabel lblPrecio = new JLabel(precioBoletos +"");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblcop = new JLabel("(COP)");
		lblcop.setForeground(Color.LIGHT_GRAY);
		lblcop.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblPrecioServicios = new JLabel("Precio equipaje:");
		
		labelPrecioEquipaje = new JLabel(precioEquipaje+ "");
		labelPrecioEquipaje.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblcop_1 = new JLabel("(COP)");
		lblcop_1.setForeground(Color.LIGHT_GRAY);
		lblcop_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblTotalAPagar = new JLabel("Total a pagar:");
		
		labelPrecioTotal = new JLabel((precioBoletos + precioEquipaje)+ "");
		textFieldKilosAdicionales.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				javax.swing.Timer timer = new javax.swing.Timer(100, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
					if(textFieldKilosAdicionales.getText().equals("")||textFieldKilosAdicionales.getText()==null)
					{
						kilos = 0;
						labelPrecioEquipaje.setText("0");
					    labelPrecioTotal.setText(precioBoletos + "");
					}else {
						kilos = Util.leerEnteros(textFieldKilosAdicionales.getText());
						precioEquipaje = kilos*5000;
						labelPrecioEquipaje.setText(precioEquipaje + "");
						labelPrecioTotal.setText((precioBoletos + precioEquipaje) +"");
						
					}
					}
					
				});
			
				timer.setRepeats(true);
				timer.start();
			}
		});
		
		labelPrecioTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblcopincluye = new JLabel("(COP) (Incluye impuestos, sobrecargos y servicios)");
		lblcopincluye.setForeground(Color.LIGHT_GRAY);
		lblcopincluye.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblPreciosBoletos)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPrecio)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblcop))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblPrecioServicios)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(labelPrecioEquipaje)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblcop_1))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblTotalAPagar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(labelPrecioTotal)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblcopincluye)))
					.addContainerGap(112, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
		
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPreciosBoletos)
						.addComponent(lblPrecio)
						.addComponent(lblcop))
					.addGap(2)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecioServicios)
						.addComponent(labelPrecioEquipaje)
						.addComponent(lblcop_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotalAPagar)
						.addComponent(labelPrecioTotal)
						.addComponent(lblcopincluye))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnContinuar)
		{
			
			if(modalidad.equals("ida y regreso"))
			{
				if(textFieldKilosAdicionales.getText().equalsIgnoreCase("") || textFieldKilosAdicionales.getText()== null || !Util.isNumeroString(textFieldKilosAdicionales.getText()) || Util.leerEnteros(textFieldKilosAdicionales.getText()) >= avion.getKilosDisponibles()) {
					JOptionPane.showMessageDialog(null, "La información suministrada no es válida.", "Error", JOptionPane.WARNING_MESSAGE);
				}else {
					nuevoOrigen = vueloSeleccionado.getTrayecto().getDestino();
					nuevoDestino = vueloSeleccionado.getTrayecto().getOrigen();
					
					Trayecto trayectoRegreso = new Trayecto(nuevoOrigen, nuevoDestino);
					 vuelosRegreso = miVentanaPrincipal.buscarVuelo(trayectoRegreso, fechaaRegreso);
					precioTotal = precioBoletos + precioEquipaje;
					 kilos = Integer.parseInt(textFieldKilosAdicionales.getText());
					if(botonTarjeta.isSelected() && botonReserva.isSelected())
					{
						JOptionPane.showMessageDialog(null, "Por favor seleccione sólo un método de pago.", "Error", JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						if(botonReserva.isSelected() || botonTarjeta.isSelected())
						{
						if(botonReserva.isSelected())
						{
							int opcion = JOptionPane.showConfirmDialog(null, "¿Está completamente seguro de querer hacer esta reserva?", "Confirmar reserva", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if(opcion == JOptionPane.YES_OPTION)
		                    {
								for(int i=0;i<pasajeros.size();i++)
								{
									Silla silla = sillas.get(i);
									Pasajero pasajero = pasajeros.get(i);
									Reserva reserva = new Reserva(pasajero, silla, vueloSeleccionado);
									miCliente.agregarReservaAlCliente(reserva);
									miVentanaPrincipal.AñadirReservaAerolinea(reserva);
								}
							  vueloSeleccionado.setRealizado(true);
								VentanaResultadosBusquedaRegreso miVRB = new VentanaResultadosBusquedaRegreso(miVentanaPrincipal, this, miCliente);
								JOptionPane.showMessageDialog(null, "Reservas realizadas correctamente." + "\n" + "Para obtener más información visite la ventana principal de su sesión. A continuación pasará a escoger el vuelo de regreso", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
		                    	miVRB.setVisible(true);
		                    	this.dispose();
		                    }
							
							
							
						}
						
						if(botonTarjeta.isSelected())
						{
							
							VentanaTarjetaCredito miVTC = new VentanaTarjetaCredito(miVentanaPrincipal, this, miCliente, modalidad);
							miVTC.setVisible(true);
							this.dispose();
						}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Por favor seleccione un método de pago.", "Error", JOptionPane.WARNING_MESSAGE);
						}
				}	
				}
				
			   
			}
			else
			{
				
				if(textFieldKilosAdicionales.getText().equalsIgnoreCase("") || textFieldKilosAdicionales.getText()== null || !Util.isNumeroString(textFieldKilosAdicionales.getText()) || Util.leerEnteros(textFieldKilosAdicionales.getText()) >= avion.getKilosDisponibles()) {
					JOptionPane.showMessageDialog(null, "La información suministrada no es válida.", "Error", JOptionPane.WARNING_MESSAGE);
				}else {
					VentanaFuncionesCliente miVFC = new VentanaFuncionesCliente(miVentanaPrincipal, miCliente);
					 precioTotal = precioBoletos + precioEquipaje;
					 kilos = Integer.parseInt(textFieldKilosAdicionales.getText());
					if(botonTarjeta.isSelected() && botonReserva.isSelected())
					{
						JOptionPane.showMessageDialog(null, "Por favor seleccione sólo un método de pago.", "Error", JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						if(botonReserva.isSelected() || botonTarjeta.isSelected())
						{
						if(botonReserva.isSelected())
						{
							int opcion = JOptionPane.showConfirmDialog(null, "¿Está completamente seguro de querer hacer esta reserva?", "Confirmar reserva", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if(opcion == JOptionPane.YES_OPTION)
		                    {
								for(int i=0;i<pasajeros.size();i++)
								{
									Silla silla = sillas.get(i);
									Pasajero pasajero = pasajeros.get(i);
									Reserva reserva = new Reserva(pasajero, silla, vueloSeleccionado);
									miCliente.agregarReservaAlCliente(reserva);
									miVentanaPrincipal.AñadirReservaAerolinea(reserva);
								}
								miVentanaPrincipal.serializar();
								vueloSeleccionado.setRealizado(true);
								JOptionPane.showMessageDialog(null, "Reservas realizadas correctamente." + "\n" + "Para obtener más información visite la ventana principal de su sesión.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
		                    	miVFC.setVisible(true);
		                    	this.dispose();
		                    }
							
							
							
						}
						
						if(botonTarjeta.isSelected())
						{
							
							VentanaTarjetaCredito miVTC = new VentanaTarjetaCredito(miVentanaPrincipal, this, miCliente, modalidad);
							miVTC.setVisible(true);
							this.dispose();
						}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Por favor seleccione un método de pago.", "Error", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				
			}
			}
			
		
	}
	public int getKilos()
	{
		return kilos;
	}
	public int contarSillasEcoSeleccionadas()
	{
		int numero=0;
		for(int i=0;i<sillas.size();i++)
		{
			if(sillas.get(i).getClase() == Clase.ECONOMICA)
			{
				numero++;
			}
		}
		
		return numero;
	}
	
	public int contarSillasEjeSeleccionadas()
	{
		int numero=0;
		for(int i=0;i<sillas.size();i++)
		{
			if(sillas.get(i).getClase() == Clase.EJECUTIVA)
			{
				numero++;
			}
		}
		
		return numero;
	}
	
	public int hallarPrecio(int sillasEco, int sillasEje) {
		int precio =0;
		int precioBase = Integer.parseInt(vueloSeleccionado.getPrecio());
		int precioTotalEco = precioBase * sillasEco;
		int precioBaseEje = (precioBase* 10) / 100;
		precioBaseEje = precioBaseEje + precioBase;
		int precioTotalEje = precioBaseEje * sillasEje;
		precio = precioTotalEco + precioTotalEje;
		return precio;
	}

	public ArrayList<Pasajero> getPasajeros() {
		return pasajeros;
	}

	public Vuelo getVueloSeleccionado() {
		return vueloSeleccionado;
	}

	public ArrayList<Silla> getSillas() {
		return sillas;
	}

	public Cliente getMiCliente() {
		return miCliente;
	}

	public int getPrecioTotal() {
		return precioTotal;
	}

	public int getPrecioEquipaje() {
		return precioEquipaje;
	}

	public int getPrecioBoletos() {
		return precioBoletos;
	}
	public ArrayList<Vuelo> getVuelosRegreso()
	{
	return vuelosRegreso;	
	}
	
	public String getFechaRegreso()
	{
		return fechaaRegreso;
		
	}
	public String getDestinoRegreso()
	{
		return nuevoDestino;
	}
	
	public String getOrigenRegreso()
	{
		return nuevoOrigen;
	}
	
	
	
}
