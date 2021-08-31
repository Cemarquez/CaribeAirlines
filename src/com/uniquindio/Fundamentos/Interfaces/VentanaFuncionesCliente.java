package com.uniquindio.Fundamentos.Interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.uniquindio.Fundamentos.Interfaces.Reservas.VentanaReservas;
import com.uniquindio.Fundamentos.Mundo.Cliente;
@SuppressWarnings("serial")
public class VentanaFuncionesCliente extends JFrame implements ActionListener {

	private JPanel contentPane, baner, panelMedio, panelInferior;
	
	private Cliente miCliente;
	private JLabel label;
	private JMenuBar menuBar;
	private JMenuItem mntmGestionar;
	private JMenu mnPerfil;
	private JMenuItem mntmCerrar;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_3;
	private JButton btnBuscar;
	private JButton btnFacturas;
	private JPanel panel_2;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_8;
	private JPanel panel_9;
	private JLabel label_1;
	private JPanel panel_10;
	private JLabel lblNombre;
	private JLabel lblIdentidad;
	private JLabel lblCorreo;
	private JPanel panel_7;
	private JPanel panel_15;
	private JPanel panel_11;
	private JButton botonReservas;
private VentanaPrincipal miVentanaPrincipal;
	/**
	 * Launch the application.
	 */
	
	public VentanaFuncionesCliente(VentanaPrincipal miVentanaPrincipal, Cliente miCliente) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	
		this.miCliente = miCliente;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaReservas.class.getResource("/imagenes/plane.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		constPanelSuperior();
		constPanelMedio();
		constPanelInferior();
setResizable(false);
setLocationRelativeTo(null);		
	}
	
	public void constPanelSuperior()
	{
		baner = new JPanel();
		baner.setBackground(Color.WHITE);
		contentPane.add(baner);
		baner.setLayout(new BoxLayout(baner, BoxLayout.X_AXIS));
		{
			label = new JLabel("");
			label.setIcon(new ImageIcon(VentanaFuncionesCliente.class.getResource("/imagenes/Baner.jpg")));
			baner.add(label);
		}
	}

