package com.uniquindio.Fundamentos.Mundo;

import java.io.Serializable;

import com.uniquindio.Fundamentos.Mundo.Silla.Clase;
import com.uniquindio.Fundamentos.Mundo.Silla.Ubicacion;

/**
 * Clase que representa a un avión de la aerolinea.
 * 
 * @author Cesar Marquez - Brian Giraldo
 */
@SuppressWarnings("serial")
public class Avion implements Serializable{

	//Atributos de la clase
	public final static int SILLAS_EJECUTIVAS = 12;
	public final static int SILLAS_ECONOMICAS = 138;
	private Silla[] sillasEjecutivas;
	private Silla[] sillasEconomicas;
	private int capacidad;
	private int capacidadKilosAdicionales;
	private String modelo;

	/**
	 * Construye el avión.Se inicializan las listas de sillas ejecutivas y económicas.
	 */
	public Avion() {
		Ubicacion ubicacionEje, ubicacionEco;
		String enumEje = "", enumEco = "";
		char letraEje, letraEco;
		int contadorNumero = 1;
		int contador = 0, contadorEco = 0;
		sillasEjecutivas = new Silla[SILLAS_EJECUTIVAS];
		sillasEconomicas = new Silla[SILLAS_ECONOMICAS];
		capacidad = 19000;
		capacidadKilosAdicionales = capacidad - 4200;
		modelo = "Airbus A320";

		letraEje = 65;

		// Crear las sillas ejecuticas.
		for (int i = 1; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				enumEje = letraEje + "" + contadorNumero;
				letraEje++;
				// Sillas ventana
				if (j % 6 == 1 || j % 6 == 0)
					ubicacionEje = Ubicacion.VENTANA;
				// Sillas centrales
				else if (j % 6 == 2 || j % 6 == 5)
					ubicacionEje = Ubicacion.CENTRAL;
				// Sillas pasillo
				else
					ubicacionEje = Ubicacion.PASILLO;
				sillasEjecutivas[contador] = new Silla(enumEje, Clase.EJECUTIVA, ubicacionEje);
				contador++;
				if (letraEje == 66) {
					letraEje = 67;
				}
				if (letraEje == 'E') {
					letraEje = 'F';
				}
				if (letraEje > 'F') {
					letraEje = 'A';
				}

			}

			contadorNumero++;

		}

