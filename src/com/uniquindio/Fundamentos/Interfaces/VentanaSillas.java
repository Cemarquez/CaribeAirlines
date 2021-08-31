package com.uniquindio.Fundamentos.Interfaces;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.uniquindio.Fundamentos.Interfaces.Paneles.ImagenAvion;
import com.uniquindio.Fundamentos.Interfaces.Reservas.VentanaReservas;
import com.uniquindio.Fundamentos.Mundo.Cliente;
import com.uniquindio.Fundamentos.Mundo.Pasajero;
import com.uniquindio.Fundamentos.Mundo.Vuelo;



@SuppressWarnings("serial")
public class VentanaSillas extends JFrame implements ActionListener{

	private JPanel contentPane = new JPanel();
	private ImagenAvion imagenAvion;
	private VentanaLogin miVentanaLogin;
	private VentanaPrincipal miVentanaPrincipal;
	private int cantAdultos;
	private int cantNiños;
	private Cliente miCliente;
	private Vuelo vueloSeleccionado;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VentanaSillas(VentanaPrincipal miVentanaPrincipal, VentanaDatosPasajero miVentanaDatosPasajero, String modalidad,String fechaaRegreso) {
		this.miVentanaPrincipal = miVentanaPrincipal;
		this.miVentanaLogin = miVentanaLogin;
		vueloSeleccionado = miVentanaDatosPasajero.getMiVuelo();
		cantAdultos = miVentanaDatosPasajero.getCantAdultos();
		cantNiños = miVentanaDatosPasajero.getCantNiños();
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaReservas.class.getResource("/imagenes/plane.png")));
		miCliente = miVentanaDatosPasajero.getClienteLogeado();
		ArrayList<Pasajero> pasajeros = miVentanaDatosPasajero.getPasajeros();
		setTitle( "El Avión" );
		setSize( 485, 720 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
     
		 setLayout( new BorderLayout( ) );
		 int pasajerosTotal = cantAdultos + cantNiños;
	imagenAvion = new ImagenAvion(vueloSeleccionado, pasajerosTotal, miCliente, this.miVentanaPrincipal, pasajeros, modalidad, fechaaRegreso);
	 add( imagenAvion, BorderLayout.CENTER);
	 
	 if(imagenAvion.isEnabled() == false)
	 {
		 this.dispose();
	 }
	 setResizable( false );
     setLocationRelativeTo( null );

	}
   

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
