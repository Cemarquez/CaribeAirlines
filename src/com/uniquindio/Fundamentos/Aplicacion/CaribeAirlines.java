package com.uniquindio.Fundamentos.Aplicacion;


import com.uniquindio.Fundamentos.Interfaces.PantallaCargandoMain;
import com.uniquindio.Fundamentos.Serializacion.Persistencia;

/**
 * Clase aplicaci�n desde la cual se ejecutar� el programa
 * @author Cesar Marquez - Brian Giraldo
 *
 */
public class CaribeAirlines {
	private static Persistencia serializar = new Persistencia();
	/**
	 * M�todo Main de ejecuci�n
	 * @param args    
	 */
	public static void main(String[] args) {
		
		new PantallaCargandoMain();

	}
}
	
