package com.uniquindio.Fundamentos.Mundo;

import java.io.Serializable;

/**
 * Clase que representa a una tarjeta de crédito.
 * @author Cesar Marquez - Brian Giraldo
 *
 */
@SuppressWarnings("serial")
public class Tarjeta implements Serializable {
private String fechaVencimiento;
private String numero;
private String codigo;

/**
 * Constructor que permite crear una nueva tarjeta de crédito.
 * @param fechaVencimiento El parámetro fechaVecimiento representa la fecha de vencimiento de la tarjeta de crédito.
 * @param numero El parámetro numero representa el número de la tarjeta de crédito.
 * @param codigo El parámetro codigo representa el código CVC de la tarjeta de crédito.
 */
public Tarjeta(String fechaVencimiento, String numero, String codigo) {
	super();
	this.fechaVencimiento = fechaVencimiento;
	this.numero = numero;
	this.codigo = codigo;
}

/**
 * Método que devuelve la fecha de vencimiento de la tarjeta de crédito.
 * @return Retorna la fecha de vencimiento de la tarjeta de crédito.
 */
public String getFechaVencimiento() {
	return fechaVencimiento;
}

/**
 * Método que devuelve el número de la tarjeta de crédito.
 * @return Retorna el número de la tarjeta de crédito.
 */
public String getNumero() {
	return numero;
}

/**
 * Método que devuelde el código CVC de la tarjeta de crédito.
 * @return Retorna el código CVC de la tarjeta de crédito.
 */
public String getCodigo() {
	return codigo;
}


}
