package com.uniquindio.Fundamentos.Mundo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Vuelos predeterminados por la aerolinea.
 * @author Cesar Marquez - Brian Giraldo
 */
@SuppressWarnings("serial")
public class Vuelo implements Serializable {
	
	/**
	 * Enumeraci�n usada para definir el tipo de vuelo.
	 */
	public enum Tipo
	{
		INTERNACIONAL,
		
		NACIONAL
	}
	
	private Avion avion;
	private String fecha;
	private String horaSalida;
	private ArrayList<Pasajero> pasajerosEnVuelo;
	private String precio;
	private Tipo tipo;
	private Trayecto trayecto;
	private boolean realizado;
	
	/**
	 * Constructor que permite crear un nuevo vuelo.
	 * @param avion Avion que estar� asignado al vuelo.
	 * @param fecha Fecha de salida del vuelo.
	 * @param horaSalida Hora de salida en la cual saldr� el vuelo.
	 * @param precio Precio por persona base en econ�mica del vuelo.
	 * @param tipo Tipo de vuelo (Nacional - Internacional).
	 * @param trayecto Trayecto que seguir� el vuelo.
	 */
	public Vuelo(Avion avion, String fecha, String horaSalida, String precio, Tipo tipo, Trayecto trayecto) {
		super();
		pasajerosEnVuelo = new ArrayList<Pasajero>();
		this.avion = avion;
		this.fecha = fecha;
		this.horaSalida = horaSalida;
		this.precio = precio;
		this.tipo = tipo;
		this.trayecto = trayecto;
		realizado = false;
	
	}
/**
 * M�todo que devuelve el trayecto del vuelo.
 * @return Retorna el trayecto del vuelo.
 */
public Trayecto getTrayecto()
{
	return trayecto;
}

   /**
   * M�todo que devuelve el avi�n del vuelo.
   * @return Retorna el avi�n del vuelo.
   */
	public Avion getAvion() {
		return avion;
	}

	/**
	 * M�todo que devuelve la fecha en que se har� el vuelo.
	 * @return Retorna la fecha en que se har� el vuelo.
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * M�todo que devuelve la hora de salida del vuelo.
	 * @return Retorna la hora de salida del vuelo.
	 */
	public String getHoraSalida() {
		return horaSalida;
	}

	/**
	 * M�todo que devuelve el precio base econ�mica el vuelo.
	 * @return Retorna el precio base econ�mica el vuelo.
	 */
	public String getPrecio() {
		return precio;
	}

	/**
	 * M�todo que devuelve el tipo de vuelo.
	 * @return Retorna el tipo de vuelo.
	 */
	public Tipo getTipo() {
		return tipo;
	}
	
	/**
	 * M�todo que permite agregar un pasajero a la lista de pasajeros en el vuelo.
	 * @param pPasajero Pasajero que se quiere agregar.
	 */
	public void agregarPasajero(Pasajero pPasajero)
	{
		pasajerosEnVuelo.add(pPasajero);
	}
	
	/**
	 * M�todo que devuelve la lista de pasajeros en el vuelo.
	 * @return Reporta la lista de pasajeros en el vuelo.
	 */
	public ArrayList<Pasajero> getPasajerosEnVuelo() {
		return pasajerosEnVuelo;
	}
	
	public void setRealizado(boolean realizado)
	{
		this.realizado = realizado;
	}
/**
 * M�todo que permite verificar si un pasajero est� o no repetido en un vuelo.
 * @param pPasajero Pasajero que se va a buscar.
 * @return Retorna false si est� repetido y true en caso contrario.
 */
public boolean pasajeroRepetido(Pasajero pPasajero)
{
	boolean isRepetido = false;
	if(pasajerosEnVuelo.isEmpty())
	{
		isRepetido = false;
	}
	else
	{
		for(int i=0;i< pasajerosEnVuelo.size();i++)
		{
			if(pasajerosEnVuelo.get(i).getId().equals(pPasajero.getId()))
					{
				        isRepetido=true;
					}
		}
	}
	
	
	return isRepetido;
}

public boolean isRealizado()
{
	return realizado;
}
	
}
