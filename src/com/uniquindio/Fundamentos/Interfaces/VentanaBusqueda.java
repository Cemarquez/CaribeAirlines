package com.uniquindio.Fundamentos.Interfaces;

import java.awt.Color;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import com.uniquindio.Fundamentos.Interfaces.Reservas.VentanaReservas;
import com.uniquindio.Fundamentos.Mundo.Cliente;
import com.uniquindio.Fundamentos.Mundo.Trayecto;
import com.uniquindio.Fundamentos.Mundo.Vuelo;

/**
 * Interfaz de ventana de busqueda  de vuelos para el usuario
 * @author Cesar Marquez - Brian Giraldo
 *
 */
@SuppressWarnings("serial")
public class VentanaBusqueda extends JFrame implements ActionListener
{

	private JPanel contentPane, panel, idaRegreso, claseEconómica, comboOrigen, comboDestino, fechaIda, fechaRegreso, Ida, pestañas, espacio,
				   claseEjecutiva, frase, datos1, titVuelo, datos2, titClase, panel_1,  panel_7, panel_19, panel_18, panel_20;
	private JTabbedPane tabVentanas;
	
	private JRadioButton radIdaRegreso, radIda, radClaseEjecutiva, radClaseEconmica;
	private JLabel lblOrigen, lblDestino, lblFechaIda, lblNewLabel, lblFechaRegreso, label, lblNewLabel_1, lblNewLabel_2, lblVuelo, lblClase,
	               lblApresurateABuscar, lblNumeroPasajeros, lblNiños, lblAdultos;              
	private JComboBox<String> boxOrigen, boxDestino, comboBox, comboBox_1;
	private JButton btnBuscarVuelos;
	private VentanaPrincipal miVentanaPrincipal;
	ButtonGroup grupoVuelo = new ButtonGroup();
	ButtonGroup grupoClase = new ButtonGroup();
	
	private JPanel panel_22;
	private JPanel panel_21;
	private JPanel panel_23;
	private JPanel panel_25;
	private Cliente miCliente;
	private JLabel lblCliente;
	

