package com.uniquindio.Fundamentos.Mundo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import com.uniquindio.Fundamentos.MailSender.MailSender;
import com.uniquindio.Fundamentos.Mundo.Tripulante.Estudios;
import com.uniquindio.Fundamentos.Mundo.Vuelo.Tipo;
import com.uniquindio.Fundamentos.Util.Util;

/**
 * Esta clase define a la aerolinea, es la clase principal del programa.
 * 
 * @author Cesar Marquez - Brian Giraldo
 */
@SuppressWarnings("serial")
public class Aerolinea implements Serializable {

    //Atributos de la clase
	
	private int numeroFactura=0;
	private  Admin administrador;
	private ArrayList<Cliente> misClientes;
	private   ArrayList<Vuelo> misVuelos;
	private Trayecto trayectos[];
	private  Tripulacion[] tripulaciones;
	private ArrayList<Reserva> reservas;
	private ArrayList<Integer> kilosAdicionales;
	private ArrayList<RegistroVueloPorPasajero> registrosVuelosPorPasajeroAerolinea;
	private ArrayList<Consolidado> dineroRecaudado;
	private ArrayList<Tiquete> tiquetesAerolinea;
	private ArrayList<Factura> facturasAerolinea;
	private  MailSender mail;

	/**
	 * Constructor de la aerolinea.
	 */
	public Aerolinea() {
		facturasAerolinea = new ArrayList<Factura>();
		administrador = new Admin("admin", "admin");
		misClientes = new ArrayList<Cliente>();
		reservas = new ArrayList<Reserva>();
		dineroRecaudado = new ArrayList<Consolidado>();
		registrosVuelosPorPasajeroAerolinea = new ArrayList<RegistroVueloPorPasajero>();
		kilosAdicionales = new ArrayList<Integer>();
		misClientes.add(new Cliente("Prueba", "Fundamentos", "pruebaairlines@outlook.es", "Calle 12", "prueba.1234", "127.0.0.1", "fechaNacimiento"));
		inicializarTripulacion();
		inicializarTrayectos();
		inicializarVuelos();
		tiquetesAerolinea = new ArrayList<Tiquete>();
	}
	
	public void mailSender()
	{
		mail = new MailSender();
	}
	
	public void enviarCorreoBienvenida(String destinatario, String datos) 
	{
		mail.enviarCorreoBienvenida(destinatario, datos);
	}
	
	public void enviarCorreoCompra(String remitente, String ruta, String nombreFile)
	{
		mail.enviarCorreoCompra(remitente, ruta, nombreFile);
	}
	
	public void setMail(MailSender mail)
	{
		this.mail = mail;
	}
    
	/**
	 * Método que añade una factura al ArrayList de facturas presente en esta clase.
	 * @param factura El parámetro factura representa a la factura que se va a agregar a la lista.
	 */
	public void añadirFacturaAerolinea(Factura factura) {
		facturasAerolinea.add(factura);
	}

    /**
     * Método que añade un tiquete al AraryList de tiquetes presente en esta clase.
     * @param pTiquete El parámetro pTiquete representa al tiquete que va a ser agregado a la lista.
     */
	public void añadirTiquete(Tiquete pTiquete) {
		tiquetesAerolinea.add(pTiquete);
	}

	/**
	 * Método que añade un consolidado al ArrayList de consolidados, es decir, una venta y su fecha.
	 * @param pConsolidado El parámetro pConsolidado representa al consolidado que va a ser agregado a la lista.
	 */
	public void añadirConsolidado(Consolidado pConsolidado) {
		dineroRecaudado.add(pConsolidado);
	}

	/**
	 * Método que devuelve el ArrayList de reservas presente en la aerolinea.
	 * @return Retorna el ArrayList de reservas presente en la aerolinea.
	 */
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	/**
	 * Método que devuelve el ArrayList de kilos adicionales en cada ventana presente en la aerolinea.
	 * @return Retorna el ArrayList de kilos adicionales presente en la aerolinea.
	 */
	public ArrayList<Integer> getKilosAdicionales() {
		return kilosAdicionales;
	}

	/**
	 * Método que añade determinado número de kilos al ArrayList de kilos adicionales.
	 * @param kilos El parámetro kilos representa al número de kilos que van a ser añadidos.
	 */
	public void añadirKilos(int kilos) {
		kilosAdicionales.add(kilos);
	}

