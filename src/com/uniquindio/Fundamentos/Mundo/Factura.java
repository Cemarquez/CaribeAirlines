package com.uniquindio.Fundamentos.Mundo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que representa a una factura dentro de la aerolinea.
 * @author Cesar Marquez -  Brian Giraldo
 *
 */
@SuppressWarnings("serial")
public class Factura implements Serializable {
	//Atributos de la clase.
private Cliente cliente;
private Tarjeta tarjeta;
private Tiquete tiquete;
private ArrayList<Pasajero> pasajeros;
private int precioTotal;
private Date fecha;
private int numeroFactura;

/**
 * Constructor que permite crear una nueva factura.
 * @param cliente El par�metro cliente representa al cliente con el que fue hecha la compra.
 * @param tarjeta El par�metro tarjeta representa a la tarjeta con la que fue hecha la compra.
 * @param tiquete El par�metro tiquete representa al tiquete de la compra.
 * @param pasajeros El par�metro pasajeros representa a la lista de pasajeros de la compra.
 * @param precioTotal El par�metro precioTotal representa al precio total de la compra.
 * @param fecha El par�metro fecha representa a la fecha en la que fue hecha la compra.
 */
public Factura(Cliente cliente, Tarjeta tarjeta, Tiquete tiquete, ArrayList<Pasajero> pasajeros, int precioTotal, Date fecha, int numeroFactura) {
	super();
	this.cliente = cliente;
	this.tarjeta = tarjeta;
	this.tiquete = tiquete;
	this.pasajeros = pasajeros;
	this.precioTotal = precioTotal;
	this.fecha = fecha;
	this.numeroFactura = numeroFactura;
}

/**
 * M�todo que devuelve el cliente con el que fue hecha la compra.
 * @return Retorna el cliente con el que fue hecha la compra.
 */
public Cliente getCliente() {
	return cliente;
}

/**
 * M�todo que devuelve la tarjeta con la que fue hecha la compra.
 * @return Retorna la tarjeta con la que fue hecha la compra.
 */
public Tarjeta getTarjeta() {
	return tarjeta;
}

/**
 * M�todo que devuelve el tiquete de la compra.
 * @return Retorna el tiquete de la compra.
 */
public Tiquete getTiquete() {
	return tiquete;
}

/**
 * M�todo que devuelve la lista de pasajeros de la compra.
 * @return Retorna la lista de pasajeros de la compra.
 */
public ArrayList<Pasajero> getPasajeros() {
	return pasajeros;
}

/**
 * M�todo que devuelve el precio total de la compra.
 * @return Retorna el precio total de la compra.
 */
public int getPrecioTotal() {
	return precioTotal;
}
/**
 * Devuelve el n�mero de la factura
 * @return
 */
public int getNumeroFactura()
{
	return numeroFactura;
}

/**
 * Devuelve la fecha de creaci�n
 * @return 
 */
public Date getFecha()
{
	return fecha;
}
}
