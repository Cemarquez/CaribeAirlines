package com.uniquindio.Fundamentos.Mundo;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Clase que representa a un cliente dentro de la aerolinea.
 * 
 * @author Cesar Marquez - Brian Giraldo
 */
@SuppressWarnings("serial")
public class Cliente implements Serializable{
//Atributos de la clase
private String nombre;
private String apellido;
private String correo;
private String direccion;
private String contraseña;
private String cedula;
private String fechaNacimiento;
private ArrayList<Pasajero> pasajeros=new ArrayList<Pasajero>();
private ArrayList<Factura> facturas= new ArrayList<Factura>();
private ArrayList<Reserva> reservas=new ArrayList<Reserva>();

/**
 * Constructor que permite crear un nuevo cliente en la aerolinea.
 * @param nombre El parámetro nombre representa al nombre del cliente.
 * @param apellido El parámetro apellido representa al apellido del cliente.
 * @param correo El parámetro correo representa al correo electrónico del cliente.
 * @param direccion El parámetro direccion representa a la dirección de domicilio del cliente.
 * @param contraseña El parámetro contraseña representa a la contraseña con la cual el cliente deberá ingresar en la ventana de inicio de sesión.
 * @param cedula El parámetro cedula representa a la cédula del cliente.
 * @param fechaNacimiento El parámetro fechaNacimiento representa a la fecha de nacimiento del cliente.
 */
public Cliente(String nombre, String apellido, String correo, String direccion, String contraseña, String cedula,
		String fechaNacimiento) {
	super();
	this.nombre = nombre;
	this.apellido = apellido;
	this.correo = correo;
	this.direccion = direccion;
	this.contraseña = contraseña;
	this.fechaNacimiento = fechaNacimiento;
	this.cedula = cedula;
}

/**
 * Método que permite actualizar los datos del cliente en la ventana de gestión.
 * @param nombre El parámetro nombre representa al nombre del cliente.
 * @param apellido El parámetro apellido representa al apellido del cliente.
 * @param correo El parámetro correo representa al correo electrónico del cliente.
 * @param direccion El parámetro direccion representa a la dirección de domicilio del cliente.
 * @param contraseña El parámetro contraseña representa a la contraseña con la cual el cliente deberá ingresar en la ventana de inicio de sesión.
 * @param cedula El parámetro cedula representa a la cédula del cliente.
 * @param fechaNacimiento El parámetro fechaNacimiento representa a la fecha de nacimiento del cliente.
 */
public void actualizarDatos (String nombre, String apellido, String correo, String direccion, String contraseña, String cedula,
		String fechaNacimiento)
{
	this.nombre = nombre;
	this.apellido = apellido;
	this.correo = correo;
	this.direccion = direccion;
	this.contraseña = contraseña;
	this.fechaNacimiento = fechaNacimiento;
	this.cedula = cedula;
}

/**
 * Método que devuelve la cédula del cliente.
 * @return Retorna la cédula del cliente.
 */
public String getCedula() {
	return cedula;
}

/**
 * Método que devuelve el nombre del cliente.
 * @return Retorna el nombre del cliente.
 */
public String getNombre() {
	return nombre;
}

/**
 * Método que devuelve el apellido del cliente.
 * @return Retorna el apellido del cliente.
 */
public String getApellido() {
	return apellido;
}

/**
 * Método que devuelve el correo electrónico del cliente.
 * @return Retorna el correo electrónico del cliente.
 */
public String getCorreo() {
	return correo;
}

/**
 * Método que devuelve la dirección de domicilio del cliente.
 * @return Retorna la dirección de domicilio del cliente.
 */
public String getDireccion() {
	return direccion;
}

/**
 * Método que devuelve la contraseña del cliente.
 * @return Retorna la contraseña del cliente.
 */
public String getContraseña() {
	return contraseña;
}

/**
 * Método que devuelve la fecha de nacimiento del cliente.
 * @return Retorna la fecha de nacimiento del cliente.
 */
public String getFechaNacimiento() {
	return fechaNacimiento;
}

/**
 * Método que devuelve el ArrayList de pasajeros que han sido registrados al cliente.
 * @return Retorna el ArrayList de pasajeros que han sido registrados al cliente.
 */
public ArrayList<Pasajero> getPasajeros() {
	return pasajeros;
}

/**
 * Método que devuelve el ArrayList de las facturas de las compras que el cliente ha hecho.
 * @return Retorna el ArrayList de las facturas de las compras que el cliente ha hecho.
 */
public ArrayList<Factura> getFacturas() {
	return facturas;
}

/**
 * Método que devuelve el ArrayList de reservas hechas por el cliente.
 * @return Retorna el ArrayList de reservas hechas por el cliente.
 */
public ArrayList<Reserva> getReservas() {
	return reservas;
}

/**
 * Método que permite agregar un pasajero definidio por el usuario al listado de pasajeros.
 * @param pPasajero El parámetro pPasajero representa al pasajero que será añadido a la lista del cliente.
 */
public void agregarPasajero(Pasajero pPasajero)
{
		pasajeros.add(pPasajero);
}

/**
 * Método que permite añadir una factura al listado de facturas del cliente.
 * @param pFactura El parámetro pFactura representa a la factura que será añadida a la lista.
 */
public void agregarFactura(Factura pFactura)
{
	facturas.add(pFactura);
}

/**
 * Mpetodo que permite añadir una reserva al listado de reservas del cliente.
 * @param pReserva El parámetro pReserva representa a la reserva que será añadida a la lista.
 */
public void agregarReservaAlCliente(Reserva pReserva)
{
	reservas.add(pReserva);
}

/**
 * Método que permite borrar una reserva del ArrayList de reservas.
 * @param reserva
 */
public void borrarReserva(Reserva reserva)
{
	boolean centinela = false;
	String origenActual="", origenLlega = "", destinoActual="", destinoLlega="";
	String idActual="", idLlega="";
	Trayecto trayecto;	
	Trayecto trayectoLlega;
	Pasajero pasajero;
	Pasajero pasajeroLlega;
	Vuelo vuelo;
	String fechaActual;
	String fechaLlega;
	for(int i=0;i<reservas.size() && centinela ==false;i++)
	{
	trayecto = reservas.get(i).getVueloSeleccionado().getTrayecto();	
	trayectoLlega = reserva.getVueloSeleccionado().getTrayecto();
	origenActual = trayecto.getOrigen();
	origenLlega = trayectoLlega.getOrigen();
	destinoActual = trayecto.getDestino();
	destinoLlega = trayectoLlega.getDestino();
	
	pasajero = reservas.get(i).getPasajero();
	pasajeroLlega = reserva.getPasajero();
	idActual = pasajero.getId();
	idLlega = pasajeroLlega.getId();

	vuelo = reservas.get(i).getVueloSeleccionado();
	fechaActual = vuelo.getFecha();
	fechaLlega = reserva.getVueloSeleccionado().getFecha();
	
		if(origenActual.equals(origenLlega) && destinoActual.equals(destinoLlega))
		{
			if(idActual.equals(idLlega))
			{
				if(fechaActual.equals(fechaLlega))
				{
					reservas.remove(i);
					centinela=true;
				}
			}
		}
	}
}

}
