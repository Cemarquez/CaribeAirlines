package com.uniquindio.Fundamentos.MailSender;

import java.io.Serializable;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

@SuppressWarnings("serial")
public class MailSender implements Serializable
{
	
	private String usuario;
	private String contraseña;
    private String mensaje;
    private String remitente;
    private String asunto;
    
	public MailSender() 
	{
		super();
		this.usuario  = "airlines.caribe.mx@gmail.com";
		this.contraseña = "caribe123456";
	}

	public String getUsuario() 
	{
		return usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public String getMensaje() {
		return mensaje;
	}

	public String getRemitente() {
		return remitente;
	}

	public String getAsunto() {
		return asunto;
	}

    public void enviarCorreoBienvenida(String remitente, String datos) 
    {
    	mensaje = "¡Te has registrado exitosamente!" + "\n\n"+ datos+"\n\n"+ "Dirigete a nuestra página para buscar el vuelo que mas se acomode a tus gustos." + "\n\n" + "Gracias por preferirnos.";
        asunto = "Caribe Airlines ¡Bienvenido Viajero!";
        
    	Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", 587);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(usuario, contraseña);
                        
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuario));
            message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(remitente));
            message.setSubject(asunto);
            message.setText(mensaje);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void enviarCorreoCompra(String remitente, String ruta, String nombreFile) 
    {
    	mensaje = "¡Compra Exitosa!" + "\n\n"+ "Te deseamos un feliz viaje, sigue disfrutando de nuestros servicios en nuestra página, también podrás observar todas tus facturas de los vuelos realizados" + "\n\n" + "Gracias por preferirnos. Factura adjunta.";
        asunto = "Caribe Airlines ¡Disfruta tu viaje!";
        
        
    	Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", 587);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(usuario, contraseña);
                        
                    }
                });

        try {

        	BodyPart adjunto = new MimeBodyPart();
        	BodyPart texto = new MimeBodyPart();
        	adjunto.setDataHandler(new DataHandler(new FileDataSource(ruta)));
        	adjunto.setFileName(nombreFile);
        	texto.setText(mensaje);
        	MimeMultipart multiParte = new MimeMultipart();
        	multiParte.addBodyPart(texto);
        	multiParte.addBodyPart(adjunto);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuario));
            message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(remitente));
            message.setSubject(asunto);
            message.setContent(multiParte);
         

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
