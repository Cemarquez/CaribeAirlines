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
 * @param pasajeros El parámetro pasajeros representa a la lista de pasajeros que contiene el tiquete.
 * @param cliente El parámetro cliente contiene al cliente que compró el tiquete.
 * @param sillas El parámetro sillas representa a las sillas compradas por el cliente.
 * @param fecha El parámetro fecha representa la fecha en la cual se hará el viaje
 * @param vuelo El parámetro vuelo representa el vuelo que se realizará.
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
 * Método que devuelve la lista de pasajeros contenida en el tiquete.
 * @return Retorna la lista de pasajeros contenida en el tiquete.
 */
public ArrayList<Pasajero> getPasajeros() {
	return pasajeros;
}

/**
 * Método que devuelve el cliente que realizó la compra.
 * @return Retorna el cliente que realizó la compra.
 */
public Cliente getCliente() {
	return cliente;
}

/**
 * Método que devuelve la lista de sillas contenida en el tiquete.
 * @return Retorna la lista de sillas contenida en el tiquete.
 */
public ArrayList<Silla> getSillas() {
	return sillas;
}

/**
 * Método que devuelve la fecha en que se realizará el viaje.
 * @return Retorna la fecha en que se realizará el viaje.
 */
public Date getFecha() {
	return fecha;
}

/**
 * Método que devuelve el vuelo contenido en el tiquete.
 * @return Retorna el vuelo contenido en el tiquete.
 */
public Vuelo getVuelo() {
	return vuelo;
}





}
