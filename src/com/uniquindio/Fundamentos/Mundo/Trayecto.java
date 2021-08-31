package com.uniquindio.Fundamentos.Mundo;

import java.io.Serializable;

/**
 *  Trayecto que la aerolinea proporcionar� dependiendo de las peticiones de los clientes.
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
	 * @param fecha dia en que se realizar�.
	 */
	public Trayecto(String origen, String destino) {
		super();
		this.origen = origen;
		this.destino = destino;
	}

	/**
	 * M�todo que permite definir la duraci�n en minutos del trayecto.
	 * @param duracionMin El par�metro duracionMin representa la duraci�n.
	 */
	public void setDuracionMin(int duracionMin) {
		this.duracionMin = duracionMin;
	}

	/**
	 * M�todo que devuelve el origen del trayecto.
	 * @return Retorna el origen del trayecto.
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * M�todo que devuelve el destino del trayecto.
	 * @return Retorna el destino del trayecto.
	 */
	public String getDestino() {
		return destino;
	}

	/**
	 * M�todo que devuelve la duraci�n en minutos del trayecto.
	 * @return Retorna la duraci�n en minutos del trayecto.
	 */
	public int getDuracionMin() {
		return duracionMin;
	}

	/**
	 * M�todo que retorna la tripulaci�n del trayecto;
	 * @return Retorna la tripulaci�n del trayecto;
	 */
	public Tripulacion getTripulacion() {
		return tripulacion;
	}

	/**
	 * M�todo que asigna una tripulaci�n al trayecto.
	 * @param tripulacion El par�metro tripulacion representa a la tripulaci�n que ser� asignada al trayecto.
	 */
	public void setTripulacion(Tripulacion tripulacion) {
		this.tripulacion = tripulacion;
	}
	

	
	
	
	
}