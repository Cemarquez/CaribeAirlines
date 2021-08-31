package com.uniquindio.Fundamentos.Interfaces;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import com.uniquindio.Fundamentos.Interfaces.Paneles.PanelResultado;
import com.uniquindio.Fundamentos.Interfaces.Reservas.VentanaReservas;
import com.uniquindio.Fundamentos.Miscelanea.TextPrompt;
import com.uniquindio.Fundamentos.Mundo.Cliente;
import com.uniquindio.Fundamentos.Mundo.Pasajero;
import com.uniquindio.Fundamentos.Mundo.Vuelo;
@SuppressWarnings("serial")
public class VentanaDatosPasajero extends JFrame implements ActionListener {
private ArrayList<Pasajero> pasajeros=new ArrayList<Pasajero>();
	private JPanel contentPane;
	private JLabel lblPasajeroNmero;
	private JLabel labelIconoPersona;
	private JPanel panelPasajero;
	private JPanel panelDatos;
	private JLabel lblApellidos;
	private JTextField textFieldApellidos;
	private JPanel panelNombres;
	private JButton botonContinuar;
	private JTextField textFielNombres;
	private JTextField textFieldCedula;
	private JDateChooser dateChooserFechaNacimiento;
   private VentanaLogin miVentanaLogin;
   private VentanaPrincipal miVentanaPrincipal;
    private Cliente clienteLogeado;
    private Vuelo miVuelo;
    private PanelResultado miPanelResultado;
    private int contador;
    private String origen;
	private String destino;
	private String modalidad;
	private int cantAdultos;
	private int cantNiños;
	private String fechaaIda;
	private String fechaaRegreso;
	
	/**
	 * Launch the application.
	 */
	private JLabel lblNewLabel_2;
	

