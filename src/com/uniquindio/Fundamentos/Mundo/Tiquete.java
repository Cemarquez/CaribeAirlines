package com.uniquindio.Fundamentos.Mundo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que representa un tiquete de vuelo.
 * @author Cesar Marquez - Brian Giraldo
 *
 */
@SuppressWarnings("serial")
public class Tiquete implements Serializable{
	
private ArrayList<Pasajero> pasajeros;
private Cliente cliente;
private ArrayList<Silla> sillas;
private Date fecha;
private Vuelo vuelo;

/**
 * Constructor que permite crear un nuevo tiquete;
 * @param pasajeros El par�metro pasajeros representa a la lista de pasajeros que contiene el tiquete.
 * @param cliente El par�metro cliente contiene al cliente que compr� el tiquete.
 * @param sillas El par�metro sillas representa a las sillas compradas por el cliente.
 * @param fecha El par�metro fecha representa la fecha en la cual se har� el viaje
 * @param vuelo El par�metro vuelo representa el vuelo que se realizar�.
 */
public Tiquete(ArrayList<Pasajero> pasajeros, Cliente cliente, ArrayList<Silla> sillas, Date fecha, Vuelo vuelo) {
	super();
	this.pasajeros = pasajeros;
	this.cliente = cliente;
	this.sillas = sillas;
	this.fecha = fecha;
	this.vuelo = vuelo;
}

/**
 * M�todo que devuelve la lista de pasajeros contenida en el tiquete.
 * @return Retorna la lista de pasajeros contenida en el tiquete.
 */
public ArrayList<Pasajero> getPasajeros() {
	return pasajeros;
}

/**
 * M�todo que devuelve el cliente que realiz� la compra.
 * @return Retorna el cliente que realiz� la compra.
 */
public Cliente getCliente() {
	return cliente;
}

/**
 * M�todo que devuelve la lista de sillas contenida en el tiquete.
 * @return Retorna la lista de sillas contenida en el tiquete.
 */
public ArrayList<Silla> getSillas() {
	return sillas;
}

/**
 * M�todo que devuelve la fecha en que se realizar� el viaje.
 * @return Retorna la fecha en que se realizar� el viaje.
 */
public Date getFecha() {
	return fecha;
}

/**
 * M�todo que devuelve el vuelo contenido en el tiquete.
 * @return Retorna el vuelo contenido en el tiquete.
 */
public Vuelo getVuelo() {
	return vuelo;
}





}