	/**
	 * Método que añade una reserva a la lista de reservas presente en la aerolinea.
	 * @param pReserva El parámetro pReserva representa la reserva que va a ser añadida a la lista.
	 */
	public void AñadirReservaAerolinea(Reserva pReserva) {
		reservas.add(pReserva);
	}

	/**
	 * Método que añade un registro de pasajero a la lista de registros presente en la aerolinea.
	 * @param pRegistro El párametro pRegistro representa al registro que va a ser añadido a la lista.
	 */
	public void añadirRegistroPorPasajero(RegistroVueloPorPasajero pRegistro) {
		registrosVuelosPorPasajeroAerolinea.add(pRegistro);
	}

	/**
	 * Método que devuelve al administrador de la aerolinea.
	 * @return Retorna al administrador de la aerolinea.
	 */
	public Admin getAdministrador() {
		return administrador;
	}

	/**
	 * Método que devuelve al ArrayList de clientes presente en la aerolinea.
	 * @return Retorna el ArrayList de clientes presente en la aerolinea.
	 */
	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}

	
	/**
	 * Método que permite agregar un nuevo cliente a la lista de clientes.
	 * @param pCliente El parámetro pCliente representa al cliente que va a ser añadido.
	 */
	public void agregarCliente(Cliente pCliente) {
		misClientes.add(pCliente);
	}

	/**
	 * Método que añade toda la tripulación a la aerolinea.
	 */
	public void  inicializarTripulacion() {
		tripulaciones = new Tripulacion[6];

		Tripulante piloto1 = new Tripulante("7316944412", "Juanita", "Griego Aguayo",
				"Alvaro Cunqueiro, 64 40440 Santa María la Real de Nieva", "JuanitaGriegoAguayo@gustr.com",
				"26/06/1978", Estudios.PILOTO);
		Tripulante copiloto1 = new Tripulante("1005826218", "Frutos", "Ochoa Soliz", "Calle 12 #4-02",
				"frutosO@gmai.com", "29/07/1980", Estudios.COPILOTO);
		Tripulante auxiliar11 = new Tripulante("1003030403", "Aurelianus", "Jakov", "Calle 12 # 456",
				"jakovq@gmail.com", "31/01/1970", Estudios.AUXILIAR);
		Tripulante auxiliar12 = new Tripulante("1234451215", "Deyner", "Vergara", "La tebaida", "deyVer@gmail.com",
				"24/05/1998", Estudios.AUXILIAR);
		Tripulante auxiliar13 = new Tripulante("5651562662", "Fabian", "Lopez", "La tebaida", "fabilopez@gmail.com",
				"07/11/2001", Estudios.AUXILIAR);
		tripulaciones[0] = new Tripulacion(piloto1, copiloto1, auxiliar11, auxiliar12, auxiliar13);

		Tripulante piloto2 = new Tripulante("73169434533", "Juan", "Aguayo", "Armenia", "JuanG@gmail.com", "26/06/1988",
				Estudios.PILOTO);
		Tripulante copiloto2 = new Tripulante("1005822312", "Roberto", "Ochoa Soliz", "Calle 12 #4-02",
				"RoberO@gmai.com", "29/07/1980", Estudios.COPILOTO);
		Tripulante auxiliar21 = new Tripulante("15584555554", "Aurelio", "Jacobo", "Calle 12 # 456", "jacobo@gmail.com",
				"31/01/1970", Estudios.AUXILIAR);
		Tripulante auxiliar22 = new Tripulante("1234334444", "Deynardo", "Boina", "La tebaida", "deyBo@gmail.com",
				"24/05/1998", Estudios.AUXILIAR);
		Tripulante auxiliar23 = new Tripulante("5651588888", "Fabianito", "Popa", "La tebaida", "fabiaPo@gmail.com",
				"07/11/1995", Estudios.AUXILIAR);
		tripulaciones[1] = new Tripulacion(piloto2, copiloto2, auxiliar21, auxiliar22, auxiliar23);

		Tripulante piloto3 = new Tripulante("7316949999", "Juanel", "Aguayo", "Armenia", "JuanelG@gmail.com",
				"26/06/1988", Estudios.PILOTO);
		Tripulante copiloto3 = new Tripulante("10058211631", "Albert", "Ochoa Soliz", "Calle 12 #4-02",
				"albertrO@gmai.com", "29/07/1980", Estudios.COPILOTO);
		Tripulante auxiliar31 = new Tripulante("1558456161", "David", "Jacobo", "Calle 12 # 456", "Djacobo@gmail.com",
				"31/01/1970", Estudios.AUXILIAR);
		Tripulante auxiliar32 = new Tripulante("1251519163", "Yefrey", "Piamba", "La tebaida", "yefryP@gmail.com",
				"24/05/1998", Estudios.AUXILIAR);
		Tripulante auxiliar33 = new Tripulante("561895163187", "Cristian", "Miranda", "La tebaida",
				"mirandaxd@gmail.com", "07/11/1995", Estudios.AUXILIAR);
		tripulaciones[2] = new Tripulacion(piloto3, copiloto3, auxiliar31, auxiliar32, auxiliar33);

		Tripulante piloto4 = new Tripulante("8884898484", "Juanello", "Aguayo", "Armenia", "JuanelG@gmail.com",
				"26/06/1988", Estudios.PILOTO);
		Tripulante copiloto4 = new Tripulante("1419511444", "Albertencio", "Ochoa Soliz", "Calle 12 #4-02",
				"albertrO@gmai.com", "29/07/1980", Estudios.COPILOTO);
		Tripulante auxiliar41 = new Tripulante("9892942545", "Cesar", "Jacobo", "Calle 12 # 456", "Djacobo@gmail.com",
				"31/01/1970", Estudios.AUXILIAR);
		Tripulante auxiliar42 = new Tripulante("87168418945", "Roviro", "Piamba", "La tebaida", "yefryP@gmail.com",
				"24/05/1998", Estudios.AUXILIAR);
		Tripulante auxiliar43 = new Tripulante("5546565564", "Diana", "Miranda", "La tebaida", "mirandaxd@gmail.com",
				"07/11/1995", Estudios.AUXILIAR);
		tripulaciones[3] = new Tripulacion(piloto4, copiloto4, auxiliar41, auxiliar42, auxiliar43);

		Tripulante piloto5 = new Tripulante("622562562565", "Diana", "Carolina", "Armenia", "JDianaC@gmail.com",
				"26/06/1988", Estudios.PILOTO);
		Tripulante copiloto5 = new Tripulante("9401581818", "Juan Pablo", "Ocampo", "Calle 12 #4-02",
				"juanpaOcam@gmai.com", "29/07/1980", Estudios.COPILOTO);
		Tripulante auxiliar51 = new Tripulante("9892662552", "Esteban", "Sanchez", "Calle 12 # 456", "EsSanc@gmail.com",
				"31/01/1970", Estudios.AUXILIAR);
		Tripulante auxiliar52 = new Tripulante("8616081851", "Diego", "Profe", "La tebaida", "DiegoP@gmail.com",
				"24/05/1998", Estudios.AUXILIAR);
		Tripulante auxiliar53 = new Tripulante("56062626316", "Diana", "Ramirez", "La tebaida", "dianaR@gmail.com",
				"07/11/1995", Estudios.AUXILIAR);
		tripulaciones[4] = new Tripulacion(piloto5, copiloto5, auxiliar51, auxiliar52, auxiliar53);

		Tripulante piloto6 = new Tripulante("1002513321", "Diana", "Montoya", "Armenia", "JDianaM@gmail.com",
				"26/06/1988", Estudios.PILOTO);
		Tripulante copiloto6 = new Tripulante("9826248125", "Juan", "Carmona", "Calle 12 #4-02", "juanCar@gmai.com",
				"29/07/1980", Estudios.COPILOTO);
		Tripulante auxiliar61 = new Tripulante("963265414", "Rigoberto", "Sanchez", "Calle 12 # 456",
				"EsSanc@gmail.com", "31/01/1970", Estudios.AUXILIAR);
		Tripulante auxiliar62 = new Tripulante("861601748484", "Brian", "Piedrahita", "La tebaida", "brianP@gmail.com",
				"24/05/1998", Estudios.AUXILIAR);
		Tripulante auxiliar63 = new Tripulante("55516516316", "Diana", "Jaramillo", "La tebaida", "dianaJ@gmail.com",
				"07/11/1995", Estudios.AUXILIAR);
		tripulaciones[5] = new Tripulacion(piloto6, copiloto6, auxiliar61, auxiliar62, auxiliar63);

	}

	/**
	 * Método que crea todos los trayectos a los cuales estarán asignados determinados números de vuelos.
	 */
	public void inicializarTrayectos() {
		trayectos = new Trayecto[12];
		trayectos[0] = new Trayecto("México (Ciudad de méxico)", "México (Monterrey)");
		trayectos[0].setDuracionMin(165);
		trayectos[0].setTripulacion(tripulaciones[0]);

		trayectos[1] = new Trayecto("México (Ciudad de méxico)", "México (Cancún)");
		trayectos[1].setDuracionMin(192);
		trayectos[1].setTripulacion(tripulaciones[1]);

		trayectos[2] = new Trayecto("México (Ciudad de méxico)", "Argentina (Buenos Aires)");
		trayectos[2].setDuracionMin(545);
		trayectos[2].setTripulacion(tripulaciones[2]);

		trayectos[3] = new Trayecto("México (Ciudad de méxico)", "Estados Unidos (Los Ángeles)");
		trayectos[3].setDuracionMin(205);
		trayectos[3].setTripulacion(tripulaciones[3]);

		trayectos[4] = new Trayecto("México (Ciudad de méxico)", "Colombia (Bogotá)");
		trayectos[4].setDuracionMin(225);
		trayectos[4].setTripulacion(tripulaciones[4]);

		trayectos[5] = new Trayecto("México (Ciudad de méxico)", "Republica de Panamá (Panamá)");
		trayectos[5].setDuracionMin(175);
		trayectos[5].setTripulacion(tripulaciones[5]);

		trayectos[6] = new Trayecto("México (Monterrey)", "México (Ciudad de méxico)");
		trayectos[6].setDuracionMin(165);
		trayectos[6].setTripulacion(tripulaciones[0]);

		trayectos[7] = new Trayecto("México (Cancún)", "México (Ciudad de méxico)");
		trayectos[7].setDuracionMin(192);
		trayectos[7].setTripulacion(tripulaciones[1]);

		trayectos[8] = new Trayecto("Argentina (Buenos Aires)", "México (Ciudad de méxico)");
		trayectos[8].setDuracionMin(545);
		trayectos[8].setTripulacion(tripulaciones[2]);

		trayectos[9] = new Trayecto("Estados Unidos (Los Angeles)", "México (Ciudad de méxico)");
		trayectos[9].setDuracionMin(205);
		trayectos[9].setTripulacion(tripulaciones[3]);

		trayectos[10] = new Trayecto("Colombia (Bogotá)", "México (Ciudad de méxico)");
		trayectos[10].setDuracionMin(225);
		trayectos[10].setTripulacion(tripulaciones[4]);

		trayectos[11] = new Trayecto("Republica de Panamá (Panamá)", "México (Ciudad de méxico)");
		trayectos[11].setDuracionMin(175);
		trayectos[11].setTripulacion(tripulaciones[5]);

	}

	/**
	 * Método que crea todos los vuelos que van a estar disponibles en la aerolinea.
	 */
	public void inicializarVuelos() {
		misVuelos = new ArrayList<Vuelo>();

		Date fecha1 = new Date();
		for (int i = 0; i < 30; i++) {
			if (i == 0) {
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha1), "6:00", "13000", Tipo.NACIONAL,
						trayectos[0]));
			} else {
				fecha1 = Util.sumarDiasFecha(fecha1, 1);
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha1), "6:00", "13000", Tipo.NACIONAL,
						trayectos[0]));
				
				
				
			}

		}

		Date fecha2 = new Date();
		for (int i = 0; i < 30; i++) {
			if (i == 0) {
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha2), "8:00", "150000", Tipo.NACIONAL,
						trayectos[1]));
			} else {
				fecha2 = Util.sumarDiasFecha(fecha2, 1);
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha2), "8:00", "150000", Tipo.NACIONAL,
						trayectos[1]));
			}

		}

		Date fecha3 = new Date();
		for (int i = 0; i < 30; i++) {
			if (i == 0) {
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha3), "23:30", "500000",
						Tipo.INTERNACIONAL, trayectos[2]));
			} else {
				fecha3 = Util.sumarDiasFecha(fecha3, 1);
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha3), "11:30", "500000",
						Tipo.INTERNACIONAL, trayectos[2]));
			}

		}

		Date fecha4 = new Date();
		for (int i = 0; i < 30; i++) {
			if (i == 0) {
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha4), "9:45", "30000",
						Tipo.INTERNACIONAL, trayectos[3]));
			} else {
				fecha4 = Util.sumarDiasFecha(fecha4, 1);
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha4), "9:45", "30000",
						Tipo.INTERNACIONAL, trayectos[3]));
			}

		}

		Date fecha5 = new Date();
		for (int i = 0; i < 30; i++) {
			if (i == 0) {
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha5), "13:30", "250000",
						Tipo.INTERNACIONAL, trayectos[4]));
			} else {
				fecha5 = Util.sumarDiasFecha(fecha5, 1);
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha5), "13:30", "250000",
						Tipo.INTERNACIONAL, trayectos[4]));
			}

		}

		Date fecha6 = new Date();
		for (int i = 0; i < 30; i++) {
			if (i == 0) {
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha6), "14:45", "300000",
						Tipo.INTERNACIONAL, trayectos[5]));
			} else {
				fecha6 = Util.sumarDiasFecha(fecha6, 1);
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha6), "14:45", "300000",
						Tipo.INTERNACIONAL, trayectos[5]));
			}

		}

		Date fecha7 = new Date();
		for (int i = 0; i < 30; i++) {
			if (i == 0) {
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha7), "11:45", "13000", Tipo.NACIONAL,
						trayectos[6]));
			} else {
				fecha7 = Util.sumarDiasFecha(fecha7, 1);
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha7), "11:45", "13000", Tipo.NACIONAL,
						trayectos[6]));
			}

		}

		Date fecha8 = new Date();
		for (int i = 0; i < 30; i++) {
			if (i == 0) {
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha8), "14:12", "150000", Tipo.NACIONAL,
						trayectos[7]));
			} else {
				fecha8 = Util.sumarDiasFecha(fecha8, 1);
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha8), "14:12", "150000", Tipo.NACIONAL,
						trayectos[7]));
			}

		}

		Date fecha9 = new Date();
		for (int i = 0; i < 30; i++) {
			if (i == 0) {
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha9), "12:00", "500000",
						Tipo.INTERNACIONAL, trayectos[8]));
			} else {
				fecha9 = Util.sumarDiasFecha(fecha9, 1);
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha9), "12:00", "500000",
						Tipo.INTERNACIONAL, trayectos[8]));
			}

		}

		Date fecha10 = new Date();
		for (int i = 0; i < 30; i++) {
			if (i == 0) {
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha10), "16:10", "30000",
						Tipo.INTERNACIONAL, trayectos[9]));
			} else {
				fecha10 = Util.sumarDiasFecha(fecha10, 1);
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha10), "16:10", "30000",
						Tipo.INTERNACIONAL, trayectos[9]));
			}

		}

		Date fecha11 = new Date();

		for (int i = 0; i < 30; i++) {
			if (i == 0) {
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha11), "20:15", "250000",
						Tipo.INTERNACIONAL, trayectos[10]));
			} else {
				fecha11 = Util.sumarDiasFecha(fecha11, 1);
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha11), "20:15", "250000",
						Tipo.INTERNACIONAL, trayectos[10]));
			}

		}

		Date fecha12 = new Date();
		for (int i = 0; i < 30; i++) {
			if (i == 0) {
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha12), "20:40", "300000",
						Tipo.INTERNACIONAL, trayectos[11]));
			} else {
				fecha12 = Util.sumarDiasFecha(fecha12, 1);
				misVuelos.add(new Vuelo(new Avion(), Util.convertirFechaAString(fecha12), "20:40", "300000",
						Tipo.INTERNACIONAL, trayectos[11]));
			}

		}

	}

	
	/**
	 * Método que permite identificar el vuelo deseado por el cliente.
	 * @param trayecto El parámetro trayecto representa al trayecto designado por el usuario.
	 * @param fecha El parámetro fecha representa a la fecha en la cual el usuario desea buscar el vuelo.
	 * @return Retorna la lista de vuelos que cumplan con las condiciones establecidas por el usuario.
	 */
	public ArrayList<Vuelo> buscarVuelo(Trayecto trayecto, String fecha) {
		ArrayList<Vuelo> vuelosEncontrado = new ArrayList<Vuelo>();
		
		String origenVuelo;
		String origenBusqueda;
		String destinoVuelo;
		String destinoBusqueda;
		Vuelo miV;
		for (int i = 0; i < misVuelos.size(); i++) {
			 miV = misVuelos.get(i);
			if (miV.getFecha().equals(fecha)) {

				origenVuelo = miV.getTrayecto().getOrigen();
				origenBusqueda = trayecto.getOrigen();
				destinoVuelo = miV.getTrayecto().getDestino();
				destinoBusqueda = trayecto.getDestino();
				if (origenBusqueda.equals(origenVuelo) && destinoBusqueda.equals(destinoVuelo)) {
					vuelosEncontrado.add(miV);
				}

			}

		}

		return vuelosEncontrado;
	}
	
	/**
	 * Devuelve el número de la factura
	 * @return
	 */
