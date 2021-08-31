package com.uniquindio.Fundamentos.Mundo;

import java.io.Serializable;

/**
 * Tripulantes contratados por la aerolinea.
 * @author Cesar Marquez - Brian Giraldo
 */
@SuppressWarnings("serial")
public class Tripulante implements Serializable{
	
	/**
	 * enumeracion de los estudios de ccada tripulante.
	 */
	public enum Estudios{
		PILOTO,
		COPILOTO,
		AUXILIAR
	}
	
	/**
	 * Número de identificación o pasaporte del pasajero.
	 */	
	private String id;

	/**
	 * Nombre del pasajero.
	 */
	private String nombre; 

	/**
	 * Apellido del pasajero.
	 */
	private String apellido;

	/**
	 * Dirección de domicilio del pasajero.
	 */
	private String direccion;
	
	/**
	 * Correo electronico del pasajero.
	 */
	private String correo;
	
	/**
	 * Fecha de nacimiento del pasajero.
	 */
	private String fechaNacimiento;
	
	/**
	 * Estudio del tripulante.
	 */
	private Estudios estudios;
	
	/**
	 * Constructor del tripulante.
	 * @param id numero de identificacion del tripulante.
	 * @param nombre del tripulante.
	 * @param apellido del tripulante.
	 * @param direccion del tripulante.
	 * @param correo del tripulante.
	 * @param fechaNacimiento del tripulante.
	 * @param estudios del tripulante.
	 */
	public Tripulante(String id, String nombre, String apellido, String direccion, String correo,
			String fechaNacimiento, Estudios estudios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.estudios = estudios;
	}
    
	public void actualizarDatos(String id, String nombre, String apellido, String direccion, String correo,
			String fechaNacimiento)
	{
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
	}
	/**
	 * Obtiene la identificacion del tripulante.
	 * @return numero de identidad.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Obtiene la nombre del tripulante.
	 * @return nombre.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene la apellido del tripulante.
	 * @return apellido.
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Obtiene la direccion del tripulante.
	 * @return  direccion.
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Obtiene la correo del tripulante.
	 * @return correo.
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Obtiene la fecha de nacimiento del tripulante.
	 * @return fecha de nacimiento.
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * obtiene estudios del tripulante
	 * @return estudio.
	 */
	public Estudios getEstudios() {
		return estudios;
	}

}
