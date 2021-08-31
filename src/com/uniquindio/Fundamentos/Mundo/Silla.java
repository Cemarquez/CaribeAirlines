package com.uniquindio.Fundamentos.Mundo;

import java.io.Serializable;

/**
 * Clase que representa a una silla dentro del avión.
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
	 * Crea la silla con su número identificador. Inicialmente no hay ningún pasajero ubicado en la silla.
	 * @param pNumero El parámetro pNumero representa al número de la silla en el avión.
	 * @param pClase El parámetro pClase representa a la clase de la silla.
	 * @param pUbicacion El parámetro pUbicacion representa la ubicación de la silla.
	 */
	public Silla(String pNumero, Clase pClase, Ubicacion pUbicacion) {
		    numero = pNumero;
	        clase = pClase;
	        ubicacion = pUbicacion;
	        // Inicialmente no hay ningún pasajero en la silla
	        pasajero = null;
	}

	/**
	 * Asigna la silla al pasajero recibido como parámetro.
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
	 * Indica si la silla está asignada.
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
	 * Indica si la silla está asignada al pasajero recibido como parámetro.
	 * @param pPasajero Pasajero a comparar con el de la silla.
	 * @return Retorna true si el pasajero ocupa la silla, false si la silla está vacía o no coincide con el pasajero recibido como parámetro.
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
	 * Retorna el número de la silla.
	 * @return Número de la silla.
	 */
	public String getNumero() {
		return numero;
	}
	
	/**
     * Retorna la ubicación de la silla.
     * @return Ubicación de la silla.
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
