package com.uniquindio.Fundamentos.Mundo;

import java.io.Serializable;

/**
 * Clase que representa a una silla dentro del avi�n.
 * @author Cesar Marquez - Brian Giraldo
 * 
 */
@SuppressWarnings("serial")
public class Silla implements Serializable {
	
	/**
     * Enumeradores para la clases de la sillas
     */
	public enum Clase {
		
		EJECUTIVA,

		
		ECONOMICA
	}
	
	/**
     * Enumeradores para las ubicaciones de las sillas.
     */
    public enum Ubicacion {
    	
        VENTANA,

        
        CENTRAL,

      
        PASILLO
    }

	
	private String numero;
	private Clase clase;
    private Ubicacion ubicacion;
	private Pasajero pasajero;

	/**
	 * Crea la silla con su n�mero identificador. Inicialmente no hay ning�n pasajero ubicado en la silla.
	 * @param pNumero El par�metro pNumero representa al n�mero de la silla en el avi�n.
	 * @param pClase El par�metro pClase representa a la clase de la silla.
	 * @param pUbicacion El par�metro pUbicacion representa la ubicaci�n de la silla.
	 */
	public Silla(String pNumero, Clase pClase, Ubicacion pUbicacion) {
		    numero = pNumero;
	        clase = pClase;
	        ubicacion = pUbicacion;
	        // Inicialmente no hay ning�n pasajero en la silla
	        pasajero = null;
	}

	/**
	 * Asigna la silla al pasajero recibido como par�metro.
	 * @param pPasajero Pasajero a asignar en la silla.
	 */
	public void asignarAPasajero(Pasajero pPasajero) {
		pasajero = pPasajero;
	}

	/**
	 * Desasigna la silla al pasajero. La silla queda nuevamente libre.
	 */
	public void desasignarSilla() {
		pasajero = null;
	}

	/**
	 * Indica si la silla est� asignada.
	 * @return Retorna true si la silla esta asignada, false en caso contrario.
	 */
	public boolean sillaAsignada() {
		boolean asignada = false;
		if (null != pasajero) {
			asignada = true;
		}
		return asignada;
	}

	/**
	 * Indica si la silla est� asignada al pasajero recibido como par�metro.
	 * @param pPasajero Pasajero a comparar con el de la silla.
	 * @return Retorna true si el pasajero ocupa la silla, false si la silla est� vac�a o no coincide con el pasajero recibido como par�metro.
	 */
	public boolean sillaAsignadaPasajero(Pasajero pPasajero) {
		boolean asignadaPasajero = false;
		if (null == pasajero) {
			asignadaPasajero = false;
		} else if (pasajero.igualA(pPasajero)) {
			asignadaPasajero = true;
		}

		return asignadaPasajero;
	}

	/**
	 * Retorna el n�mero de la silla.
	 * @return N�mero de la silla.
	 */
	public String getNumero() {
		return numero;
	}
	
	/**
     * Retorna la ubicaci�n de la silla.
     * @return Ubicaci�n de la silla.
     */
    public Ubicacion getUbicacion( )
    {
        return ubicacion;
    }

	/**
	 * Retorna la clase de la silla.
	 * @return Clase de la silla.
	 */
	public Clase getClase() {
		return clase;
	}
	
	/**
	 * Retorna el pasajero asignado a la silla.
	 * @return Pasajero asignado a la silla. Si no hay pasajero retorna null.
	 */
	public Pasajero getPasajero() {
		return pasajero;
	}

}
