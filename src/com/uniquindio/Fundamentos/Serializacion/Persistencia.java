package com.uniquindio.Fundamentos.Serializacion;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.uniquindio.Fundamentos.Mundo.Aerolinea;
import com.uniquindio.Fundamentos.Util.Util;


/**
 * Clase para serializar.
 */
public class Persistencia {
	
    /**
     * M�todo para serializar el objeto que entra como p�rametro del mismo.
     * @param pPasajero Objeto a serializar.
     */
	public void serializar (Aerolinea aerolinea)
	{
		try {
			
			FileOutputStream fos = new FileOutputStream(Util.disco() + "CaribeAirlines/Datos/Datos.dat");
			ObjectOutputStream oos =  new ObjectOutputStream(fos);
			oos.writeObject(aerolinea);
			oos.close();
			fos.close();	
		}
		
		
		catch (IOException ioe) 
		{
			ioe.printStackTrace();
		}
		
	}
	
	
	/**	 * M�todo para leer el archivo .dat creado anteriormente por el m�todo serializar y as� poder modificarlo.
	 * @return Retorna un arreglo de pasajeros.
	 */
	public Aerolinea deserializar()
	{

		
		Aerolinea aerolinea = null;
		
		try
		{
		FileInputStream fis = new FileInputStream(Util.disco() + "CaribeAirlines/Datos/Datos.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		aerolinea = (Aerolinea) ois.readObject();
		ois.close();
		fis.close();
	}
	
	catch (IOException ioe) 
	{
		ioe.printStackTrace();
	}
	
	catch (ClassNotFoundException cnfe)
	{
		cnfe.printStackTrace();
	}
		return aerolinea;
	}
	
	
	
}
