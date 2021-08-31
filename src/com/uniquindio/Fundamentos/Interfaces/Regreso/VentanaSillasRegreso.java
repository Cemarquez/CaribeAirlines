package com.uniquindio.Fundamentos.Interfaces.Regreso;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.uniquindio.Fundamentos.Interfaces.VentanaPrincipal;
import com.uniquindio.Fundamentos.Interfaces.Paneles.ImagenAvionRegreso;
import com.uniquindio.Fundamentos.Interfaces.Reservas.VentanaReservas;
import com.uniquindio.Fundamentos.Mundo.Cliente;
import com.uniquindio.Fundamentos.Mundo.Pasajero;
import com.uniquindio.Fundamentos.Mundo.Vuelo;



@SuppressWarnings("serial")
public class VentanaSillasRegreso extends JFrame implements ActionListener{

	private JPanel contentPane = new JPanel();
	private ImagenAvionRegreso imagenAvion;
	private VentanaPrincipal miVentanaPrincipal;
	private int cantPasajeros;
	private Vuelo vueloSeleccionado;

	public VentanaSillasRegreso(VentanaPrincipal miVentanaPrincipal, VentanaResultadosBusquedaRegreso miVentanaResultadosBusquedaRegreso, Cliente miCliente, Vuelo miVuelo) {
		this.miVentanaPrincipal = miVentanaPrincipal;
		vueloSeleccionado = miVuelo;
		cantPasajeros = miVentanaResultadosBusquedaRegreso.getCantPasajeros();
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaReservas.class.getResource("/imagenes/plane.png")));
		ArrayList<Pasajero> pasajeros = miVentanaResultadosBusquedaRegreso.getPasajeros();
		setTitle( "El Avión" );
		setSize( 485, 720 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
     
		 setLayout( new BorderLayout( ) );
		
	imagenAvion = new ImagenAvionRegreso(vueloSeleccionado, cantPasajeros, miCliente, this.miVentanaPrincipal, pasajeros);
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
