package com.uniquindio.Fundamentos.Mundo;

import java.io.Serializable;

/**
 * Clase que representa a un pasajero del avión.
 * @author Cesar Marquez - Brian Giraldo
 *
 */
@SuppressWarnings("serial")
public class Pasajero implements Serializable
{
    //Atributos de la clase.
	private String id;
	private String nombre; 
	private String apellido;
	private String fechaNacimiento;
	
	/**
	 * Constructor que permite crear un pasajero con sus datos asignados.
	 * @param id El parámetro id representa al número de identificación o pasaporte del pasajero.
	 * @param nombre El parámetro nombre representa al nombre del pasajero.
	 * @param apellido El parámetro apellido representa al apellido del pasajero.
	 * @param fechaNacimiento El parámetro fechaNacimiento representa a la fecha de nacimiento del pasajero.
	 */
	public Pasajero(String id, String nombre, String apellido, String fechaNacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	/**
	 * Método que devuelve la id del pasajero.
	 * @return Retorna La id del pasajero.
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Método que devuelve el nombre del pasajero.
	 * @return Retorna el nombre del pasajero.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Método que devuelve el apellido del pasajero.
	 * @return Retorna el apellido del pasajero.
	 */
	public String getApellido() {
		return apellido;
	}
	
	
	
	/**
	 * Método que devuelve la fecha de nacimiento del pasajero.
	 * @return Retorna la fecha de nacimiento del pasajero.
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	
	/**
	 * Método para verificar si un pasajero es igual al que entra como parametro.
	 * @param pOtroPasajero El otro pasajero con el que se le desea comparar.
	 * @return Retorna true si es igual y false si no lo es.
	 */
	public boolean igualA( Pasajero pOtroPasajero )
	{
	    boolean esIgual = false;
	    if( id.equals( pOtroPasajero.getId()))
	    {
	        esIgual = true;
	    }
	
	    return esIgual;
	}
	
	
	
	
	
}