	/**
	 * Create the frame.
	 */
	public VentanaDatosPasajero(VentanaPrincipal miVentanaPrincipal, Vuelo miVuelo, Cliente miCliente, PanelResultado miPanelResultado) {
		this.miPanelResultado = miPanelResultado;
	    this.miVuelo = miVuelo;
		this.miVentanaLogin = miVentanaLogin;
		this.miVentanaPrincipal = miVentanaPrincipal;
		
		origen = miPanelResultado.getOrigen();
		destino = miPanelResultado.getDestino();
		modalidad = miPanelResultado.getModalidad();
		cantAdultos = miPanelResultado.getCantAdultos();
		cantNiños  = miPanelResultado.getCantNiños();
		fechaaIda = miPanelResultado.getFechaaIda();
		fechaaRegreso =miPanelResultado.getFechaaRegreso();
		this.clienteLogeado = miCliente;
		contador =1;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaReservas.class.getResource("/imagenes/plane.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 552);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 20, 5));
		setContentPane(contentPane);
		constPanelPasajero();
		constPanelDatos();
		constPanelInfoCompra();
		constPanelInferior();
		
		
		
	}
	
	public void constPanelPasajero()
	{
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		panelPasajero = new JPanel();
		panelPasajero.setBorder(new EmptyBorder(5, 10, 5, 10));
		panelPasajero.setBackground(new Color(255, 228, 196));
		contentPane.add(panelPasajero);
		panelPasajero.setLayout(new GridLayout(0, 2, 0, 0));
		
		labelIconoPersona = new JLabel("");
		labelIconoPersona.setBackground(new Color(255, 228, 196));
		labelIconoPersona.setHorizontalAlignment(SwingConstants.LEFT);
		labelIconoPersona.setIcon(new ImageIcon(VentanaDatosPasajero.class.getResource("/imagenes/none.png")));
		panelPasajero.add(labelIconoPersona);
		
		JPanel panelNumeroPasa = new JPanel();
		panelNumeroPasa.setBackground(new Color(255, 228, 196));
		panelNumeroPasa.setBorder(new EmptyBorder(12, 1, 15, 0));
		panelNumeroPasa.setLayout(new BoxLayout(panelNumeroPasa, BoxLayout.X_AXIS));
		lblPasajeroNmero = new JLabel("Pasajero " + contador);
		lblPasajeroNmero.setLabelFor(panelNumeroPasa);
		lblPasajeroNmero.setForeground(new Color(0, 0, 0));
		lblPasajeroNmero.setBackground(new Color(255, 228, 181));
		lblPasajeroNmero.setHorizontalAlignment(SwingConstants.CENTER);
		panelNumeroPasa.add(lblPasajeroNmero);
		
		panelPasajero.add(panelNumeroPasa);
		
		
	}
	
	public void constPanelDatos()
	{
		panelDatos = new JPanel();
		
		contentPane.add(panelDatos);
		panelDatos.setLayout(new GridLayout(0, 1, 0, 0));
		JPanel panelInformacionPersonal = new JPanel();
		panelInformacionPersonal.setBackground(Color.WHITE);
		panelInformacionPersonal.setBorder(new EmptyBorder(10, 10, 0, 0));
		panelInformacionPersonal.setLayout(new GridLayout(0, 1, 0, 0));
		JLabel labelInformacionPersonal = new JLabel("Información personal");
		labelInformacionPersonal.setForeground(Color.GRAY);
		labelInformacionPersonal.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		labelInformacionPersonal.setBackground(Color.WHITE);
		labelInformacionPersonal.setVerticalAlignment(SwingConstants.BOTTOM);
		labelInformacionPersonal.setHorizontalAlignment(SwingConstants.LEFT);
		panelInformacionPersonal.add(labelInformacionPersonal);
		panelDatos.add(panelInformacionPersonal);
		JPanel panelInfo = new JPanel();
		panelInfo.setBorder(null);
		contentPane.add(panelInfo);
		panelInfo.setLayout(new GridLayout(1, 0,0,0));
		panelInfo.setSize(100, 100);
		
		JPanel panelApellidos = new JPanel();
		panelApellidos.setBackground(Color.WHITE);
		panelApellidos.setBorder(new EmptyBorder(0, 10, 0, 20));
		panelApellidos.setLayout(new GridLayout(8, 1, 0, -15));
		lblApellidos = new JLabel("Apellido(s): *");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblApellidos.setBackground(Color.WHITE);
		panelApellidos.add(lblApellidos);
		textFieldApellidos = new JTextField();
		TextPrompt placeholderApellidos = new TextPrompt("* Introduce apellidos", textFieldApellidos);
		placeholderApellidos.changeAlpha(0.75f);
	    placeholderApellidos.changeStyle(Font.ITALIC);
	    panelApellidos.add(new JLabel(""));
	    JLabel label_1 = new JLabel("");
	    label_1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
	    panelApellidos.add(label_1);
	    panelApellidos.add(new JLabel(""));
		panelApellidos.add(textFieldApellidos);
		
		textFieldApellidos.setColumns(10);
	
		panelInfo.add(panelApellidos);
		
		panelNombres = new JPanel();
		panelNombres.setBackground(Color.WHITE);
		panelNombres.setBorder(new EmptyBorder(0, 0, 0, 22));
	
		panelInfo.add(panelNombres);
		JLabel labelNombres = new JLabel("Nombre(s):  *");
		labelNombres.setFont(new Font("Tahoma", Font.BOLD, 9));
		textFielNombres = new JTextField();
		TextPrompt placeholderNombres = new TextPrompt("* Introduce nombres ", textFielNombres);
		placeholderNombres.changeAlpha(0.75f);
		placeholderNombres.changeStyle(Font.ITALIC);
		panelNombres.setLayout(new GridLayout(8, 1, 0, -15));
		panelNombres.add(labelNombres);
		JLabel label = new JLabel("");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		panelNombres.add(label);
		panelNombres.add(new JLabel(""));
		panelNombres.add(new JLabel(""));
		panelNombres.add(textFielNombres);
		
		JPanel panelTodo = new JPanel();
		contentPane.add(panelTodo);
		panelTodo.setLayout(new BoxLayout(panelTodo, BoxLayout.X_AXIS));
		
		JPanel panelCedula = new JPanel();
		panelCedula.setBorder(new EmptyBorder(0, 10, 0, 0));
		panelCedula.setBackground(Color.WHITE);
		panelTodo.add(panelCedula);
		panelCedula.setLayout(new GridLayout(8, 1, 0, -15));
		
		JLabel lblCdula = new JLabel("C\u00E9dula: *");
		lblCdula.setFont(new Font("Tahoma", Font.BOLD, 9));
		panelCedula.add(lblCdula);
		
		JLabel lblNewLabel = new JLabel("");
		panelCedula.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panelCedula.add(lblNewLabel_1);
		
		JLabel label_2 = new JLabel("");
		panelCedula.add(label_2);
		
		textFieldCedula = new JTextField();
		panelCedula.add(textFieldCedula);
		textFieldCedula.setColumns(10);
		TextPrompt phCedula = new TextPrompt("* Introduce cédula", textFieldCedula);
		phCedula.changeAlpha(0.75f);
	    phCedula.changeStyle(Font.ITALIC);
		
		JPanel panelFechaa = new JPanel();
		panelFechaa.setBackground(Color.WHITE);
		panelFechaa.setBorder(new EmptyBorder(0, 10, 0, 0));
		panelTodo.add(panelFechaa);
		panelFechaa.setLayout(new BoxLayout(panelFechaa, BoxLayout.Y_AXIS));
		
		
		JPanel panelFechaNacimiento = new JPanel();
		panelFechaa.add(panelFechaNacimiento);
		panelFechaNacimiento.setBackground(Color.WHITE);
		panelFechaNacimiento.setBorder(new EmptyBorder(10, 10, 0, 0));
	     panelFechaNacimiento.setLayout(new GridLayout(0, 1, 0, 0));
	     JLabel fechaNacimiento = new JLabel("Fecha de nacimiento: *");
	     fechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 9));
	     panelFechaNacimiento.add(fechaNacimiento);
	     
