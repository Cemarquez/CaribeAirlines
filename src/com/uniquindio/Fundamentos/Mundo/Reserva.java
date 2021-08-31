package com.uniquindio.Fundamentos.Mundo;

import java.io.Serializable;

/**
 * Clase que representa a una reserva dentro de la aerolinea.
 * @author Cesar Marquez - Brian Giraldo
 *
 */
@SuppressWarnings("serial")
public class Reserva implements Serializable {
private Pasajero pasajero;
private Silla silla;
private Vuelo vueloSeleccionado;
private boolean estaPago;

/**
 * Constructor que permite crear una nueva reserva.
 * @param pasajero El par�metro pasajero representa al pasajero al cual se har� la reserva.
 * @param silla El par�metro silla representa la silla en la que est� sentado el pasajero.
 * @param vueloSeleccionado El par�metro vueloSeleccionado representa el vuelo seleccionado por el pasajero.
 */
public Reserva(Pasajero pasajero, Silla silla, Vuelo vueloSeleccionado) {
	super();
	this.pasajero = pasajero;
	this.silla = silla;
	this.vueloSeleccionado = vueloSeleccionado;
	estaPago = false;
}

/**
 * M�todo que devuelve el pasajero al cual se hizo la reserva.
 * @return Retorna el pasajero al cual se hizo la reserva.
 */
public Pasajero getPasajero() {
	return pasajero;
}

/**
 * M�todo que devuelve la silla donde est� sentado el pasajero.
 * @return Retorna la silla donde est� sentado el pasajero.
 */
public Silla getSilla() {
	return silla;
}

/**
 * M�todo que devuelve el vuelo seleccionado por el pasajero.
 * @return Retorna el vuelo seleccionado por el pasajero.
 */
public Vuelo getVueloSeleccionado() {
	return vueloSeleccionado;
}

/**
 * M�todo que devuelve true si la reserva ya est� paga y false en caso contrario.
 * @return Retorna true si la reserva ya est� paga y false en caso contrario.
 */
public boolean isEstaPago() {
	return estaPago;
}

/**
 * M�todo que permite cambiar el estado de la reserva de no pago a pago.
 * @param estaPago El par�metro estaPago representa al true que tomar� la variable local.
 */
public void setEstaPago(boolean estaPago) {
	this.estaPago = estaPago;
}



}
