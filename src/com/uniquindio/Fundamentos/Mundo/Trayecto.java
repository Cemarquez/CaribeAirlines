package com.uniquindio.Fundamentos.Mundo;

import java.io.Serializable;

/**
 *  Trayecto que la aerolinea proporcionará dependiendo de las peticiones de los clientes.
 *  @author Cesar Marquez - Brian Giraldo
 */
@SuppressWarnings("serial")
public class Trayecto implements Serializable {
	
	private String origen;
	private String destino;
	private int duracionMin;
	private Tripulacion tripulacion;
	
	/**
	 * Constructor del trayecto.
	 * @param avion lleno de pasajeros.
	 * @param vuelos vuelo a realizar.
	 * @param tripulacion aginada para el trayecto.
	 * @param fecha dia en que se realizará.
	 */
	public Trayecto(String origen, String destino) {
		super();
		this.origen = origen;
		this.destino = destino;
	}

	/**
	 * Método que permite definir la duración en minutos del trayecto.
	 * @param duracionMin El parámetro duracionMin representa la duración.
	 */
	public void setDuracionMin(int duracionMin) {
		this.duracionMin = duracionMin;
	}

	/**
	 * Método que devuelve el origen del trayecto.
	 * @return Retorna el origen del trayecto.
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * Método que devuelve el destino del trayecto.
	 * @return Retorna el destino del trayecto.
	 */
	public String getDestino() {
		return destino;
	}

	/**
	 * Método que devuelve la duración en minutos del trayecto.
	 * @return Retorna la duración en minutos del trayecto.
	 */
	public int getDuracionMin() {
		return duracionMin;
	}

	/**
	 * Método que retorna la tripulación del trayecto;
	 * @return Retorna la tripulación del trayecto;
	 */
	public Tripulacion getTripulacion() {
		return tripulacion;
	}

	/**
	 * Método que asigna una tripulación al trayecto.
	 * @param tripulacion El parámetro tripulacion representa a la tripulación que será asignada al trayecto.
	 */
	public void setTripulacion(Tripulacion tripulacion) {
		this.tripulacion = tripulacion;
	}
	

	
	
	
	
}