public int getNumeroFactura()
{
	return numeroFactura;
}

/**
 * Permite actualizar el número de la próxima factura
 * @param numero
 */
public void setNumeroFactura(int numero)
{
	this.numeroFactura = numero;
}
	/**
	 * Método que permite obtener el vuelo seleccionado por el usuario dentro de la lista de vuelos.
	 * @param pVuelo El parámetro pVuelo representa al vuelo que fue seleccionado por el usuario.
	 * @param horaSalida El parámetro horaSalida representa a la hora de salida deseada por el usuario.
	 * @return Retorna el vuelo que cumpla con las condiciones establecidas por el usuario.
	 */
	public Vuelo getVueloSeleccionado(Vuelo pVuelo, String horaSalida) {
		Vuelo vueloSeleccionado = null;
		Vuelo miV;
		String fechaVuelo;
		String origenVuelo;
		String origenBusqueda;
		String destinoVuelo;
		String destinoBusqueda;
		String horaSalidaVuelo;
		boolean centinela = false;
		for (int i = 0; i < misVuelos.size() && centinela == false; i++) {
		    miV = misVuelos.get(i);
			fechaVuelo = pVuelo.getFecha();
			if (miV.getFecha().equals(fechaVuelo)) {

				 origenVuelo = miV.getTrayecto().getOrigen();
				 origenBusqueda = pVuelo.getTrayecto().getOrigen();
				 destinoVuelo = miV.getTrayecto().getDestino();
				 destinoBusqueda = pVuelo.getTrayecto().getDestino();
				if (origenBusqueda.equals(origenVuelo) && destinoBusqueda.equals(destinoVuelo)) {
					horaSalidaVuelo = miV.getHoraSalida();
					if (horaSalidaVuelo.equals(horaSalida)) {
						vueloSeleccionado = miV;
						centinela = true;
					}
				}

			}

		}

		return vueloSeleccionado;
	}
	
	/**
	 * Método que permite determinar la cantidad de pasajeros que han viajado a un determinado trayecto (Origen - destino).
	 * @param trayecto Representa el trayecto en el cual se buscarán los pasajeros.
 	 * @return Retorna la cantidad de pasajeros encontrados.
	 */
	public int cantPasajerosTrayecto(Trayecto trayecto)
	{
		String origen = trayecto.getOrigen();
		String destino = trayecto.getDestino();
		String origenVuelo;
		String destinoVuelo;
		Vuelo vuelo;
		int cantidad=0;
		for(int i=0;i<registrosVuelosPorPasajeroAerolinea.size();i++)
		{
			  vuelo = registrosVuelosPorPasajeroAerolinea.get(i).getVuelo();
			 origenVuelo = vuelo.getTrayecto().getOrigen();
			 destinoVuelo = vuelo.getTrayecto().getDestino();
			if(origenVuelo.equals(origen) && destinoVuelo.equals(destino))
			{
				cantidad++;
			}
			
		}
		
		return cantidad;
	}
	
	/**
	 * Método que permite obtener la cantidad de dinero recaudado para un sólo trayecto.
	 * @param trayecto Representa al trayecto en el cuál se buscará el consolidado.
	 * @return Retorna el dinero.
	 */
	public int cantPagosRealizadosTrayecto (Trayecto trayecto)
	{
		int pagoRealizado=0;
		String origen = trayecto.getOrigen();
		String destino = trayecto.getDestino();
		String origenVuelo;
		String destinoVuelo;
		for(int i=0;i<dineroRecaudado.size();i++)
		{
			 origenVuelo = dineroRecaudado.get(i).getVuelo().getTrayecto().getOrigen();
			 destinoVuelo = dineroRecaudado.get(i).getVuelo().getTrayecto().getDestino();
			if(origenVuelo.equals(origen) && destinoVuelo.equals(destino))
			{
				pagoRealizado = pagoRealizado + dineroRecaudado.get(i).getDinero();
			}
		}
		
		return pagoRealizado;
				
	}
	
	/**
	 * Método que permite obtener todos los vuelos realizados por un pasajero en la historia de la aerolinea.
	 * @param pasajero Representa al pasajero.
	 * @return retorna los vuelos encontrados,
	 */
	public ArrayList<Vuelo> vuelosRealizados(Pasajero pasajero)
	{
		Pasajero pasajero1;
		ArrayList<Vuelo> vuelos= new ArrayList<Vuelo>();
		for(int i=0;i<registrosVuelosPorPasajeroAerolinea.size();i++)
		{
			pasajero1 = registrosVuelosPorPasajeroAerolinea.get(i).getPasajero();
			if(pasajero1.getId().equals(pasajero.getId()))
			{
				vuelos.add(registrosVuelosPorPasajeroAerolinea.get(i).getVuelo());
			}
		}
		
		
		return vuelos;
	}
	
	/**
	 * Método que permite obtener todo el dinero recaudado por kilos adicionales en la historia de la aerolinea.
	 * @return Retorna el dinero recaudado.
	 */
	public int dineroRecaudadoKilosAdiciones()
	{
		int dinero=0;
		int dineroActual=0;
		for(int i=0;i<kilosAdicionales.size();i++)
		{
			dineroActual = kilosAdicionales.get(i) * 5000;
			dinero = dinero + dineroActual;
		}
		
		return dinero;
	}
	
	
	/**
	 * Método que permite convertir una cadena a un dato tipo Date
	 * @param fecha Representa a la fecha que va a ser convertida
	 * @return Retorna la nueva fecha
	 */
	public Date convertirStringADate(String fecha)
	{
		Date nuevaFecha = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			nuevaFecha = formatter.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return nuevaFecha;
		
	}
	

	/**
	 * Método que permite obtener todo el dinero recaudado en un mes especificado por el usuario
	 * @param mes Representa el mes donde se quieren buscar los consolidados
	 * @return Retorna el dinero recaudado
	 */
	public int dineroRecaudadoMes (int mes)
	{
		int dinero=0;
		int mesActual;
		for(int i=0;i<dineroRecaudado.size();i++)
		{
			mesActual = Util.sacarMesDate(dineroRecaudado.get(i).getFecha());
			if(mesActual == mes)
			{
				dinero = dinero +  dineroRecaudado.get(i).getDinero();
			}
		}
		
		return dinero;
	}
	
	
	
	/**
	 * Método que permite obtener el destino al que más viajan en orden de mayor a menor.
	 * @param fecha
	 * @return
	 */
	public String[] destinoAlQueMasViajan(String fecha)
	{
		String [] destinos = inicializarDestinos();
		int[] veces = vecesHechas(fecha);
		return ordenarString(destinos, veces);
	}
	
	/**
	 * Método que permite ordenar un arreglo de cadenas con respecto al arreglo de veces escogidas
	 * @param destinos
	 * @param vecesEscogidas
	 * @return
	 */
	public String[] ordenarString(String[] destinos, int[] vecesEscogidas)
	{
		int AuxVeces;
		String auxString;
		for(int i = 0; i < vecesEscogidas.length; i++){
			for(int j=i+1; j < vecesEscogidas.length; j++){
				if(vecesEscogidas[i] < vecesEscogidas[j]){
					AuxVeces = vecesEscogidas[i];
					vecesEscogidas[i] = vecesEscogidas[j];
					vecesEscogidas[j] = AuxVeces;
					
					auxString = destinos[i];
					destinos[i] = destinos[j];
					destinos[j] = auxString;
				}
			}
		}
		
		return destinos;
	}
	
	/**
	 * Método que permite determinar la cantidad de vuelos que se han hecho a un determinado destino.
	 * @param fecha
	 * @return
	 */
	public int[] vecesHechas(String fecha)
	{
		
		int[] destinos = new int[7];
		int contadorCDMX = 0, contadorMonterrey=0, contadorCancun =0, contadorBuenosAires =0, contadorLA =0, contadorBogota=0, contadorPanama=0;
		Date fechaLlega = convertirStringADate(fecha);
		Vuelo vuelo;
		Trayecto trayecto;
		Date fechaActual;
		for(int i=0;i<registrosVuelosPorPasajeroAerolinea.size();i++)
		
		{
			vuelo = registrosVuelosPorPasajeroAerolinea.get(i).getVuelo();
			trayecto = vuelo.getTrayecto();
			fechaActual = convertirStringADate(vuelo.getFecha());
			if(fechaActual.compareTo(fechaLlega) <0)
			{
				if(trayecto.getDestino().equals("México (Monterrey)"))
				{
					contadorMonterrey++;
				}
				if(trayecto.getDestino().equals("México (Ciudad de méxico)"))
				{
					contadorCDMX++;
				}
		
				if(trayecto.getDestino().equals("México (Cancún)"))
				{
					contadorCancun++;
				}
			
				if(trayecto.getDestino().equals("Argentina (Buenos Aires)"))
				{
					contadorBuenosAires++;
				}
			
				if(trayecto.getDestino().equals("Estados Unidos (Los Angeles)"))
				{
					contadorLA++;
				}
			
				if(trayecto.getDestino().equals( "Colombia (Bogotá)"))
				{
					contadorBogota++;
				}
			
				if(trayecto.getDestino().equals("Republica de Panamá (Panamá)"))
				{
					contadorPanama++;
				}
			}
			
			destinos[0] = contadorMonterrey;
			destinos[1] = contadorCDMX;
			destinos[2] = contadorCancun;
			destinos[3] = contadorBuenosAires;
			destinos[4] = contadorLA;
			destinos[5] = contadorBogota;
			destinos[6] = contadorPanama;
			
		}
		
		return destinos;
	}
	
	public String[] inicializarDestinos()
	{
		String[] destinos = new String[7];
		destinos[0] = "México (Monterrey)";
		destinos[1] = "México (Ciudad de méxico)";
		destinos[2] = "México (Cancún)";
		destinos[3] = "Argentina (Buenos Aires)";
		destinos[4] = "Estados Unidos (Los Angeles)";
		destinos[5] = "Colombia (Bogotá)";
		destinos[6] = "Republica de Panamá (Panamá)";
		
		
		return destinos;
	}

	/**
	 * Método que permite verificar si la cédula ingresada pertenece a algún pasajero
	 * @param cedula
	 * @return
	 */
	public boolean PasajeroExist(String cedula)
	{
		boolean exist=false;
		Pasajero pasajero;
		for(int i=0;i<registrosVuelosPorPasajeroAerolinea.size() && exist==false;i++)
		{
			pasajero = registrosVuelosPorPasajeroAerolinea.get(i).getPasajero();
			if(pasajero.getId().equals(cedula))
			{
				exist=true;
			}
		}
		
		return exist;
	}
	
	/**
	 * Método que permite obtener al pasajero al cual le pertenece la cédula ingresada como parámetro.
	 * @param cedula
	 * @return
	 */
	public Pasajero pasajeroCedula(String cedula)
	{
		boolean centinela = false;
		Pasajero pasajero=null;
		Pasajero pasajeroCon;
		for(int i=0;i<registrosVuelosPorPasajeroAerolinea.size() && centinela == false;i++)
		{
			if(PasajeroExist(cedula) == true)
			{
				pasajeroCon = registrosVuelosPorPasajeroAerolinea.get(i).getPasajero();
				if(pasajeroCon.getId().equals(cedula))
				{
					pasajero = pasajeroCon;
					centinela = true;
				}
			}
			else
			{
				centinela = true;
			}
			
		}
		
		return pasajero;
	}
	
	/**
	 * Método que permite obtener la lista de trayectos de la aerolinea.
	 * @return
	 */
	public Trayecto[] getTrayectos() {
		return trayectos;
	}

	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}

	public void setTrayectos(Trayecto[] trayectos) {
		this.trayectos = trayectos;
	}

	public void setTripulaciones(Tripulacion[] tripulaciones) {
		this.tripulaciones = tripulaciones;
	}

	public void setMisVuelos(ArrayList<Vuelo> misVuelos) {
		this.misVuelos = misVuelos;
	}
	
}
