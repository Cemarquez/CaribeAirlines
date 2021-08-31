package com.uniquindio.Fundamentos.Mundo;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase que representa a un consolidado (venta -  fecha) de la aerolinea.
 * @author Cesar Marquez -  Brian Giraldo
 * 
 */
@SuppressWarnings("serial")
public class Consolidado implements Serializable{
	//Atributos de la clase.
private int dinero;
private Date fecha;
private Vuelo vuelo;
/**
 * Constructor que permite crear un nuevo consolidado.
 * @param dinero El parámetro dinero representa al dinero recaudado en esa venta.
 * @param fecha El parámetro fecha representa a la fecha en que fue hecha la venta.
 */
public Consolidado(int dinero, Date fecha, Vuelo vuelo) {
	super();
	this.dinero = dinero;
	this.fecha = fecha;
	this.vuelo = vuelo;
}

/**
 * Método que devuelve el dinero del consolidado.
 * @return Retorna el dinero del consolidado.
 */
public int getDinero() {
	return dinero;
}

/**
 * Método que devuelve la fecha del consolidado.
 * @return Retorna la fecha del consolidado.
 */
public Date getFecha() {
	return fecha;
}

public Vuelo getVuelo()
{
	return vuelo;
}

}
