package com.uniquindio.Fundamentos.Interfaces;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;

import com.uniquindio.Fundamentos.Interfaces.Reservas.VentanaReservas;
import com.uniquindio.Fundamentos.MailSender.MailSender;
import com.uniquindio.Fundamentos.Miscelanea.GeneradorPDF;
import com.uniquindio.Fundamentos.Mundo.Aerolinea;
import com.uniquindio.Fundamentos.Mundo.Cliente;
import com.uniquindio.Fundamentos.Mundo.Consolidado;
import com.uniquindio.Fundamentos.Mundo.Factura;
import com.uniquindio.Fundamentos.Mundo.Pasajero;
import com.uniquindio.Fundamentos.Mundo.RegistroVueloPorPasajero;
import com.uniquindio.Fundamentos.Mundo.Reserva;
import com.uniquindio.Fundamentos.Mundo.Tiquete;
import com.uniquindio.Fundamentos.Mundo.Trayecto;
import com.uniquindio.Fundamentos.Mundo.Vuelo;
import com.uniquindio.Fundamentos.Serializacion.Persistencia;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame implements ActionListener
{
	private GeneradorPDF generadorPDF = new GeneradorPDF();
	private Persistencia serializar = new Persistencia();
	private JPanel contentPane, pestañas, espacio, frase, nuestraCompañia,  panel_3, panel_4, panel_5, 
				   panel_6, panel_8, panel_9, panel_10, panel_2, panel_11, panel_12, panel_13, panel_14, panel_15, panel_16, panel_17;
	private JTabbedPane tabVentanas;
	private JLabel  label, lblNewLabel_1, lblNewLabel_2, lblMision, lblVision, lblValores, lblCaracteristicas;              
	private VentanaLogin miVentanaLogin;
	private JTextPane txtpnConectamosAlMundo, txtpnConLaMejor, txtpnBrindamosSeguridad, txtpnCaribeAirlinesEs;
	private Aerolinea aerolinea;
	private ArrayList<Cliente> misClientes;
	private VentanaPrincipal miVentanaPrincipal = this;
	private JButton btnInicio;
	private JPanel panel_21;
	private JPanel panel_22;
	private JPanel panel_23;
	private JPanel panel_24;
	private JLabel lblNewLabel_3;
	private JPanel panel_25;
	private JLabel lblNewLabel_4;
	private JPanel Seleccion;
	private JPanel panel_1;
	private JPanel panel_7;
	private JLabel lblIniciaSesinO;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_5;
	private JPanel panel_18;
	private JPanel panel_19;
	private JLabel label_1;
	private JPanel panel_20;
	private JPanel panel_26;
	private Trayecto[] trayectos;

	public VentanaPrincipal(Aerolinea aerolinea) 
	{
		this.aerolinea = aerolinea;
		misClientes = aerolinea.getMisClientes();
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaReservas.class.getResource("/imagenes/plane.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		this.trayectos = aerolinea.getTrayectos();
		constBaner();
		constMedio();
		constInferior();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public String disco() {
    	String dp = System.getProperty("user.home");
    	dp = dp.substring(0, 1);
    	dp = dp + ":" + '/';
    	return dp;
    }
	
	public void constBaner ()
	{
		label = new JLabel("");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setIcon(new ImageIcon(VentanaBusqueda.class.getResource("/imagenes/Baner.jpg")));
		contentPane.add(label);

	}
	
	public void constMedio ()
	{
		{
			pestañas = new JPanel();
			pestañas.setBackground(Color.WHITE);
			contentPane.add(pestañas);
			pestañas.setLayout(new GridLayout(0, 2, 0, 0));
			tabVentanas = new JTabbedPane(JTabbedPane.TOP);
			tabVentanas.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
			pestañas.add(tabVentanas);
			tabVentanas.setBackground(Color.WHITE);
			{
				Seleccion = new JPanel();
				Seleccion.setBackground(Color.WHITE);
				tabVentanas.addTab("Selecciona tu viaje", null, Seleccion, null);
				Seleccion.setLayout(new BoxLayout(Seleccion, BoxLayout.Y_AXIS));
				{
					panel_26 = new JPanel();
					panel_26.setBackground(Color.WHITE);
					Seleccion.add(panel_26);
				}
				{
					panel_18 = new JPanel();
					panel_18.setBackground(Color.WHITE);
					Seleccion.add(panel_18);
					panel_18.setLayout(new BoxLayout(panel_18, BoxLayout.X_AXIS));
					{
						label_1 = new JLabel("Caribe Airlines");
						label_1.setVerticalAlignment(SwingConstants.TOP);
						label_1.setHorizontalAlignment(SwingConstants.CENTER);
						label_1.setFont(new Font("Brush Script MT", Font.BOLD, 36));
						panel_18.add(label_1);
					}
				}
				{
					panel_20 = new JPanel();
					panel_20.setBackground(Color.WHITE);
					Seleccion.add(panel_20);
				}
				{
					panel_1 = new JPanel();
					panel_1.setBackground(Color.WHITE);
					Seleccion.add(panel_1);
					panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
					{
						lblIniciaSesinO = new JLabel("Inicia Sesi\u00F3n o Registrate");
						lblIniciaSesinO.setFont(new Font("Bookman Old Style", Font.PLAIN, 28));
						lblIniciaSesinO.setVerticalAlignment(SwingConstants.BOTTOM);
						panel_1.add(lblIniciaSesinO);
						lblIniciaSesinO.setHorizontalAlignment(SwingConstants.CENTER);
					}
				}
				{
					panel_7 = new JPanel();
					panel_7.setBackground(Color.WHITE);
					Seleccion.add(panel_7);
					panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));
					{
						lblNewLabel = new JLabel("para acceder a la compra");
						lblNewLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 28));
						lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
						panel_7.add(lblNewLabel);
					}
				}
				{
					panel = new JPanel();
					panel.setBackground(Color.WHITE);
					Seleccion.add(panel);
					panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
					{
						lblNewLabel_5 = new JLabel("de tu viaje");
						lblNewLabel_5.setFont(new Font("Bookman Old Style", Font.PLAIN, 28));
						lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
						panel.add(lblNewLabel_5);
					}
				}
				{
					panel_19 = new JPanel();
					panel_19.setBackground(Color.WHITE);
					Seleccion.add(panel_19);
				}
			}
			{
				nuestraCompañia = new JPanel();
				nuestraCompañia.setBackground(Color.WHITE);
				tabVentanas.addTab("Nuestra Compa\u00F1\u00EDa", null, nuestraCompañia, null);
				nuestraCompañia.setLayout(new BoxLayout(nuestraCompañia, BoxLayout.Y_AXIS));
				{
					panel_17 = new JPanel();
					panel_17.setBackground(Color.WHITE);
					nuestraCompañia.add(panel_17);
				}
				{
					panel_16 = new JPanel();
					panel_16.setBackground(Color.WHITE);
					nuestraCompañia.add(panel_16);
				}
				{
					panel_5 = new JPanel();
					panel_5.setBackground(Color.WHITE);
					nuestraCompañia.add(panel_5);
					panel_5.setLayout(new GridLayout(1, 3, 0, 0));
					{
						panel_2 = new JPanel();
						panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
						panel_2.setBackground(new Color(0, 0, 255));
						panel_5.add(panel_2);
						{
							lblMision = new JLabel("Misi\u00F3n");
							lblMision.setForeground(new Color(255, 255, 255));
							panel_2.add(lblMision);
							lblMision.setBackground(new Color(186, 85, 211));
							lblMision.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
							lblMision.setVerticalAlignment(SwingConstants.BOTTOM);
							lblMision.setHorizontalAlignment(SwingConstants.CENTER);
						}
					}
					{
						panel_11 = new JPanel();
						panel_11.setBorder(new LineBorder(new Color(0, 0, 0)));
						panel_11.setBackground(new Color(255, 0, 255));
						panel_5.add(panel_11);
						{
							lblVision = new JLabel("Visi\u00F3n");
							lblVision.setForeground(new Color(255, 255, 255));
							panel_11.add(lblVision);
							lblVision.setBackground(new Color(255, 0, 0));
							lblVision.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
							lblVision.setVerticalAlignment(SwingConstants.BOTTOM);
							lblVision.setHorizontalAlignment(SwingConstants.CENTER);
						}
					}
					{
						panel_12 = new JPanel();
						panel_12.setBorder(new LineBorder(new Color(0, 0, 0)));
						panel_12.setBackground(new Color(255, 0, 0));
						panel_5.add(panel_12);
						{
							lblValores = new JLabel("Valores");
							lblValores.setForeground(new Color(255, 255, 255));
							panel_12.add(lblValores);
							lblValores.setBackground(new Color(147, 112, 219));
							lblValores.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
							lblValores.setVerticalAlignment(SwingConstants.BOTTOM);
							lblValores.setHorizontalAlignment(SwingConstants.CENTER);
						}
					}
				}
				{
					panel_3 = new JPanel();
					panel_3.setBackground(Color.WHITE);
					nuestraCompañia.add(panel_3);
					panel_3.setLayout(new GridLayout(1, 3, 0, 0));
					{
						panel_13 = new JPanel();
						panel_13.setBorder(new LineBorder(new Color(0, 0, 0)));
						panel_3.add(panel_13);
						panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.X_AXIS));
						{
							txtpnConectamosAlMundo = new JTextPane();
							panel_13.add(txtpnConectamosAlMundo);
							txtpnConectamosAlMundo.setForeground(new Color(0, 0, 128));
							txtpnConectamosAlMundo.setBackground(new Color(250, 235, 215));
							txtpnConectamosAlMundo.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
							txtpnConectamosAlMundo.setEditable(false);
							txtpnConectamosAlMundo.setText("\r\nConectamos al mundo, buscando dar siempre m\u00E1s y el mejor servicio.");
						}
					}
					{
						panel_14 = new JPanel();
						panel_14.setBorder(new LineBorder(new Color(0, 0, 0)));
						panel_3.add(panel_14);
						panel_14.setLayout(new BoxLayout(panel_14, BoxLayout.X_AXIS));
						{
							txtpnConLaMejor = new JTextPane();
							panel_14.add(txtpnConLaMejor);
							txtpnConLaMejor.setForeground(new Color(186, 85, 211));
							txtpnConLaMejor.setBackground(new Color(250, 235, 215));
							txtpnConLaMejor.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
							txtpnConLaMejor.setText("\r\nCon la mejor gente y tecnolog\u00EDa para una experiencia excepcional, seremos la aerol\u00EDnea m\u00E1s preferida en el mundo. \r\n");
							txtpnConLaMejor.setEditable(false);
						}
					}
					{
						panel_15 = new JPanel();
						panel_15.setBorder(new LineBorder(new Color(0, 0, 0)));
						panel_3.add(panel_15);
						panel_15.setLayout(new BoxLayout(panel_15, BoxLayout.X_AXIS));
						{
							txtpnBrindamosSeguridad = new JTextPane();
							panel_15.add(txtpnBrindamosSeguridad);
							txtpnBrindamosSeguridad.setForeground(new Color(139, 0, 0));
							txtpnBrindamosSeguridad.setBackground(new Color(250, 235, 215));
							txtpnBrindamosSeguridad.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
							txtpnBrindamosSeguridad.setText("\r\n*Brindamos seguridad.\r\n*Servimos con pasi\u00F3n.\r\n*Dsifrutamos haciendolo.\r\n*Trabajamos con empe\u00F1o.");
							txtpnBrindamosSeguridad.setEditable(false);
						}
					}
				}
				{
					panel_4 = new JPanel();
					panel_4.setBackground(Color.WHITE);
					nuestraCompañia.add(panel_4);
					panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
					{
						panel_6 = new JPanel();
						panel_6.setBackground(Color.WHITE);
						panel_4.add(panel_6);
						{
							lblCaracteristicas = new JLabel("Caracteristicas");
							lblCaracteristicas.setFont(new Font("Brush Script MT", Font.PLAIN, 24));
							panel_6.add(lblCaracteristicas);
						}
					}
					{
						panel_8 = new JPanel();
						panel_4.add(panel_8);
						panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));
						{
							panel_10 = new JPanel();
							panel_10.setBackground(Color.WHITE);
							panel_8.add(panel_10);
						}
						{
							txtpnCaribeAirlinesEs = new JTextPane();
							txtpnCaribeAirlinesEs.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
							panel_8.add(txtpnCaribeAirlinesEs);
							txtpnCaribeAirlinesEs.setEditable(false);
							txtpnCaribeAirlinesEs.setText("Caribe Airlines es la aerol\u00EDnea nacional e internacional de la Ciudad de M\u00E9xico, su aeropuerto principal es el Aeropuerto Internacional Benito Ju\u00E1rez, en honor a Benito Ju\u00E1rez y abreviado AICM, es un aeropuerto comercial que sirve a la Zona metropolitana. La empresa opera a destinos nacionales como Monterrey, Canc\u00FAn; e internacionales como Buenos Aires\u2013Argentina, Los \u00C1ngeles\u2013Estados Unidos, Bogot\u00E1-Colombia, Panam\u00E1-Rep\u00FAblica de Panam\u00E1. La aerol\u00EDnea comenz\u00F3 sus operaciones el 4 de octubre de 2018.");
						}
						{
							panel_9 = new JPanel();
							panel_9.setBackground(Color.WHITE);
							panel_8.add(panel_9);
						}
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
						panel_24 = new JPanel();
						panel_24.setBackground(Color.WHITE);
						panel_21.add(panel_24);
					}
					{
						panel_23 = new JPanel();
						panel_23.setBackground(Color.WHITE);
						panel_21.add(panel_23);
						panel_23.setLayout(new GridLayout(2, 2, 0, 0));
						{
							btnInicio = new JButton("Iniciar Sesi\u00F3n");
							btnInicio.addActionListener(this);
							btnInicio.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
							panel_23.add(btnInicio);
							btnInicio.setForeground(new Color(128, 0, 0));
							btnInicio.setBackground(Color.WHITE);
						}
						{
							panel_25 = new JPanel();
							panel_25.setBackground(Color.WHITE);
							panel_23.add(panel_25);
							panel_25.setLayout(new GridLayout(0, 1, 0, 0));
							{
								lblNewLabel_3 = new JLabel("Si a\u00FAn no haces parte, que esperas");
								lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
								lblNewLabel_3.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
								lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
								panel_25.add(lblNewLabel_3);
							}
							{
								lblNewLabel_4 = new JLabel("\u00A1REGISTRATE!");
								lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
								lblNewLabel_4.setForeground(Color.RED);
								lblNewLabel_4.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
								lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
								panel_25.add(lblNewLabel_4);
								lblNewLabel_4.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent arg0) {
										VentanaRegistrar miVR = new VentanaRegistrar(miVentanaPrincipal);
										miVR.setVisible(true);
										miVentanaPrincipal.dispose();
									}
								});
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
	
	public void constInferior ()
	{
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnInicio)
		{
			miVentanaLogin = new VentanaLogin(miVentanaPrincipal, aerolinea);
			miVentanaLogin.setVisible(true);
			miVentanaPrincipal.dispose();
		}
	}
	public boolean correoRegistrado(String correo)
	{
		Cliente miC;
		boolean isRepetido = false;
		for (int i = 0; i < misClientes.size()&&isRepetido==false; i++) {
	        miC = misClientes.get(i);
	        if(correo.equals(miC.getCorreo()))
	        {
	        	isRepetido = true;
	        }
	        }
		
		return isRepetido;
	}
	public void añadirFacturaAerolinea(Factura factura)
	{
		aerolinea.añadirFacturaAerolinea(factura);
	}
	public void añadirKilos(int kilos) {
		aerolinea.añadirKilos(kilos);
	}
	public void añadirTiquete(Tiquete pTiquete)
	{
		aerolinea.añadirTiquete(pTiquete);
	}
	public void añadirConsolidado(Consolidado pConsolidado)
	{
	aerolinea.añadirConsolidado(pConsolidado);
	}
	public void AñadirReservaAerolinea(Reserva pReserva)
	{
		aerolinea.AñadirReservaAerolinea(pReserva);
	}
	public void añadirRegistroPorPasajero(RegistroVueloPorPasajero pRegistro)
	{
		aerolinea.añadirRegistroPorPasajero(pRegistro);
	}
	public void agregarCliente (Cliente pCliente)
	{
		aerolinea.agregarCliente(pCliente);
	}
	public Vuelo obtenerVueloSeleccionado(Vuelo pVuelo, String horaSalida)
	{
	       return aerolinea.getVueloSeleccionado(pVuelo, horaSalida);
	}
	
	public ArrayList<Vuelo> buscarVuelo(Trayecto trayecto, String fecha)
	{
		return aerolinea.buscarVuelo(trayecto, fecha);
	}
	
	public void serializar()
	{
		serializar.serializar(aerolinea);
	}
	public Aerolinea deserializar()
	{
		return serializar.deserializar();
	}
	public int getNumeroFactura()
	{
		return aerolinea.getNumeroFactura();
	}
	
	public void setNumeroFactura(int numero)
	{
		aerolinea.setNumeroFactura(numero);
	}
	
	public void generarFacturaPDF(Factura factura, int precioBoletos, int precioEquipaje, int kilosAdicionales)
	{
		generadorPDF.crearPDF(factura, precioBoletos, precioEquipaje, kilosAdicionales);
	}
	
	public void mailSender()
	{
		aerolinea.mailSender();
	}
	
	public void enviarCorreoBienvenida(String destinatario, String datos) 
	{
		aerolinea.enviarCorreoBienvenida(destinatario, datos);
	}
	
	public void enviarCorreoCompra(String remitente, String ruta, String nombreFile)
	{
		aerolinea.enviarCorreoCompra(remitente, ruta, nombreFile);
	}
	
	public void setMail(MailSender mail)
	{
		aerolinea.setMail(mail);
	}
	/**
	 * Método que permite obtener la lista de trayectos de la aerolinea.
	 * @return
	 */
	public Trayecto[] getTrayectos() {
		return trayectos;
	}
	public int cantPagosRealizadosTrayecto (Trayecto trayecto)
	{
		return aerolinea.cantPagosRealizadosTrayecto(trayecto);
	}
	public int cantPasajerosTrayecto(Trayecto trayecto)
	{
		return aerolinea.cantPasajerosTrayecto(trayecto);
	}
	public Pasajero pasajeroCedula(String cedula)
	{
		return aerolinea.pasajeroCedula(cedula);
	}
	
	public boolean PasajeroExist(String cedula)
	{
		return aerolinea.PasajeroExist(cedula);
	}
	public ArrayList<Vuelo> vuelosRealizados(Pasajero pasajero)
	{
		return aerolinea.vuelosRealizados(pasajero);
	}
	public String[] destinoAlQueMasViajan(String fecha)
	{
		return aerolinea.destinoAlQueMasViajan(fecha);
	}
	public int dineroRecaudadoKilosAdiciones()
	{
		return aerolinea.dineroRecaudadoKilosAdiciones();
	}
	public int dineroRecaudadoMes (int mes)
	{
		return aerolinea.dineroRecaudadoMes(mes);
	}
		
}