		letraEco = 65;
		int contadorNumeroEco = 4;
		// Crear las sillas economicas.
		for (int i = 1; i < 24; i++) {
			for (int j = 0; j < 6; j++) {
				enumEco = letraEco + "" + contadorNumeroEco;
				letraEco++;
				if (contadorEco % 6 == 5 || j % 6 == 0)
					ubicacionEco = Ubicacion.VENTANA;
				// Sillas centrales
				else if (contadorEco % 6 == 1 || j % 6 == 4)
					ubicacionEco = Ubicacion.CENTRAL;
				// Sillas pasillo
				else
					ubicacionEco = Ubicacion.PASILLO;

				sillasEconomicas[contadorEco] = new Silla(enumEco, Clase.ECONOMICA, ubicacionEco);
				contadorEco++;

				if (letraEco > 'F') {
					letraEco = 'A';
				}

			}

			contadorNumeroEco++;
		}

	}

	/**
	 * Método que permite verificar si el pasajero ya está dentro del avión.
	 * @param pPasajero El parámetro pPasajero representa al pasajero que se va a buscar dentro del avión.
	 * @return Retorna true en caso de que el pasajero haya sido encontrado y false en caso contrario.
	 */
	public boolean pasajeroRepetido(Pasajero pPasajero) {
		boolean isRepetido = false;
		boolean centinela = false;
		Pasajero pasa;
		String cedula;
		for (int i = 0; i < sillasEconomicas.length && centinela == false; i++) {
			pasa = sillasEconomicas[i].getPasajero();
		    cedula = pPasajero.getId();
			if (pasa != null) {
				if (pasa.getId().equals(cedula)) {
					isRepetido = true;
					centinela = true;
				}
			}

		}

		return isRepetido;
	}

	/**
	 * Método que permite buscar un pasajero dentro del avión.
	 * @param pPasajero El parámetro pPasajero repsenta al pasajero que se desea buscar.
	 * @return Retorna la silla en la que se encontró el pasajero. Si no lo encuentra retorna null.
	 */
	public Silla buscarPasajero(Pasajero pPasajero) {
		// Busca el pasajero en ejecutiva
		Silla silla = buscarPasajeroEjecutivo(pPasajero);

		// Si no estaba en ejecutiva
		if (null == silla) {
			// Busca en económica
			silla = buscarPasajeroEconomico(pPasajero);
		}

		return silla;

	}

	/**
	 * Método que permite buscar un pasajero en las sillas ejecutivas.
	 * @param pPasajero El parámetro pPasajero repsenta al pasajero que se desea buscar.
	 * @return Retorna la silla en la que se encontró el pasajero. Si no lo encuentra retorna null.
	 */
	public Silla buscarPasajeroEjecutivo(Pasajero pPasajero) {
		boolean encontrado = false;
		Silla silla = null;
		for (int i = 0; i < SILLAS_EJECUTIVAS && encontrado == false; i++) {
			silla = sillasEjecutivas[i];
			if (silla.sillaAsignada() && silla.getPasajero().igualA(pPasajero)) {
				encontrado = true;
			}
		}
		if (encontrado == false) {
			silla = null;
		}
		return silla;
	}

	/**
	 * Método que permite buscar un pasajero en las sillas económicas.
	 * @param pPasajero El parámetro pPasajero repsenta al pasajero que se desea buscar.
	 * @return Retorna la silla en la que se encontró el pasajero. Si no lo encuentra retorna null.
	 */
	public Silla buscarPasajeroEconomico(Pasajero pPasajero) {
		boolean encontrado = false;
		Silla silla = null;
		for (int i = 0; i < SILLAS_ECONOMICAS && !encontrado; i++) {
			silla = sillasEconomicas[i];
			if (silla.sillaAsignada() && silla.getPasajero().igualA(pPasajero)) {
				encontrado = true;
			}
		}
		if (encontrado == false) {
			silla = null;
		}
		return silla;
	}

	/**
	 * Método que permite desasignar la silla de un pasajero.
	 * @param pPasajero El parámetro pPasajero repsenta al pasajero al que se desea retirar la silla.
	 * @return Retorna true si encontró el pasajero y desasignó la silla, false en caso contrario.
	 */
	public boolean desasignarSilla(Pasajero pPasajero) {
		// Busca el pasajero en el avión
		Silla silla = buscarPasajero(pPasajero);
		boolean resultado = false;
		// Si lo encuentra desasigna
		if (silla != null) {
			silla.desasignarSilla();
			resultado = true;
		}
		return resultado;
	}

    /**
     * Método que permite contar las sillas ejecutivas ocupadas.
     * @return Retorna el número de sillas ejecutivas ocupadas.
     */
	public int contarSillasEjecutivasOcupadas() {
		int contador = 0;
		for (int i = 0; i < SILLAS_EJECUTIVAS; i++) {
			Silla silla = sillasEjecutivas[i];
			if (silla.sillaAsignada()) {
				contador++;
			}
		}
		return contador;
	}

	 /**
     * Método que permite contar las sillas económicas ocupadas.
     * @return Retorna el número de sillas económicas ocupadas.
     */
	public int contarSillasEconomicasOcupadas() {
		int contador = 0;
		for (int i = 0; i < SILLAS_ECONOMICAS; i++) {
			Silla silla = sillasEconomicas[i];
			if (silla.sillaAsignada()) {
				contador++;
			}
		}
		return contador;
	}

	

	/**
	 * Método que devuelve las sillas ejecutivas del avión.
	 * @return Retorna las sillas ejecutivas del avión.
	 */
	public Silla[] getSillasEjecutivas() {
		return sillasEjecutivas;
	}

	/**
	 * Método que devuelve las sillas económicas del avión.
	 * @return Retorna las sillas económicas del avión.
	 */
	public Silla[] getSillasEconomicas() {
		return sillasEconomicas;
	}

	/**
	 * Método que permite quitar peso disponibles para kilos adicionales en bodega.
	 * @param kilos El parámetro kilos representa al número de kilos que se van a remover de la capacidad disponible.
	 */
	public void quitarPeso(int kilos) {
		this.capacidadKilosAdicionales = this.capacidadKilosAdicionales - kilos;
	}
   
	/**
	 * Método que devuelve la capacidad total del avión.
	 * @return Retorna la capacidad total del avión.
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * Método que permite asignar una silla a un pasajero establecido.
	 * @param pSilla El parámetro pSilla representa a la silla a la cual se va a asignar el pasajero.
	 * @param pPasajero El parámetro pPasajero representa al pasajero al cual se va a asignar a la silla establecida.
	 */
	public void asignarSilla(Silla pSilla, Pasajero pPasajero) {
		pSilla.asignarAPasajero(pPasajero);
	}

	/**
	 * Método que devuelve los kilos disponibles en la capacidad de kilos adiciones actual en bodega.
	 * @return
	 */
	public int getKilosDisponibles() {
		return capacidadKilosAdicionales;
	}
	
	/**
	 * Método que devuelve el modelo del avión.
	 * @return
	 */
	public String getModelo()
	{
		return modelo;
	}
}
