package com.uniquindio.Fundamentos.Mundo;

import java.io.Serializable;

/**
 * tripulaciones de la aerolinea.
 * @author Cesar Marquez - Brian Giraldo
 */
@SuppressWarnings("serial")
public class Tripulacion implements Serializable{
	
	/**
	 * piloto integrante de la tripulacion.
	 */
	private Tripulante piloto;
	
	/**
	 * copiloto integrante de la tripulacion.
	 */
	private Tripulante copiloto;
	
	/**
	 * primer auxiliar integrante de la tripulacion.
	 */
	private Tripulante auxiliar1;
	
	/**
	 * segundo auxiliar integrante de la tripulacion.
	 */
	private Tripulante auxiliar2;
	
	/**
	 * tercer auxiliar integrante de la tripulacion.
	 */
	private Tripulante auxiliar3;
	/**
	 * Constructor de la tripulacion.
	 * @param piloto que conforma la tripulacion.
	 * @param copiloto que conforma la tripulacion.
	 * @param auxiliar1 que conforma la tripulacion.
	 * @param auxiliar2 que conforma la tripulacion.
	 * @param auxiliar3 que conforma la tripulacion.
	 */
	public Tripulacion(Tripulante piloto, Tripulante copiloto, Tripulante auxiliar1, Tripulante auxiliar2,
			Tripulante auxiliar3) {
		super();
		this.piloto = piloto;
		this.copiloto = copiloto;
		this.auxiliar1 = auxiliar1;
		this.auxiliar2 = auxiliar2;
		this.auxiliar3 = auxiliar3;
	}
	

	/**
	 * obtiene el piloto.
	 * @return el piloto.
	 */
	public Tripulante getrPiloto() {
		return piloto;
	}
	
	/**
	 * obtiene el copiloto.
	 * @return el copiloto.
	 */
	public Tripulante getCopiloto() {
		return copiloto;
	}
	
	/**
	 * obtiene el primer auxiliar.
	 * @return el auxiliar1.
	 */
	public Tripulante getAuxiliar1() {
		return auxiliar1;
	}
	
	/**
	 * obtiene el segundo auxiliar.
	 * @return el axiliar2.
	 */
	public Tripulante getAuxiliar2() {
		return auxiliar2;
	}
	
	/**
	 * obtiene el tercer auxiliar.
	 * @return el axiliar3.
	 */
	public Tripulante getAuxiliar3() {
		return auxiliar3;
	}

	/**
	 * Método que permite obtener el número de tripulantes registrados para ese trayecto;
	 * @return
	 */
	public int numTripulantes ()
	{
		int num=0;
		if(piloto.getId() != null)
		{
			num++;
		}
		if(copiloto.getId() != null)
		{
			num++;
		}
		if(auxiliar1.getId() != null)
		{
			num++;
		}
		
		if(auxiliar2.getId() != null)
		{
			num++;
		}
		 if(auxiliar3.getId() != null)
		{
			num++;
		}
		
		return num;
	}

	
}
