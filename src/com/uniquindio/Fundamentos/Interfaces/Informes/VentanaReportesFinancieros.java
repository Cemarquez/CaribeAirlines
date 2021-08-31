package com.uniquindio.Fundamentos.Interfaces.Informes;
	
	import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.uniquindio.Fundamentos.Interfaces.VentanaFuncionesAdmin;
import com.uniquindio.Fundamentos.Interfaces.VentanaFuncionesCliente;
import com.uniquindio.Fundamentos.Interfaces.VentanaPrincipal;
import com.uniquindio.Fundamentos.Interfaces.Reservas.VentanaReservas;
import com.uniquindio.Fundamentos.Mundo.Trayecto;
	
	@SuppressWarnings("serial")
	public class VentanaReportesFinancieros extends JFrame implements ActionListener
	{
		
	private JPanel contentPane, baner, panelMedio, panelInferior;
	
	private JLabel label;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JLabel label_1;
	private JPanel panel_10;
	private JLabel lblReportes;
	private JPanel panel_11;
	private JButton botonRegistros1;
	private VentanaPrincipal miVentanaPrincipal;
	private JComboBox<String> comboBoxOrigen;
	private JLabel lblNewLabel;
	private JComboBox<String> comboBoxDestino;
	private JLabel lblDestino;
	private JPanel panel_2;
	private JPanel panel_8;
	private JPanel panel_9;
	private JRadioButton rdbtnVuelosRealizados;
	private JRadioButton rdbtnPasajerosDeLa;
	private JRadioButton rdbtnOtros;
	private JPanel panel_12;
	ButtonGroup gruposReportes = new ButtonGroup();
	private JPanel panel_13;
	private JLabel lblCedulaDelPasajero;
	private JButton btnBuscar;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel lblMes;
	private JButton botonRegistros2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel panel_14;
	private JPanel panel_15;
	private JPanel panel_16;
	private VentanaFuncionesAdmin miV;
	private JButton btnVolver;
	private JComboBox<String> comboBox;
	/**
	 * Launch the application.
	 */
	
	public VentanaReportesFinancieros(VentanaPrincipal miVentanaPrincipal, VentanaFuncionesAdmin miV) {
		this.miV = miV;
		this.miVentanaPrincipal = miVentanaPrincipal;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaReservas.class.getResource("/imagenes/plane.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 700);
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
			}
			{
				panel_3 = new JPanel();
				panel.add(panel_3);
				panel_3.setBackground(Color.WHITE);
				panel_3.setLayout(new GridLayout(0, 1, 0, 0));
			}
			{
				panel_10 = new JPanel();
				panel.add(panel_10);
				panel_10.setBackground(Color.WHITE);
				panel_10.setLayout(new GridLayout(0, 1, 0, 0));
				{
					lblReportes = new JLabel("Reportes Financieros");
					lblReportes.setHorizontalAlignment(SwingConstants.CENTER);
					lblReportes.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
					panel_10.add(lblReportes);
				}
				{
					label_1 = new JLabel("");
					panel_10.add(label_1);
					label_1.setHorizontalAlignment(SwingConstants.CENTER);
					label_1.setIcon(new ImageIcon(VentanaReportesFinancieros.class.getResource("/imagenes/icons8-monedas-filled-50.png")));
				}
			}
		}
		
	}
	
	public void constPanelInferior()
	{
		{
			panel_9 = new JPanel();
			panel_9.setBackground(Color.WHITE);
			contentPane.add(panel_9);
			panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));
			{
				rdbtnVuelosRealizados = new JRadioButton("Vuelos Realizados");
				rdbtnVuelosRealizados.setFont(new Font("Tahoma", Font.PLAIN, 16));
				rdbtnVuelosRealizados.setSelected(true);
				rdbtnVuelosRealizados.setBackground(Color.WHITE);
				gruposReportes.add(rdbtnVuelosRealizados);
				rdbtnVuelosRealizados.addActionListener(this);
				panel_9.add(rdbtnVuelosRealizados);
			}
			{
				rdbtnPasajerosDeLa = new JRadioButton("Pasajeros de la Aerolinea");
				rdbtnPasajerosDeLa.setFont(new Font("Tahoma", Font.PLAIN, 16));
				rdbtnPasajerosDeLa.setBackground(Color.WHITE);
				rdbtnPasajerosDeLa.addActionListener(this);
				{
					label_2 = new JLabel("               ");
					panel_9.add(label_2);
				}
				gruposReportes.add(rdbtnPasajerosDeLa);
				panel_9.add(rdbtnPasajerosDeLa);
			}
			{
				rdbtnOtros = new JRadioButton("Otros");
				rdbtnOtros.setFont(new Font("Tahoma", Font.PLAIN, 16));
				rdbtnOtros.setBackground(Color.WHITE);
				rdbtnOtros.addActionListener(this);
				{
					label_3 = new JLabel("               ");
					panel_9.add(label_3);
				}
				gruposReportes.add(rdbtnOtros);
				panel_9.add(rdbtnOtros);
			}
		}
		{
			panel_12 = new JPanel();
			panel_12.setBackground(Color.WHITE);
			contentPane.add(panel_12);
			panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.X_AXIS));
			{
				lblNewLabel_2 = new JLabel("                ");
				panel_12.add(lblNewLabel_2);
			}
		}
		panelInferior = new JPanel();
		panelInferior.setBackground(Color.WHITE);
		contentPane.add(panelInferior);
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.Y_AXIS));
		{
			panel_1 = new JPanel();
			panel_1.setEnabled(false);
			panel_1.setVisible(false);
			panelInferior.add(panel_1);
			panel_1.setBackground(Color.WHITE);
			panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
			{
				panel_5 = new JPanel();
				panel_5.setBackground(Color.WHITE);
				panel_1.add(panel_5);
				{
					lblNewLabel = new JLabel("Origen: ");
					lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
					panel_5.add(lblNewLabel);
				}
				{
					comboBoxOrigen = new JComboBox<String>();
					comboBoxOrigen.setFont(new Font("Tahoma", Font.PLAIN, 11));
					panel_5.add(comboBoxOrigen);
					comboBoxOrigen.setBackground(Color.WHITE);
					comboBoxOrigen.addActionListener(this);
					comboBoxOrigen.setModel(new DefaultComboBoxModel<String>(new String[] {"M\u00E9xico (Ciudad de M\u00E9xico)", "M\u00E9xico (Monterrey)", "M\u00E9xico (Canc\u00FAn)", "Argentina (Buenos Aires)", "Estados Unidos (Los \u00C1ngeles)", "Colombia (Bogot\u00E1)", "Republica de Panam\u00E1 (Panam\u00E1)"}));
					comboBoxOrigen.setMaximumRowCount(6);
					comboBoxOrigen.addActionListener(this); 
				}
			}
			{
				panel_4 = new JPanel();
				panel_4.setBackground(Color.WHITE);
				panel_1.add(panel_4);
				{
					lblDestino = new JLabel("Destino: ");
					lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 11));
					panel_4.add(lblDestino);
				}
				{
					comboBoxDestino = new JComboBox<String>();
					comboBoxDestino.setAlignmentX(Component.LEFT_ALIGNMENT);
					comboBoxDestino.setFont(new Font("Tahoma", Font.PLAIN, 11));
					panel_4.add(comboBoxDestino);
					comboBoxDestino.setBackground(Color.WHITE);
					comboBoxDestino.setModel(new DefaultComboBoxModel<String>(new String[] {"M\u00E9xico (Monterrey)", "M\u00E9xico (Canc\u00FAn)", "Argentina (Buenos Aires)", "Estados Unidos (Los \u00C1ngeles)", "Colombia (Bogot\u00E1)", "Republica de Panam\u00E1 (Panam\u00E1)"}));
					comboBoxDestino.setMaximumRowCount(6);
				}
			}
			{
				
			}
			{
				panel_11 = new JPanel();
				panel_11.setBackground(Color.WHITE);
				panel_1.add(panel_11);
				{
					botonRegistros1 = new JButton("Ver Registros");
					botonRegistros1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					botonRegistros1.addActionListener(this);
					botonRegistros1.setIcon(new ImageIcon(VentanaReportesVuelo.class.getResource("/imagenes/icons8-reporte-de-negocios-24.png")));
					botonRegistros1.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
					botonRegistros1.setForeground(Color.WHITE);
					botonRegistros1.setBackground(new Color(255, 204, 0));
					panel_11.add(botonRegistros1);
				}
			}
		}
		{
			panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			panelInferior.add(panel_2);
			panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
			{
				panel_13 = new JPanel();
				panel_13.setVisible(false);
				panel_13.setEnabled(false);
				panel_13.setBackground(Color.WHITE);
				panel_2.add(panel_13);
				{
					lblCedulaDelPasajero = new JLabel("Dinero recaudado por kilos adicionales");
					lblCedulaDelPasajero.setFont(new Font("Tahoma", Font.PLAIN, 16));
					panel_13.add(lblCedulaDelPasajero);
				}
				{
					btnBuscar = new JButton("");
					btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnBuscar.setBackground(Color.WHITE);
					btnBuscar.setBorder(null);
					btnBuscar.addActionListener(this);
					btnBuscar.setIcon(new ImageIcon(VentanaReportesVuelo.class.getResource("/imagenes/boton-lupa.png")));
					panel_13.add(btnBuscar);
				}
			}
		}
		{
			panel_8 = new JPanel();
			panel_8.setEnabled(false);
			panel_8.setVisible(false);
			contentPane.add(panel_8);
			panel_8.setBackground(Color.WHITE);
			{
			     {
			     	lblMes = new JLabel("Mes: ");
			     	lblMes.setFont(new Font("Tahoma", Font.PLAIN, 16));
			     	panel_8.add(lblMes);
			     }
			}
			{
				String mes[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
				comboBox = new JComboBox<String>(mes);
				comboBox.setBackground(Color.WHITE);
				panel_8.add(comboBox);
			}
			{
				lblNewLabel_1 = new JLabel("                 ");
				panel_8.add(lblNewLabel_1);
			}
			{
				botonRegistros2 = new JButton("Ver Registros");
				botonRegistros2.setIcon(new ImageIcon(VentanaReportesVuelo.class.getResource("/imagenes/icons8-reporte-de-negocios-24.png")));
				botonRegistros2.setForeground(Color.WHITE);
				botonRegistros2.addActionListener(this);
				botonRegistros2.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
				botonRegistros2.setBackground(new Color(255, 204, 0));
				panel_8.add(botonRegistros2);
			}
		}
		{
			panel_14 = new JPanel();
			panel_14.setBackground(Color.WHITE);
			contentPane.add(panel_14);
		}
		{
			panel_15 = new JPanel();
			panel_15.setBackground(Color.WHITE);
			contentPane.add(panel_15);
			{
				btnVolver = new JButton("Volver");
				btnVolver.setBackground(new Color(255, 204, 0));
				btnVolver.setForeground(Color.WHITE);
				btnVolver.addActionListener(this);
				btnVolver.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
				panel_15.add(btnVolver);
			}
		}
		{
			panel_16 = new JPanel();
			panel_16.setBackground(Color.WHITE);
			contentPane.add(panel_16);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(rdbtnVuelosRealizados.isSelected())
		{
			panel_1.setEnabled(true);
			panel_1.setVisible(true);
			panel_13.setEnabled(false);
			panel_13.setVisible(false);
			panel_8.setEnabled(false);
			panel_8.setVisible(false);
		}
		
		if(rdbtnPasajerosDeLa.isSelected())
		{
			panel_13.setEnabled(true);
			panel_13.setVisible(true);
			panel_1.setEnabled(false);
			panel_1.setVisible(false);
			panel_8.setEnabled(false);
			panel_8.setVisible(false);
		}
		
		if(rdbtnOtros.isSelected())
		{
			panel_8.setEnabled(true);
			panel_8.setVisible(true);
			panel_1.setEnabled(false);
			panel_1.setVisible(false);
			panel_13.setEnabled(false);
			panel_13.setVisible(false);
		}
		
		if(e.getSource() == botonRegistros1)
		{
			String origen="", destino="";
			if(comboBoxOrigen.getSelectedItem().toString().equals("M\u00E9xico (Ciudad de M\u00E9xico)"))
			{
				origen = "México (Ciudad de méxico)";
			} else if(comboBoxOrigen.getSelectedItem().toString().equals("M\u00E9xico (Monterrey)"))
			{
				origen = "México (Monterrey)";
			}else if(comboBoxOrigen.getSelectedItem().toString().equals("Argentina (Buenos Aires)"))
			{
				origen = "Argentina (Buenos Aires)";
			}else if(comboBoxOrigen.getSelectedItem().toString().equals("Estados Unidos (Los \u00C1ngeles)"))
			{
				origen = "Estados Unidos (Los Ángeles)";
			}else if(comboBoxOrigen.getSelectedItem().toString().equals("Colombia (Bogot\u00E1)"))
			{
				origen = "Colombia (Bogotá)";
			}else if(comboBoxOrigen.getSelectedItem().toString().equals("Republica de Panam\u00E1 (Panam\u00E1)")) {
				origen = "Republica de Panamá (Panamá)";
			}
			
			
			if(comboBoxDestino.getSelectedItem().toString().equals("M\u00E9xico (Ciudad de M\u00E9xico)"))
			{
				destino = "México (Ciudad de méxico)";
			} else if(comboBoxDestino.getSelectedItem().toString().equals("M\u00E9xico (Monterrey)"))
			{
				destino = "México (Monterrey)";
			}else if(comboBoxDestino.getSelectedItem().toString().equals("Argentina (Buenos Aires)"))
			{
				destino= "Argentina (Buenos Aires)";
			}else if(comboBoxDestino.getSelectedItem().toString().equals("Estados Unidos (Los \u00C1ngeles)"))
			{
				destino = "Estados Unidos (Los Ángeles)";
			}else if(comboBoxDestino.getSelectedItem().toString().equals("Colombia (Bogot\u00E1)"))
			{
				destino = "Colombia (Bogotá)";
			}else if(comboBoxDestino.getSelectedItem().toString().equals("Republica de Panam\u00E1 (Panam\u00E1)")) {
				destino = "Republica de Panamá (Panamá)";
			}else if(comboBoxDestino.getSelectedItem().toString().equals("M\u00E9xico (Canc\u00FAn)"))
			{
				destino = "México (Cancún)";
			}
			Trayecto trayecto = new Trayecto(origen, destino);
			JOptionPane.showMessageDialog(null, "La cantidad dinero de pasajes asociados al trayecto " + origen + " - " + destino + " es: " + miVentanaPrincipal.cantPagosRealizadosTrayecto(trayecto));
	
		}
		
		if(e.getSource() == btnVolver)
		{
			
			miV.setVisible(true);
			this.dispose();
		}
		if(e.getSource() == botonRegistros2)
		{
			int mes = Integer.parseInt(comboBox.getSelectedItem().toString());
			int dinero = miVentanaPrincipal.dineroRecaudadoMes(mes);
			JOptionPane.showMessageDialog(null, "El dinero recaudado en el mes seleccionado es " + dinero + "$");
		}
		if(e.getSource() == btnBuscar)
		{
			
				JOptionPane.showMessageDialog(null, "El total de dinero recaudado por kilos adicionales en bodega es: " +miVentanaPrincipal.dineroRecaudadoKilosAdiciones() + "$");
	    }
	}
}