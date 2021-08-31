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
 * @param vuelo El par�metro vuelo representa al vuelo seleccionado por el pasajero.
 * @param pasajero El par�metro pasajero representa al pasajero que ser� registrado.
 * @param silla El par�metro silla representa a la silla que ser� registrada al registro
 */
public RegistroVueloPorPasajero(Vuelo vuelo, Pasajero pasajero, Silla silla) {
	super();
	this.vuelo = vuelo;
	this.pasajero = pasajero;
	this.silla = silla;
}

/**
 * M�todo que devuelve el vuelo seleccionado por el pasajero.
 * @return Retorna el vuelo seleccionado por el pasajero.
 */
public Vuelo getVuelo() {
	return vuelo;
}

/**
 * M�todo que devuelve el pasajero que est� en el registro.
 * @return Retorna el pasajero que est� en el registro.
 */
public Pasajero getPasajero() {
	return pasajero;
}

/**
 * M�todo que retorna la silla que est� en el registro.
 * @return Retorna la silla que est� en el registro.
 */
public Silla getSilla() {
	return silla;
}

}
