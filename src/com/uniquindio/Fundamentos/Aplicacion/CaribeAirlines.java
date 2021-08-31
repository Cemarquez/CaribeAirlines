package com.uniquindio.Fundamentos.Aplicacion;


import com.uniquindio.Fundamentos.Interfaces.PantallaCargandoMain;
import com.uniquindio.Fundamentos.Serializacion.Persistencia;

/**
 * Clase aplicación desde la cual se ejecutará el programa
 * @author Cesar Marquez - Brian Giraldo
 *
 */
public class CaribeAirlines {
	private static Persistencia serializar = new Persistencia();
	/**
	 * Método Main de ejecución
	 * @param args    
	 */
	public static void main(String[] args) {
		
		new PantallaCargandoMain();

	}
}
	
