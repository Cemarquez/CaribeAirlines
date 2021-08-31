package com.uniquindio.Fundamentos.Util;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class Util {
	/**
	 * M�todo que permite convertir un objeto de tipo Date a String.
	 * @param fecha El par�metro fecha representa a la fecha la cual se va a convertir a String.
	 * @return Retorna el String con la fecha.
	 */
	public static String convertirFechaAString(Date fecha) {
		String nuevaFecha = "";
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(fecha); // Configuramos la fecha que se recibe

		int ano = calendar.get(Calendar.YEAR);
		int mes = calendar.get(Calendar.MONTH);
		int dia = calendar.get(Calendar.DAY_OF_MONTH);
		nuevaFecha = dia + "/" + mes + "/" + ano;

		return nuevaFecha;
	}

	/**
	 * M�todo que permite sumar determinado n�mero de d�as a una fecha.
	 * @param fecha El par�metro fecha representa a la fecha a la cual se le a�adir�n los d�as establecidos por el usuario.
	 * @param dias El par�metro d�as repesentas los d�as que ser�n a�adidos a la fecha.
	 * @return Retorna la nueva fecha con los d�as ya agregados.
	 */
	public static Date sumarDiasFecha(Date fecha, int dias) {

		Date fechaa = new Date();

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(fecha); // Configuramos la fecha que se recibe

		calendar.add(Calendar.DAY_OF_YEAR, dias); // numero de d�as a a�adir, o restar en caso de d�as<0

		fechaa = calendar.getTime();

		return fechaa;
	}
	
	/**
	 * M�todo que permite hallar el disco principal del sistema
	 * @return Retorna en un String el disco principal del sistema, por ejemplo, C:/
	 */
	public static String disco() {
    	String dp = System.getProperty("user.home");
    	dp = dp.substring(0, 1);
    	dp = dp + ":" + '/';
    	return dp;
    }
	
	/**
	 * M�todo que permite convertir cierta cantidad de minutos a horas.
	 * @param minutos Representan los minutos que van a ser convertidos.
	 * @return Retorna la hora.
	 */
	public static String convertirMinutosAHora(int minutos)
	{
		String conversion="";
		float number;
		number = (float)minutos/60;

		String str = ""+ number;

		BigDecimal numero = new BigDecimal(number);
		 long intNumber = numero.longValue();
		 BigDecimal fraccion = numero.remainder(BigDecimal.ONE);
		 int num = (int) (fraccion.floatValue() * 60);
       
		conversion = intNumber + "h"+num+"m";
	
		return conversion;
	}
	
	
	/**
	 * M�todo que permite obtener el valor entero de un mes 
	 * @param fecha Representa la fecha.	
	 * @return Retorna el valor entero del mes
	 */
	public static int sacarMesDate(Date fecha)
	{
		int mes;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); // Configuramos la fecha que se recibe
		mes = calendar.get(Calendar.MONTH);
		return mes;
	}
	
	/**
	 * M�todo que permite sumar cierta cantidad de minutos a una hora dada en String
	 * @param hora Hora inicial
	 * @param minutos Minutos a sumar
	 * @return Nueva hora
	 */
	public static String sumarHoras(String hora, int minutos) {
		String nuevaHora = "";
		int hora1 = Integer.parseInt(hora.substring(0, hora.indexOf(':')));
		int minuto1 = Integer.parseInt(hora.substring(hora.indexOf(':') + 1));

		float number;
		number = (float) minutos / 60;

		String str = "" + number;

		BigDecimal numero = new BigDecimal(number);
		int hora2 = numero.intValue();
		BigDecimal fraccion = numero.remainder(BigDecimal.ONE);
		int minuto2 = (int) (fraccion.floatValue() * 60);
		int contador = 0;

		int nuevoMinutos = 0;
		int nuevoHora;
		if (minuto1 + minuto2 > 60) {
			contador++;
			nuevoMinutos = (minuto1 + minuto2) - 60;
		} else {
			nuevoMinutos = minuto1 + minuto2;
		}
		nuevoHora = hora1 + hora2 + contador;

		nuevaHora = nuevoHora + ":" + nuevoMinutos;

		return nuevaHora;
	}
	
	
	/**
	 * M�todo que permite leer s�lo los n�meros de un String, descartando los caracteres
	 * @param numero String a convertir
	 * @return Retorna el n�mero
	 */
	public static int leerEnteros(String numero)
	{
		int numeros;
		String aux = "";
		char caracteres[] = numero.toCharArray();
		
		for(int i = 0; i<caracteres.length; i++ )
		{
			if(isNumero(caracteres[i]))
			{
				aux += caracteres[i];
			}
		}
		
		numeros = Integer.parseInt(aux);
		
		return numeros;
	}
	
	
	/**
	 * M�todo que permite verificar si un char ingresado es un n�mero.
	 * @param num Char a verificar	
	 * @return true si lo es y false en caso contrario
	 */
	public static boolean isNumero(char num)
	{
		boolean centinela = false;
		
		try {
			Integer.parseInt(num + "");
			centinela = true;
			
		} catch (NumberFormatException e) {
			centinela = false;
		}
		
		
		return centinela;
		
	}
	
	/**
	 * M�todo que permite verificar si un String ingresado es un n�mero.
	 * @param num String a verificar
	 * @return true si lo es y false en caso contrario
	 */
	public static boolean isNumeroString(String num)
	{
		boolean centinela = false;
		
		try {
			Integer.parseInt(num);
			centinela = true;
			
		} catch (NumberFormatException e) {
			centinela = false;
		}
		
		
		return centinela;
	}
	

}