	     JPanel panelFecha = new JPanel();
	     panelFechaa.add(panelFecha);
	     panelFecha.setBackground(Color.WHITE);
	     panelFecha.setBorder(new EmptyBorder(0, 0, 0, 0));
	     panelFecha.setLayout(new GridLayout(1, 0, 0, 0));
	     JPanel paneldia = new JPanel();
	     paneldia.setBackground(Color.WHITE);
	     paneldia.setBorder(new EmptyBorder(5, 10, 0, 80));
	     paneldia.setLayout(new GridLayout(5, 1, 0, -15));
	     
	     dateChooserFechaNacimiento = new JDateChooser();
	     Calendar c3 = new GregorianCalendar();
	     dateChooserFechaNacimiento.setCalendar(c3);
	     paneldia.add(dateChooserFechaNacimiento);
	     panelFecha.add(paneldia);
	    
	     
	     
		
		
		
		
	}
	
	public void constPanelInfoCompra()
	{
		JPanel panelTuSeleccion = new JPanel();
		panelTuSeleccion.setBackground(Color.RED);
		panelTuSeleccion.setLayout(new GridLayout(0, 1, 0, 0));
		JLabel labelTuSeleccion = new JLabel("Tu selección");
		labelTuSeleccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelTuSeleccion.setHorizontalAlignment(SwingConstants.CENTER);
		labelTuSeleccion.setForeground(Color.WHITE);
		panelTuSeleccion.add(labelTuSeleccion);
		contentPane.add(panelTuSeleccion);
		
		
		JPanel panelNumeroPasajeros = new JPanel();
		panelNumeroPasajeros.setBackground(SystemColor.inactiveCaptionBorder);
		panelNumeroPasajeros.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
	     JLabel labelNumeroPasajeros = new JLabel((cantAdultos + cantNiños) + " PASAJEROS");
	     labelNumeroPasajeros.setFont(new Font("Tahoma", Font.BOLD, 11));
	     labelNumeroPasajeros.setHorizontalAlignment(SwingConstants.CENTER);
		panelNumeroPasajeros.add(labelNumeroPasajeros);
		contentPane.add(panelNumeroPasajeros);
		
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(SystemColor.inactiveCaptionBorder);
		panelInfo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPane.add(panelInfo);
		panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
		
		
		JPanel panelModoVuelo = new JPanel();
		panelModoVuelo.setBackground(SystemColor.inactiveCaptionBorder);
		panelModoVuelo.setBorder(null);
		JLabel labelModoVuelo = new JLabel(miPanelResultado.getModalidad());
		labelModoVuelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelModoVuelo.add(labelModoVuelo);
		panelInfo.add(panelModoVuelo);
		
		JPanel panelFechaVuelo = new JPanel();
		panelFechaVuelo.setBackground(SystemColor.inactiveCaptionBorder);
		panelFechaVuelo.setBorder(null);
		JLabel labelFechaVuelo = new JLabel(miPanelResultado.getFechaaIda());
		labelFechaVuelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelFechaVuelo.add(labelFechaVuelo);
		panelInfo.add(panelFechaVuelo);
		
		JPanel panelInfoOrigenDestino = new JPanel();
		panelInfoOrigenDestino.setBackground(SystemColor.inactiveCaptionBorder);
		panelInfoOrigenDestino.setAlignmentX(0.51f);
		JLabel labelOrigen = new JLabel(miPanelResultado.getOrigen());
		labelOrigen.setFont(new Font("Sitka Text", Font.PLAIN, 11));
		JLabel labelDestino = new JLabel(miPanelResultado.getDestino());
		labelDestino.setFont(new Font("Sitka Text", Font.PLAIN, 11));
		labelDestino.setHorizontalAlignment(SwingConstants.LEFT);
		panelInfoOrigenDestino.setLayout(new BoxLayout(panelInfoOrigenDestino, BoxLayout.Y_AXIS));
		panelInfoOrigenDestino.add(labelOrigen);
		panelInfoOrigenDestino.add(labelDestino);
		panelInfo.add(panelInfoOrigenDestino);
		
		JPanel panelDuracion = new JPanel();
		panelDuracion.setBackground(SystemColor.inactiveCaptionBorder);
		JLabel labelDuracion = new JLabel("Duración total " + miVuelo.getTrayecto().getDuracionMin() + " minutos");
		panelDuracion.add(labelDuracion);
		panelInfo.add(panelDuracion);
		
		JPanel panelTotal = new JPanel();
		panelTotal.setBackground(SystemColor.menu);
		panelTotal.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		JPanel panelPrecioTotal = new JPanel();
		panelPrecioTotal.setBackground(SystemColor.inactiveCaptionBorder);
		panelPrecioTotal.setBorder(null);
		
		contentPane.add(panelTotal);
		panelTotal.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelTotal.add(panelPrecioTotal);
		
		JLabel labelTotal = new JLabel("TOTAL:");
		labelTotal.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		labelTotal.setHorizontalAlignment(SwingConstants.LEFT);
		panelPrecioTotal.add(labelTotal);
		int precio = Integer.parseInt(miVuelo.getPrecio()) * cantAdultos;
		int precio2 = Integer.parseInt(miVuelo.getPrecio()) * cantNiños;
		int precio3 = precio + precio2;
		JLabel labelPrecioTotal = new JLabel(precio3 + "");
		labelPrecioTotal.setForeground(Color.RED);
		labelPrecioTotal.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		
		panelPrecioTotal.add(labelPrecioTotal);
		
		JPanel panelInformacionVenta = new JPanel();
		panelInformacionVenta.setBackground(SystemColor.inactiveCaptionBorder);
		panelTotal.add(panelInformacionVenta);
		JLabel labelInformacion = new JLabel("Total para todos los pasajero(s) e incluye" + "\n" +  " impuestos y sobrecargos");
		labelInformacion.setFont(new Font("Yu Gothic Light", Font.PLAIN, 9));
		panelInformacionVenta.add(labelInformacion);
		setResizable(false);
		
		setLocationRelativeTo(null);
	}
	
	public void constPanelInferior()
	{
		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(Color.WHITE);
		botonContinuar = new JButton();
		botonContinuar.setPressedIcon(new ImageIcon("data/imagenes/button(3).png"));
		botonContinuar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonContinuar.setFocusPainted(false);
		botonContinuar.setSelected(true);
		botonContinuar.setBorder(null);
		botonContinuar.setBackground(Color.WHITE);
		botonContinuar.setIcon(new ImageIcon(VentanaDatosPasajero.class.getResource("/imagenes/button.png")));
		panelInferior.add(botonContinuar);
		botonContinuar.addActionListener(this);
		contentPane.add(panelInferior);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		if(e.getSource() == botonContinuar)
		{
			if(textFieldCedula.getText().equals("") || textFieldApellidos.getText().equals("") || textFielNombres.getText().equals(""))
			{
				 JOptionPane.showMessageDialog(null, "Faltan campos por ser llenados. Por favor revise y continue de nuevo.","Error", JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				String nombre = textFielNombres.getText();
				String apellido = textFieldApellidos.getText();
				String id = textFieldCedula.getText();
				int dia = dateChooserFechaNacimiento.getCalendar().get(Calendar.DAY_OF_MONTH);
				int mes = dateChooserFechaNacimiento.getCalendar().get(Calendar.MONTH);
				int año = dateChooserFechaNacimiento.getCalendar().get(Calendar.YEAR);
				String fechaNacimiento = dia + "/" + mes + "/" + año;
				Pasajero pasajero = new Pasajero(id, nombre, apellido, fechaNacimiento);
				if(contador< (cantAdultos + cantNiños))
				{
					
					if(miVuelo.pasajeroRepetido(pasajero) == false)
					{
						
						clienteLogeado.agregarPasajero(pasajero);
						miVuelo.agregarPasajero(pasajero);
						pasajeros.add(pasajero);
						textFielNombres.setText("");
						textFieldApellidos.setText("");
						textFieldCedula.setText("");
						contador = sumarContador(contador);
						lblPasajeroNmero.setText("Pasajero " + contador);
					}
					else
					{
						 JOptionPane.showMessageDialog(null, "Ya existe un pasajero con esa cédula en el vuelo.","Error", JOptionPane.WARNING_MESSAGE);
					}
					
					
					
				}
				else
				{
					if(miVuelo.getAvion().pasajeroRepetido(pasajero) == false)
					{
						VentanaSillas miVS = new VentanaSillas(miVentanaPrincipal, this, modalidad, fechaaRegreso);
						clienteLogeado.agregarPasajero(pasajero);
						pasajeros.add(pasajero);
						miVuelo.agregarPasajero(pasajero);
						miVS.setVisible(true);
						this.dispose();
					}
					else
					{
						 JOptionPane.showMessageDialog(null, "Ya existe un pasajero con esa cédula en el vuelo.","Error", JOptionPane.WARNING_MESSAGE);
					}
					}
					
				}
			}
			
			
		}
		
	
	
	
	public int sumarContador(int contador)
	{
		int contador1=contador;
		contador1 =contador1 + 1;
		return contador1;
	}

	public Cliente getClienteLogeado() {
		return clienteLogeado;
	}

	public Vuelo getMiVuelo() {
		return miVuelo;
	}

	public int getCantAdultos() {
		return cantAdultos;
	}

	public int getCantNiños() {
		return cantNiños;
	}
	
	public ArrayList<Pasajero> getPasajeros()
	{
		return pasajeros;
	}
	public String getModalidad()
	{
		return modalidad;
	}
	
	
	

}
