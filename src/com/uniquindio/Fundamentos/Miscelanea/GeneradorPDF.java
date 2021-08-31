package com.uniquindio.Fundamentos.Miscelanea;

import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;


import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.uniquindio.Fundamentos.Mundo.Cliente;
import com.uniquindio.Fundamentos.Mundo.Factura;
import com.uniquindio.Fundamentos.Mundo.Vuelo;
import com.uniquindio.Fundamentos.Util.Util;


public class GeneradorPDF {
	
	private static String ruta;
	private static String rutaImagen;
	private static String cabecera;
	private static String contenido;
	private static String piePagina;
	
	private static Font fuenteBold = new Font(Font.FontFamily.COURIER, 18, Font.BOLD);
	private static Font fuenteNormal = new Font(Font.FontFamily.COURIER, 14, Font.NORMAL);
	private static Font fuenteItalic = new Font(Font.FontFamily.COURIER, 12, Font.BOLDITALIC);
	
	
	/**
	 * Método que genera el PDF de la factura
	 * @param factura Factura que va a ser convertida a PDF
	 * @param precioBoletos precio de los boletos
	 * @param precioEquipaje Precio total del equipaje adicional
	 * @param kilosAdicionales Kilos adicionales totales
	 */
	public void crearPDF (Factura factura, int precioBoletos, int precioEquipaje, int kilosAdicionales)
	{
		Vuelo vuelo = factura.getTiquete().getVuelo();
		Cliente miCliente = factura.getCliente();
		ruta = Util.disco() + "CaribeAirlines/Facturas/Factura_" + miCliente.getNombre() +"_" + factura.getNumeroFactura() +  ".pdf";
		
		cabecera = "\n"+"Caribe Airlines S.A " + "\n"+ 
                   "Ciudad de méxico" +  "\n" + 
                   "México" +  "\n" + 
                   "Fecha " + Util.convertirFechaAString(factura.getFecha()) + "\n\n\n";
		contenido = "Factura de venta número: " + factura.getNumeroFactura() +  "\n"+
                	"" + "\n" +  
                	"Nombre del cliente: " +miCliente.getNombre() + " " + miCliente.getApellido()+ "\n" +
                	"Dirección: " +miCliente.getDireccion()+ "\n" +
                	"Cédula: " + miCliente.getCedula()+ "\n" + 
                	"Correo: "+miCliente.getCorreo() + "\n\n\n" + 
                	vuelo.getTrayecto().getOrigen() + "-"+ vuelo.getTrayecto().getDestino() + "\n\n" +
                	"Descripcion															valor" + "\n" + 
                	factura.getPasajeros().size() + " pasajeros"+ "															"  +  precioBoletos + "\n" + 
                	kilosAdicionales + " kilos adicionales" +  "					" + precioEquipaje +"\n\n\n\n";
		piePagina = "TOTAL " + "              " + (precioBoletos + precioEquipaje)+  "\n"    ;
		
		rutaImagen = "src/imagenes/Baner.jpg";
		
		try {
			FileOutputStream archivo = new FileOutputStream(ruta);
			Document doc = new Document(PageSize.A5, 10, 10, 10, 10);
			PdfWriter.getInstance(doc, archivo);
			doc.open();
			com.itextpdf.text.Image imagen = com.itextpdf.text.Image.getInstance(rutaImagen);
			imagen.scaleAbsolute(400, 75);
			imagen.setAlignment(Element.ALIGN_LEFT);
			doc.add(imagen);
			doc.add(obtenerCabecera(cabecera));
			doc.add(obtenerContenido(contenido));
			doc.add(obtenerPiePagina(piePagina));
			doc.close();
			
		}
		catch (Exception e) {
			System.out.println("" +  e);
		}
	
		
	}
	
	/**
	 * Método que obtiene la cabecera
	 * @param texto
	 * @return
	 */
	private static Paragraph obtenerCabecera(String texto)
	{
		Paragraph p = new Paragraph();
		Chunk c = new Chunk();
		p.setAlignment(Element.ALIGN_LEFT);
		c.append(texto);
		c.setFont(fuenteItalic);
		p.add(c);
		
		return p;
	}
	
	private static Paragraph obtenerContenido(String texto)
	{
		Paragraph p = new Paragraph();
		Chunk c = new Chunk();
		p.setAlignment(Element.ALIGN_LEFT);
		c.append(texto);
		c.setFont(fuenteNormal);
		p.add(c);
		
		return p;
	}
	
	private static Paragraph obtenerPiePagina(String texto)
	{
		Paragraph p = new Paragraph();
		Chunk c = new Chunk();
		p.setAlignment(Element.ALIGN_LEFT);
		c.append(texto);
		c.setFont(fuenteBold);
		p.add(c);
		
		return p;
	}
	
	public static String getRuta() {
		return ruta;
	}
	
	
}
