package com.uniquindio.Fundamentos.Mundo;

import java.io.Serializable;

/**
 * Clase que representa a una tarjeta de cr�dito.
 * @author Cesar Marquez - Brian Giraldo
 *
 */
@SuppressWarnings("serial")
public class Tarjeta implements Serializable {
private String fechaVencimiento;
private String numero;
private String codigo;

/**
 * Constructor que permite crear una nueva tarjeta de cr�dito.
 * @param fechaVencimiento El par�metro fechaVecimiento representa la fecha de vencimiento de la tarjeta de cr�dito.
 * @param numero El par�metro numero representa el n�mero de la tarjeta de cr�dito.
 * @param codigo El par�metro codigo representa el c�digo CVC de la tarjeta de cr�dito.
 */
public Tarjeta(String fechaVencimiento, String numero, String codigo) {
	super();
	this.fechaVencimiento = fechaVencimiento;
	this.numero = numero;
	this.codigo = codigo;
}

/**
 * M�todo que devuelve la fecha de vencimiento de la tarjeta de cr�dito.
 * @return Retorna la fecha de vencimiento de la tarjeta de cr�dito.
 */
public String getFechaVencimiento() {
	return fechaVencimiento;
}

/**
 * M�todo que devuelve el n�mero de la tarjeta de cr�dito.
 * @return Retorna el n�mero de la tarjeta de cr�dito.
 */
public String getNumero() {
	return numero;
}

/**
 * M�todo que devuelde el c�digo CVC de la tarjeta de cr�dito.
 * @return Retorna el c�digo CVC de la tarjeta de cr�dito.
 */
public String getCodigo() {
	return codigo;
}


}
