package com.uniquindio.Fundamentos.Mundo;

import java.io.Serializable;

/**
 * Clase que representa a un registro de pasajero (Vuelo, pasajero y silla) en la aerolinea.
 * @author Cesar Marquez - Brian Giraldo
 *
 */
@SuppressWarnings("serial")
public class RegistroVueloPorPasajero implements Serializable {
	//Atributos de la clase
private Vuelo vuelo;
private Pasajero pasajero;
private Silla silla;

/**
 * Constructor que permite crear un nuevo registro.
 * @param vuelo El parámetro vuelo representa al vuelo seleccionado por el pasajero.
 * @param pasajero El parámetro pasajero representa al pasajero que será registrado.
 * @param silla El parámetro silla representa a la silla que será registrada al registro
 */
public RegistroVueloPorPasajero(Vuelo vuelo, Pasajero pasajero, Silla silla) {
	super();
	this.vuelo = vuelo;
	this.pasajero = pasajero;
	this.silla = silla;
}

/**
 * Método que devuelve el vuelo seleccionado por el pasajero.
 * @return Retorna el vuelo seleccionado por el pasajero.
 */
public Vuelo getVuelo() {
	return vuelo;
}

/**
 * Método que devuelve el pasajero que está en el registro.
 * @return Retorna el pasajero que está en el registro.
 */
public Pasajero getPasajero() {
	return pasajero;
}

/**
 * Método que retorna la silla que está en el registro.
 * @return Retorna la silla que está en el registro.
 */
public Silla getSilla() {
	return silla;
}

}
