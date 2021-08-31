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

import com.uniquindio.Fundamentos.Interfaces.Informes.VentanaListaTrayectos;
import com.uniquindio.Fundamentos.Interfaces.Informes.VentanaReportesFinancieros;
import com.uniquindio.Fundamentos.Interfaces.Informes.VentanaReportesVuelo;
import com.uniquindio.Fundamentos.Interfaces.Reservas.VentanaReservas;


@SuppressWarnings("serial")
public class VentanaFuncionesAdmin extends JFrame implements ActionListener {

	private JPanel contentPane, baner, panelMedio, panelInferior;
	
	private JLabel label;
	private JMenuBar menuBar;
	private JMenuItem mntmAgregar;
	private JMenu mnPerfil;
	private JMenuItem mntmCerrar;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_3;
	private JButton btnVuelos;
	private JButton btnFinanciero;
	private JPanel panel_2;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JLabel label_1;
	private JPanel panel_10;
	private JLabel lblReportes;
	private JPanel panel_7;
	private JPanel panel_15;
private VentanaPrincipal miVentanaPrincipal;

private JMenuItem mntmAgregarTripulantes;
	/**
	 * Launch the application.
	 */
	
	public VentanaFuncionesAdmin(VentanaPrincipal miVentanaPrincipal) {
		
		this.miVentanaPrincipal = miVentanaPrincipal;
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
						mnPerfil = new JMenu("Administrador");
						mnPerfil.setBackground(new Color(204, 255, 255));
						mnPerfil.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
						menuBar.add(mnPerfil);
						{
							mntmAgregar = new JMenuItem("Agregar o Modificar Vuelos");
							mntmAgregar.setBackground(new Color(204, 255, 255));
							mntmAgregar.addActionListener(this);
							mntmAgregar.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
							mnPerfil.add(mntmAgregar);
						}
						{
							mntmAgregarTripulantes = new JMenuItem("Asignar o Modificar Tripulantes");
							mntmAgregarTripulantes.setBackground(new Color(204, 255, 255));
							mntmAgregarTripulantes.addActionListener(this);
							mntmAgregarTripulantes.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
							mnPerfil.add(mntmAgregarTripulantes);
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
				panel_3 = new JPanel();
				panel.add(panel_3);
				panel_3.setBackground(Color.WHITE);
				panel_3.setLayout(new GridLayout(0, 1, 0, 0));
				{
					label_1 = new JLabel("");
					label_1.setHorizontalAlignment(SwingConstants.CENTER);
					label_1.setIcon(new ImageIcon(VentanaFuncionesAdmin.class.getResource("/imagenes/icons8-hombre-de-negocios-80.png")));
					panel_3.add(label_1);
				}
			}
			{
				panel_10 = new JPanel();
				panel.add(panel_10);
				panel_10.setBackground(Color.WHITE);
				panel_10.setLayout(new GridLayout(0, 1, 0, 0));
				{
					lblReportes = new JLabel("Reportes de la Aerolinea");
					lblReportes.setHorizontalAlignment(SwingConstants.CENTER);
					lblReportes.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
					panel_10.add(lblReportes);
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
					btnVuelos = new JButton("Vuelos");
					btnVuelos.addActionListener(this);
					panel_5.add(btnVuelos);
					btnVuelos.setIcon(new ImageIcon(VentanaFuncionesAdmin.class.getResource("/imagenes/icons8-despegue-filled-50.png")));
					btnVuelos.setForeground(Color.WHITE);
					btnVuelos.setBackground(new Color(255, 204, 0));
					btnVuelos.setFont(new Font("Bookman Old Style", Font.BOLD, 24));
				}
			}
			{
				panel_4 = new JPanel();
				panel_4.setBackground(Color.WHITE);
				panel_1.add(panel_4);
				{
					btnFinanciero = new JButton("Financieros");
					btnFinanciero.addActionListener(this);
					btnFinanciero.setIcon(new ImageIcon(VentanaFuncionesAdmin.class.getResource("/imagenes/icons8-monedas-filled-50.png")));
					panel_4.add(btnFinanciero);
					btnFinanciero.setForeground(Color.WHITE);
					btnFinanciero.setBackground(new Color(255, 204, 0));
					btnFinanciero.setFont(new Font("Bookman Old Style", Font.BOLD, 24));
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnVuelos)
		{
			VentanaReportesVuelo miVRV = new VentanaReportesVuelo(miVentanaPrincipal);
			miVRV.setVisible(true);
			dispose();
		}
		
		if(e.getSource() == btnFinanciero)
		{
			VentanaReportesFinancieros miVRF= new VentanaReportesFinancieros(miVentanaPrincipal, this);
			miVRF.setVisible(true);
			dispose();
		}
		
		if(e.getSource() == mntmAgregar)
		{
			dispose();
		}
		
		if(e.getSource() == mntmAgregarTripulantes)
		{
			VentanaListaTrayectos miVLT = new VentanaListaTrayectos(miVentanaPrincipal, this);
			miVLT.setVisible(true);
			dispose();
		}
		
		if(e.getSource() == mntmCerrar)
		{
			miVentanaPrincipal.setVisible(true);
			dispose();
		}
	}
}