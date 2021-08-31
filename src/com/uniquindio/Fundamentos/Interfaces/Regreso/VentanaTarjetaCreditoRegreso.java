package com.uniquindio.Fundamentos.Interfaces.Regreso;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import com.uniquindio.Fundamentos.Interfaces.VentanaFuncionesCliente;
import com.uniquindio.Fundamentos.Interfaces.VentanaPrincipal;
import com.uniquindio.Fundamentos.Interfaces.Reservas.VentanaReservas;
import com.uniquindio.Fundamentos.MailSender.MailSender;
import com.uniquindio.Fundamentos.Mundo.Avion;
import com.uniquindio.Fundamentos.Mundo.Cliente;
import com.uniquindio.Fundamentos.Mundo.Consolidado;
import com.uniquindio.Fundamentos.Mundo.Factura;
import com.uniquindio.Fundamentos.Mundo.Pasajero;
import com.uniquindio.Fundamentos.Mundo.Silla;
import com.uniquindio.Fundamentos.Mundo.Tarjeta;
import com.uniquindio.Fundamentos.Mundo.Tiquete;
import com.uniquindio.Fundamentos.Mundo.Vuelo;
import com.uniquindio.Fundamentos.Util.Util;

@SuppressWarnings("serial")
public class VentanaTarjetaCreditoRegreso extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldNumTarjeta;
	private JTextField textFieldCodigo;
	private JButton btnSalir;
	private JButton btnPagar;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaPagoRegreso miVentanaPago;
	private JMonthChooser monthChooser;
	private Cliente miCliente;
	private JYearChooser yearChooser;

	public VentanaTarjetaCreditoRegreso(VentanaPrincipal miVentanaPrincipal, VentanaPagoRegreso miVentanaPago, Cliente miCliente) {
		this.miCliente = miCliente;
		this.miVentanaPago = miVentanaPago;
		this.miVentanaPrincipal = miVentanaPrincipal;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 348);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaReservas.class.getResource("/imagenes/plane.png")));
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		btnPagar = new JButton("Pagar");
		btnPagar.setBackground(Color.YELLOW);
		btnPagar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPagar.addActionListener(this);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.YELLOW);
		btnSalir.addActionListener(this);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(109)
					.addComponent(btnSalir)
					.addPreferredGap(ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
					.addComponent(btnPagar)
					.addGap(100))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPagar)
						.addComponent(btnSalir))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 222, 173));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaTarjetaCreditoRegreso.class.getResource("/imagenes/none.png")));
		
		JLabel lblTitularDeLa = new JLabel("TARJETA DE CR\u00C9DITO:");
		lblTitularDeLa.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(8)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblTitularDeLa)
					.addContainerGap(230, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(22)
					.addComponent(lblTitularDeLa))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 48, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblImporteAPagar = new JLabel("Importe a pagar:");
		
		JLabel lblNmeroDeTarjeta = new JLabel("N\u00FAmero de tarjeta:");
		
		JLabel lblFechaDeCaducidad = new JLabel("Fecha de caducidad:");
		
		JLabel lblCwcvc = new JLabel("CW2/CVC2");
		
		JLabel lblTotal = new JLabel(miVentanaPago.getPrecioTotal() + "");
		lblTotal.setForeground(Color.GRAY);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textFieldNumTarjeta = new JTextField();
		textFieldNumTarjeta.setColumns(10);
		
	  monthChooser = new JMonthChooser();
		
		yearChooser = new JYearChooser();
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblImporteAPagar)
					.addGap(83)
					.addComponent(lblTotal)
					.addContainerGap(219, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNmeroDeTarjeta)
						.addComponent(lblFechaDeCaducidad)
						.addComponent(lblCwcvc))
					.addGap(50)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(monthChooser, 0, 0, Short.MAX_VALUE)
								.addComponent(textFieldNumTarjeta))
							.addGap(18)
							.addComponent(yearChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(130, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblImporteAPagar)
								.addComponent(lblTotal))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNmeroDeTarjeta)
								.addComponent(textFieldNumTarjeta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblFechaDeCaducidad)
								.addComponent(monthChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(yearChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCwcvc)
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		setResizable(false);
		setLocationRelativeTo(null);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSalir)
		{
			miVentanaPrincipal.setVisible(true);
			this.dispose();
		}
		if(e.getSource() == btnPagar)
		{
			int numeroFactura = miVentanaPrincipal.getNumeroFactura();
			
				numeroFactura = sumar1(numeroFactura);
			Vuelo vuelo = miVentanaPago.getVueloSeleccionado();
			miVentanaPrincipal.setNumeroFactura(numeroFactura);
			VentanaFuncionesCliente miVFC = new VentanaFuncionesCliente(miVentanaPrincipal, miCliente);
			ArrayList<Pasajero> pasajeros = miVentanaPago.getPasajeros();
			ArrayList<Silla> sillas = miVentanaPago.getSillas();
			Date fecha = new Date();
			int dinero = miVentanaPago.getPrecioTotal();
			Consolidado pConsolidado = new Consolidado(dinero, fecha, miVentanaPago.getVueloSeleccionado());
			Cliente cliente = miVentanaPago.getMiCliente();
			String numeroTarjeta = textFieldNumTarjeta.getText();
			String codigo = textFieldCodigo.getText();
			int mes = monthChooser.getMonth();
			int año = yearChooser.getYear();
			String fechaVencimiento = mes + "/" + año;
			Tiquete pTiquete = new Tiquete(pasajeros, cliente, sillas, fecha, miVentanaPago.getVueloSeleccionado());
			Tarjeta tarjeta = new Tarjeta(fechaVencimiento, numeroTarjeta, codigo);
			Factura factura = new Factura(cliente, tarjeta, pTiquete, pasajeros, dinero, fecha, numeroFactura);
		    cliente.agregarFactura(factura);
		    miVentanaPrincipal.generarFacturaPDF(factura, miVentanaPago.getPrecioBoletos(), miVentanaPago.getPrecioEquipaje(), miVentanaPago.getKilos());
		    Avion avion = miVentanaPago.getVueloSeleccionado().getAvion();
		    avion.quitarPeso(miVentanaPago.getKilos());
		    miVentanaPrincipal.añadirKilos(miVentanaPago.getKilos());
		   miVentanaPrincipal.añadirFacturaAerolinea(factura);
			miVentanaPrincipal.añadirConsolidado(pConsolidado);
			miVentanaPrincipal.añadirTiquete(pTiquete);
			String ruta = Util.disco() + "CaribeAirlines/Facturas/Factura_" + miCliente.getNombre() +"_" + factura.getNumeroFactura() +  ".pdf";
			String nombreFile = "Factura_" + miCliente.getNombre() +"_" + factura.getNumeroFactura() +  ".pdf";
			MailSender mail = new MailSender();
			miVentanaPrincipal.setMail(mail);
			miVentanaPrincipal.enviarCorreoCompra(miCliente.getCorreo(), ruta, nombreFile);
			vuelo.setRealizado(true);
		    miVentanaPrincipal.serializar();
			miVFC.setVisible(true);
			this.dispose();
			
		}
		
		
		
	}

	public int sumar1(int numero)
	{
		return numero + 1;
	}
}