	/**
	 * Constructor de la ventana de busqueda
	 * @param miVentanaPrincipal Representa a la ventana principal
	 * @param miCliente Representa al cliente actualmente logeado
	 */
	public VentanaBusqueda(VentanaPrincipal miVentanaPrincipal, Cliente miCliente) 
	{
		
		this.miVentanaPrincipal = miVentanaPrincipal;
		this.miCliente = miCliente;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaReservas.class.getResource("/imagenes/plane.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		constBaner();
		constMedio();
		constInferior();
		setResizable(false);
		setLocationRelativeTo(null);		
	}

	/**
	 * Método que construye el banner de la ventana
	 */
	public void constBaner ()
	{
		label = new JLabel("");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setIcon(new ImageIcon(VentanaBusqueda.class.getResource("/imagenes/Baner.jpg")));
		contentPane.add(label);

	}
	
	/**
	 * Construye la parte media de la ventana
	 */
	public void constMedio ()
	{
		{
			pestañas = new JPanel();
			pestañas.setBackground(Color.WHITE);
			contentPane.add(pestañas);
			pestañas.setLayout(new GridLayout(0, 2, 0, 0));
			tabVentanas = new JTabbedPane(JTabbedPane.TOP);
			pestañas.add(tabVentanas);
			tabVentanas.setBackground(Color.WHITE);
			{
				
				panel = new JPanel();
				panel.setBackground(Color.WHITE);
				tabVentanas.addTab("Selecciona tu viaje", null, panel, null);
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
				{
					panel_18 = new JPanel();
					panel_18.setBackground(Color.WHITE);
					panel.add(panel_18);
				}
				{
					titVuelo = new JPanel();
					titVuelo.setBackground(Color.WHITE);
					panel.add(titVuelo);
					titVuelo.setLayout(new GridLayout(0, 1, 0, 0));
					{
						lblVuelo = new JLabel("Vuelo");
						lblVuelo.setVerticalAlignment(SwingConstants.BOTTOM);
						lblVuelo.setHorizontalAlignment(SwingConstants.CENTER);
						lblVuelo.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
						titVuelo.add(lblVuelo);
					}
				}
				{
					datos1 = new JPanel();
					datos1.setBackground(Color.WHITE);
					datos1.setLayout(new GridLayout(6, 2, 0, 0));
					panel.add(datos1);
					{
						idaRegreso = new JPanel();
						datos1.add(idaRegreso);
						idaRegreso.setBackground(Color.WHITE);
						{
							radIdaRegreso = new JRadioButton("Ida y regreso");
							radIdaRegreso.setSelected(true);
							radIdaRegreso.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
							radIdaRegreso.addActionListener(this);
							idaRegreso.add(radIdaRegreso);
							radIdaRegreso.setBackground(Color.WHITE);
							grupoVuelo.add(radIdaRegreso);
						}
					}
					{
						Ida = new JPanel();
						datos1.add(Ida);
						Ida.setBackground(Color.WHITE);
						{
							radIda = new JRadioButton("Solo ida");
							radIda.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
							radIda.addActionListener(this);
							Ida.add(radIda);
							radIda.setBackground(Color.WHITE);
							grupoVuelo.add(radIda);
						}
					}
					{
						lblOrigen = new JLabel("      Origen (Ciudad)");
						lblOrigen.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
						lblOrigen.setBackground(Color.WHITE);
						datos1.add(lblOrigen);
					}
					{
						lblDestino = new JLabel(" Destino (Ciudad)");
						lblDestino.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
						lblDestino.setBackground(Color.WHITE);
						datos1.add(lblDestino);
					}
					{
						comboOrigen = new JPanel();
						datos1.add(comboOrigen);
						comboOrigen.setBackground(Color.WHITE);
						{
							boxOrigen = new JComboBox<String>();
							boxOrigen.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
							comboOrigen.add(boxOrigen);
							boxOrigen.setBackground(Color.WHITE);
							boxOrigen.addActionListener(this);
							boxOrigen.setModel(new DefaultComboBoxModel<String>(new String[] {"M\u00E9xico (Ciudad de M\u00E9xico)", "M\u00E9xico (Monterrey)", "M\u00E9xico (Canc\u00FAn)", "Argentina (Buenos Aires)", "Estados Unidos (Los \u00C1ngeles)", "Colombia (Bogot\u00E1)", "Republica de Panam\u00E1 (Panam\u00E1)"}));
							boxOrigen.setMaximumRowCount(6);
							boxOrigen.addActionListener(new ActionListener() {

								public void actionPerformed(ActionEvent arg0) {
									rellenaCombo2((String) boxOrigen.getSelectedItem());
								}

							});
						}
					}
					{
						comboDestino = new JPanel();
						datos1.add(comboDestino);
						comboDestino.setBackground(Color.WHITE);
						{
							boxDestino = new JComboBox<String>(new String[] {"Destinos"});
							rellenaCombo2((String) boxOrigen.getSelectedItem());
							boxDestino.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
							comboDestino.add(boxDestino);
							boxDestino.setBackground(Color.WHITE);
							
							boxDestino.setMaximumRowCount(6);
						}
					}
					{
						lblFechaIda = new JLabel("Fecha de ida");
						lblFechaIda.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
						lblFechaIda.setBackground(Color.WHITE);
						datos1.add(lblFechaIda);
						lblFechaIda.setHorizontalAlignment(SwingConstants.CENTER);
					}
					{
						lblFechaRegreso = new JLabel("Fecha de regreso");
						lblFechaRegreso.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
						lblFechaRegreso.setBackground(Color.WHITE);
						datos1.add(lblFechaRegreso);
						lblFechaRegreso.setHorizontalAlignment(SwingConstants.CENTER);
					}
					{
						fechaIda = new JPanel();
						datos1.add(fechaIda);
						fechaIda.setBackground(Color.WHITE);
						{
							fechaIdaDate = new JDateChooser();
							Calendar c3 = new GregorianCalendar();
						     fechaIdaDate.setCalendar(c3);
							fechaIda.add(fechaIdaDate);
						}
					}
					{
						fechaRegreso = new JPanel();
						datos1.add(fechaRegreso);
						fechaRegreso.setBackground(Color.WHITE);
						{
							fechaRegresoDate = new JDateChooser();
							 Calendar c2 = new GregorianCalendar();
						     fechaRegresoDate.setCalendar(c2);
							fechaRegreso.add(fechaRegresoDate);
						}
					}
					{
						lblNumeroPasajeros = new JLabel("N\u00FAmero de pasajeros");
						lblNumeroPasajeros.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
						lblNumeroPasajeros.setHorizontalAlignment(SwingConstants.CENTER);
						datos1.add(lblNumeroPasajeros);
					}
					{
						panel_19 = new JPanel();
						panel_19.setBackground(Color.WHITE);
						datos1.add(panel_19);
						panel_19.setLayout(new GridLayout(2, 2, 0, 0));
						{
							lblAdultos = new JLabel("Adultos");
							lblAdultos.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
							panel_19.add(lblAdultos);
						}
						{
							lblNiños = new JLabel("Ni\u00F1os");
							lblNiños.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
							panel_19.add(lblNiños);
						}
						{
							comboBox = new JComboBox<String>();
							comboBox.setMaximumRowCount(9);
							comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
							comboBox.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
							comboBox.setBackground(Color.WHITE);
							panel_19.add(comboBox);
						}
						{
							comboBox_1 = new JComboBox<String>();
							comboBox_1.setBackground(Color.WHITE);
							comboBox_1.setMaximumRowCount(10);
							comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
							comboBox_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
							panel_19.add(comboBox_1);
						}
					}
					
				}
				{
					panel_20 = new JPanel();
					panel_20.setBackground(Color.WHITE);
					panel.add(panel_20);
				}
				{
					titClase = new JPanel();
					titClase.setBackground(Color.WHITE);
					panel.add(titClase);
					titClase.setLayout(new GridLayout(0, 1, 0, 0));
					{
						lblClase = new JLabel("Clase de servicio");
						lblClase.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
						lblClase.setVerticalAlignment(SwingConstants.BOTTOM);
						lblClase.setHorizontalAlignment(SwingConstants.CENTER);
						lblClase.setBackground(Color.WHITE);
						titClase.add(lblClase);
					}
				}
				{
					datos2 = new JPanel();
					datos2.setBackground(Color.WHITE);
					panel.add(datos2);
					datos2.setLayout(new GridLayout(3, 2, 0, 0));
					{
						claseEconómica = new JPanel();
						datos2.add(claseEconómica);
						claseEconómica.setBackground(Color.WHITE);
						{
							radClaseEconmica = new JRadioButton("Clase Econ\u00F3mica");
							radClaseEconmica.setSelected(true);
							radClaseEconmica.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
							claseEconómica.add(radClaseEconmica);
							radClaseEconmica.setBackground(Color.WHITE);
							grupoClase.add(radClaseEconmica);
						}
					}
					{
						claseEjecutiva = new JPanel();
						datos2.add(claseEjecutiva);
						claseEjecutiva.setBackground(Color.WHITE);
						{
							radClaseEjecutiva = new JRadioButton("Clase Ejecutiva");
							radClaseEjecutiva.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
							claseEjecutiva.add(radClaseEjecutiva);
							radClaseEjecutiva.setBackground(Color.WHITE);
							grupoClase.add(radClaseEjecutiva);
						}
					}
					{
						panel_1 = new JPanel();
						panel_1.setBackground(Color.WHITE);
						datos2.add(panel_1);
					}
					{
						panel_7 = new JPanel();
						panel_7.setBackground(Color.WHITE);
						datos2.add(panel_7);
					}
					{
						lblApresurateABuscar = new JLabel("Apresurate a buscar tu vuelo");
						lblApresurateABuscar.setForeground(Color.GRAY);
						lblApresurateABuscar.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
						lblApresurateABuscar.setHorizontalAlignment(SwingConstants.CENTER);
						datos2.add(lblApresurateABuscar);
					}
					{
						btnBuscarVuelos = new JButton("Buscar Vuelos");
						btnBuscarVuelos.addActionListener(this);
						
						btnBuscarVuelos.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
						btnBuscarVuelos.setBackground(Color.RED);
						datos2.add(btnBuscarVuelos);
					}
				}
			}
			{
				frase = new JPanel();
				frase.setBackground(Color.WHITE);
				pestañas.add(frase);
				frase.setLayout(new GridLayout(0, 1, 0, 0));
				{
					panel_21 = new JPanel();
					panel_21.setBackground(Color.WHITE);
					frase.add(panel_21);
					panel_21.setLayout(new GridLayout(1, 2, 0, 0));
					{
						panel_23 = new JPanel();
						panel_23.setBackground(Color.WHITE);
						panel_21.add(panel_23);
						panel_23.setLayout(new GridLayout(2, 2, 0, 0));
						{
							panel_25 = new JPanel();
							panel_25.setBorder(new EmptyBorder(0, 0, 0, 20));
							panel_25.setBackground(Color.WHITE);
							panel_23.add(panel_25);
							panel_25.setLayout(new GridLayout(0, 1, 0, 0));
							{
								lblCliente = new JLabel(miCliente.getNombre());
								lblCliente.setHorizontalAlignment(SwingConstants.RIGHT);
								lblCliente.setIcon(new ImageIcon(VentanaBusqueda.class.getResource("/imagenes/icono-usuario.png")));
								panel_25.add(lblCliente);
							}
						}
					}
				}
				{
					lblNewLabel_2 = new JLabel("\"Vive nuevas experiencias\"");
					lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
					lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
					lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
					frase.add(lblNewLabel_2);
				}
				{
					lblNewLabel_1 = new JLabel("Caribe Airlines");
					lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
					lblNewLabel_1.setFont(new Font("Brush Script MT", Font.BOLD, 36));
					lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
					frase.add(lblNewLabel_1);
				}
				{
					panel_22 = new JPanel();
					panel_22.setBackground(Color.WHITE);
					frase.add(panel_22);
				}
			}
		}
		{
			espacio = new JPanel();
			espacio.setBackground(Color.WHITE);
			contentPane.add(espacio);
		}
	}
	
	/**
	 * Parte inferior
	 */
	public void constInferior ()
	{
	}
	private String clase;
	private String origen;
	private String destino;
	private String modalidad;
	private int cantAdultos;
	private int cantNiños;
	private String  fechaaIda;
	private String fechaaRegreso;
	private ArrayList<Vuelo> vueloEncontrado;
	private JDateChooser fechaIdaDate;
	private JDateChooser fechaRegresoDate;
	
	/**
	 * Método que permite rellenar un combo box
	 * @param seleccionEnCombo1
	 */
	private void rellenaCombo2(String seleccionEnCombo1) {
		boxDestino.removeAllItems();
		
		if (seleccionEnCombo1.equals("M\u00E9xico (Ciudad de M\u00E9xico)")) {
			boxDestino.addItem("M\u00E9xico (Monterrey)");
			boxDestino.addItem("M\u00E9xico (Canc\u00FAn)");
			boxDestino.addItem("Argentina (Buenos Aires)");
			boxDestino.addItem("Estados Unidos (Los \u00C1ngeles)");
			boxDestino.addItem("Colombia (Bogot\u00E1)");
			boxDestino.addItem("Republica de Panam\u00E1 (Panam\u00E1)");
		} else {
			boxDestino.addItem("M\u00E9xico (Ciudad de M\u00E9xico)");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(boxOrigen.getSelectedItem().toString().equals("M\u00E9xico (Ciudad de M\u00E9xico)"))
		{
			origen = "México (Ciudad de méxico)";
		} else if(boxOrigen.getSelectedItem().toString().equals("M\u00E9xico (Monterrey)"))
		{
			origen = "México (Monterrey)";
		}else if(boxOrigen.getSelectedItem().toString().equals("Argentina (Buenos Aires)"))
		{
			origen = "Argentina (Buenos Aires)";
		}else if(boxOrigen.getSelectedItem().toString().equals("Estados Unidos (Los \u00C1ngeles)"))
		{
			origen = "Estados Unidos (Los Ángeles)";
		}else if(boxOrigen.getSelectedItem().toString().equals("Colombia (Bogot\u00E1)"))
		{
			origen = "Colombia (Bogotá)";
		}else if(boxOrigen.getSelectedItem().toString().equals("Republica de Panam\u00E1 (Panam\u00E1)")) {
			origen = "Republica de Panamá (Panamá)";
		}
		
		
		
		if(boxDestino.getSelectedItem().toString().equals("M\u00E9xico (Ciudad de M\u00E9xico)"))
		{
			destino = "México (Ciudad de méxico)";
		} else if(boxDestino.getSelectedItem().toString().equals("M\u00E9xico (Monterrey)"))
		{
			destino = "México (Monterrey)";
		}else if(boxDestino.getSelectedItem().toString().equals("Argentina (Buenos Aires)"))
		{
			destino= "Argentina (Buenos Aires)";
		}else if(boxDestino.getSelectedItem().toString().equals("Estados Unidos (Los \u00C1ngeles)"))
		{
			destino = "Estados Unidos (Los Ángeles)";
		}else if(boxDestino.getSelectedItem().toString().equals("Colombia (Bogot\u00E1)"))
		{
			destino = "Colombia (Bogotá)";
		}else if(boxDestino.getSelectedItem().toString().equals("Republica de Panam\u00E1 (Panam\u00E1)")) {
			destino = "Republica de Panamá (Panamá)";
		}else if(boxDestino.getSelectedItem().toString().equals("M\u00E9xico (Canc\u00FAn)"))
		{
			destino = "México (Cancún)";
		}
		
		
		if(radIda.isSelected()==true)
		{
			modalidad = "ida";
			fechaRegresoDate.setVisible(false);
			lblFechaRegreso.setVisible(false);
		}
		else
		{
			fechaRegresoDate.setVisible(true);
			lblFechaRegreso.setVisible(true);
		}
		
		if(radIdaRegreso.isSelected()==true)
		{
			modalidad = "ida y regreso";
		}
		
		 
		int diaIda = fechaIdaDate.getCalendar().get(Calendar.DAY_OF_MONTH);
		int mesIda = fechaIdaDate.getCalendar().get(Calendar.MONTH);
		int añoIda = fechaIdaDate.getCalendar().get(Calendar.YEAR);
		
		fechaaIda = diaIda + "/" + mesIda + "/" + añoIda;
		
		int diaRegreso = fechaRegresoDate.getCalendar().get(Calendar.DAY_OF_MONTH);
		int mesRegreso = fechaRegresoDate.getCalendar().get(Calendar.MONTH);
		int añoRegreso = fechaRegresoDate.getCalendar().get(Calendar.YEAR);
		
		fechaaRegreso = diaRegreso +  "/" + mesRegreso + "/" + añoRegreso;
		
		 cantAdultos = Integer.parseInt(comboBox.getSelectedItem().toString());
		cantNiños = Integer.parseInt(comboBox_1.getSelectedItem().toString());
		
		if(radClaseEconmica.isSelected())
		{
			clase = "economica";
		}
		if(radClaseEjecutiva.isSelected())
		{
			clase = "ejecutiva";
		}
		
		Trayecto trayectoBuscar = new Trayecto(origen, destino);
		if(e.getSource() == btnBuscarVuelos)
		{
			
			vueloEncontrado = miVentanaPrincipal.buscarVuelo(trayectoBuscar, fechaaIda);
			VentanaResultadosBusqueda miVentanaResul = new VentanaResultadosBusqueda(miVentanaPrincipal, this, miCliente);
			miVentanaResul.setVisible(true);
			this.dispose();
			
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
