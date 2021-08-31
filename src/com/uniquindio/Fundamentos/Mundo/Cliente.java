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
private String contrase�a;
private String cedula;
private String fechaNacimiento;
private ArrayList<Pasajero> pasajeros=new ArrayList<Pasajero>();
private ArrayList<Factura> facturas= new ArrayList<Factura>();
private ArrayList<Reserva> reservas=new ArrayList<Reserva>();

/**
 * Constructor que permite crear un nuevo cliente en la aerolinea.
 * @param nombre El par�metro nombre representa al nombre del cliente.
 * @param apellido El par�metro apellido representa al apellido del cliente.
 * @param correo El par�metro correo representa al correo electr�nico del cliente.
 * @param direccion El par�metro direccion representa a la direcci�n de domicilio del cliente.
 * @param contrase�a El par�metro contrase�a representa a la contrase�a con la cual el cliente deber� ingresar en la ventana de inicio de sesi�n.
 * @param cedula El par�metro cedula representa a la c�dula del cliente.
 * @param fechaNacimiento El par�metro fechaNacimiento representa a la fecha de nacimiento del cliente.
 */
public Cliente(String nombre, String apellido, String correo, String direccion, String contrase�a, String cedula,
		String fechaNacimiento) {
	super();
	this.nombre = nombre;
	this.apellido = apellido;
	this.correo = correo;
	this.direccion = direccion;
	this.contrase�a = contrase�a;
	this.fechaNacimiento = fechaNacimiento;
	this.cedula = cedula;
}

/**
 * M�todo que permite actualizar los datos del cliente en la ventana de gesti�n.
 * @param nombre El par�metro nombre representa al nombre del cliente.
 * @param apellido El par�metro apellido representa al apellido del cliente.
 * @param correo El par�metro correo representa al correo electr�nico del cliente.
 * @param direccion El par�metro direccion representa a la direcci�n de domicilio del cliente.
 * @param contrase�a El par�metro contrase�a representa a la contrase�a con la cual el cliente deber� ingresar en la ventana de inicio de sesi�n.
 * @param cedula El par�metro cedula representa a la c�dula del cliente.
 * @param fechaNacimiento El par�metro fechaNacimiento representa a la fecha de nacimiento del cliente.
 */
public void actualizarDatos (String nombre, String apellido, String correo, String direccion, String contrase�a, String cedula,
		String fechaNacimiento)
{
	this.nombre = nombre;
	this.apellido = apellido;
	this.correo = correo;
	this.direccion = direccion;
	this.contrase�a = contrase�a;
	this.fechaNacimiento = fechaNacimiento;
	this.cedula = cedula;
}

/**
 * M�todo que devuelve la c�dula del cliente.
 * @return Retorna la c�dula del cliente.
 */
public String getCedula() {
	return cedula;
}

/**
 * M�todo que devuelve el nombre del cliente.
 * @return Retorna el nombre del cliente.
 */
public String getNombre() {
	return nombre;
}

/**
 * M�todo que devuelve el apellido del cliente.
 * @return Retorna el apellido del cliente.
 */
public String getApellido() {
	return apellido;
}

/**
 * M�todo que devuelve el correo electr�nico del cliente.
 * @return Retorna el correo electr�nico del cliente.
 */
public String getCorreo() {
	return correo;
}

/**
 * M�todo que devuelve la direcci�n de domicilio del cliente.
 * @return Retorna la direcci�n de domicilio del cliente.
 */
public String getDireccion() {
	return direccion;
}

/**
 * M�todo que devuelve la contrase�a del cliente.
 * @return Retorna la contrase�a del cliente.
 */
public String getContrase�a() {
	return contrase�a;
}

/**
 * M�todo que devuelve la fecha de nacimiento del cliente.
 * @return Retorna la fecha de nacimiento del cliente.
 */
public String getFechaNacimiento() {
	return fechaNacimiento;
}

/**
 * M�todo que devuelve el ArrayList de pasajeros que han sido registrados al cliente.
 * @return Retorna el ArrayList de pasajeros que han sido registrados al cliente.
 */
public ArrayList<Pasajero> getPasajeros() {
	return pasajeros;
}

/**
 * M�todo que devuelve el ArrayList de las facturas de las compras que el cliente ha hecho.
 * @return Retorna el ArrayList de las facturas de las compras que el cliente ha hecho.
 */
public ArrayList<Factura> getFacturas() {
	return facturas;
}

/**
 * M�todo que devuelve el ArrayList de reservas hechas por el cliente.
 * @return Retorna el ArrayList de reservas hechas por el cliente.
 */
public ArrayList<Reserva> getReservas() {
	return reservas;
}

/**
 * M�todo que permite agregar un pasajero definidio por el usuario al listado de pasajeros.
 * @param pPasajero El par�metro pPasajero representa al pasajero que ser� a�adido a la lista del cliente.
 */
public void agregarPasajero(Pasajero pPasajero)
{
		pasajeros.add(pPasajero);
}

/**
 * M�todo que permite a�adir una factura al listado de facturas del cliente.
 * @param pFactura El par�metro pFactura representa a la factura que ser� a�adida a la lista.
 */
public void agregarFactura(Factura pFactura)
{
	facturas.add(pFactura);
}

/**
 * Mpetodo que permite a�adir una reserva al listado de reservas del cliente.
 * @param pReserva El par�metro pReserva representa a la reserva que ser� a�adida a la lista.
 */
public void agregarReservaAlCliente(Reserva pReserva)
{
	reservas.add(pReserva);
}

/**
 * M�todo que permite borrar una reserva del ArrayList de reservas.
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