	public void constPanelMedio()
	{
		panelMedio = new JPanel();
		panelMedio.setBackground(Color.WHITE);
		contentPane.add(panelMedio);
		panelMedio.setLayout(new GridLayout(0, 1, 0, 0));
		{
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panelMedio.add(panel);
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			{
				panel_6 = new JPanel();
				panel_6.setBackground(Color.WHITE);
				panel.add(panel_6);
				panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
				{
					menuBar = new JMenuBar();
					menuBar.setBackground(new Color(204, 255, 255));
					panel_6.add(menuBar);
					{
						mnPerfil = new JMenu(miCliente.getNombre());
						mnPerfil.setBackground(new Color(204, 255, 255));
						mnPerfil.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
						menuBar.add(mnPerfil);
						{
							mntmGestionar = new JMenuItem("Gestionar Cuenta");
							mntmGestionar.setBackground(new Color(204, 255, 255));
							mntmGestionar.addActionListener(this);
							mntmGestionar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
							mnPerfil.add(mntmGestionar);
						}
						{
							mntmCerrar = new JMenuItem("Cerrar Sesi\u00F3n");
							mntmCerrar.setBackground(new Color(204, 255, 255));
							mntmCerrar.addActionListener(this);
							mntmCerrar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
							mnPerfil.add(mntmCerrar);
						}
					}
					{
						panel_7 = new JPanel();
						panel_7.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
						panel_7.setBackground(new Color(204, 255, 255));
						menuBar.add(panel_7);
					}
				}
			}
			{
				panel_15 = new JPanel();
				panel_15.setBackground(Color.WHITE);
				panel.add(panel_15);
			}
			{
				panel_9 = new JPanel();
				panel_9.setBackground(Color.WHITE);
				panel.add(panel_9);
			}
			{
				panel_8 = new JPanel();
				panel_8.setBackground(Color.WHITE);
				panel.add(panel_8);
			}
			{
				panel_3 = new JPanel();
				panel.add(panel_3);
				panel_3.setBackground(Color.WHITE);
				panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
				{
					label_1 = new JLabel("");
					label_1.setHorizontalAlignment(SwingConstants.CENTER);
					label_1.setIcon(new ImageIcon(VentanaFuncionesCliente.class.getResource("/imagenes/icono-usuariogrande.png")));
					panel_3.add(label_1);
				}
				{
					panel_10 = new JPanel();
					panel_10.setBackground(Color.WHITE);
					panel_3.add(panel_10);
					panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.Y_AXIS));
					{
						lblNombre = new JLabel(miCliente.getNombre()+" "+miCliente.getApellido());
						lblNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
						panel_10.add(lblNombre);
					}
					{
						lblIdentidad = new JLabel(miCliente.getCedula());
						lblIdentidad.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
						panel_10.add(lblIdentidad);
					}
					{
						lblCorreo = new JLabel(miCliente.getCorreo());
						lblCorreo.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
						panel_10.add(lblCorreo);
					}
				}
			}
		}
		
	}
	
	public void constPanelInferior()
	{
		panelInferior = new JPanel();
		panelInferior.setBackground(Color.WHITE);
		contentPane.add(panelInferior);
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.Y_AXIS));
		{
			panel_2 = new JPanel();
			panelInferior.add(panel_2);
			panel_2.setBackground(Color.WHITE);
		}
		{
			panel_1 = new JPanel();
			panelInferior.add(panel_1);
			panel_1.setBackground(Color.WHITE);
			panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
			{
				panel_5 = new JPanel();
				panel_5.setBackground(Color.WHITE);
				panel_1.add(panel_5);
				{
					btnBuscar = new JButton("Buscar Vuelos");
					btnBuscar.addActionListener(this);
					panel_5.add(btnBuscar);
					btnBuscar.setIcon(new ImageIcon(VentanaFuncionesCliente.class.getResource("/imagenes/plane.png")));
					btnBuscar.setForeground(Color.WHITE);
					btnBuscar.setBackground(new Color(255, 204, 0));
					btnBuscar.setFont(new Font("Bookman Old Style", Font.BOLD, 24));
				}
			}
			{
				panel_4 = new JPanel();
				panel_4.setBackground(Color.WHITE);
				panel_1.add(panel_4);
				{
					btnFacturas = new JButton("Mis Facturas");
					btnFacturas.addActionListener(this);
					btnFacturas.setIcon(new ImageIcon(VentanaFuncionesCliente.class.getResource("/imagenes/iconFactura.png")));
					panel_4.add(btnFacturas);
					btnFacturas.setForeground(Color.WHITE);
					btnFacturas.setBackground(new Color(255, 204, 0));
					btnFacturas.setFont(new Font("Bookman Old Style", Font.BOLD, 24));
				}
			}
			{
				panel_11 = new JPanel();
				panel_11.setBackground(Color.WHITE);
				panel_1.add(panel_11);
				{
					botonReservas = new JButton("Reservas");
					botonReservas.addActionListener(this);
					botonReservas.setIcon(new ImageIcon(VentanaFuncionesCliente.class.getResource("/imagenes/iconReserva.png")));
					botonReservas.setFont(new Font("Bookman Old Style", Font.BOLD, 24));
					botonReservas.setForeground(Color.WHITE);
					botonReservas.setBackground(new Color(255, 204, 0));
					panel_11.add(botonReservas);
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnBuscar)
		{
			VentanaBusqueda miVentanaBusqueda = new VentanaBusqueda(miVentanaPrincipal, miCliente);
			miVentanaBusqueda.setVisible(true);
			dispose();
		}
		
		if(e.getSource() == btnFacturas)
		{
			VentanaFacturas miVentanaFacturas = new VentanaFacturas(miVentanaPrincipal, miCliente, this);
			miVentanaFacturas.setVisible(true);
			dispose();
		}
		
		if(e.getSource() == mntmGestionar)
		{
			VentanaGestionarCuenta miVentanaGestionar = new VentanaGestionarCuenta(miVentanaPrincipal, miCliente, this);
			miVentanaGestionar.setVisible(true);
			dispose();
		}
		
		if(e.getSource() == mntmCerrar)
		{
			miVentanaPrincipal.setVisible(true);
			dispose();
		}
		
		if(e.getSource() == botonReservas)
		{
			VentanaReservas miVR = new VentanaReservas(miCliente, miVentanaPrincipal);
			miVR.setVisible(true);
			this.dispose();
		}
	}
}