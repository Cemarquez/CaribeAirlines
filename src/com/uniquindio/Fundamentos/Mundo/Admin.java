package com.uniquindio.Fundamentos.Mundo;

import java.io.Serializable;

/**
 * Clase que representa al administrado de la aerolinea.
 * @author Cesar Marquez - Brian Giraldo
 */
@SuppressWarnings("serial")
public class Admin implements Serializable{

//Atributos de la clase
private String usuario;
private String contrase�a;

/**
 * Constructor para el administrador
 * @param usuario El par�metro usuario define al usuario con el que el administrador deber� entrar en la ventana de inicio de sesi�n.
 * @param contrase�a El par�metro contrase�a define a la contrase�a con la que el administrador deber� entrar en la ventana de inicio de sesi�n.
 */
public Admin(String usuario, String contrase�a) {
	super();
	this.usuario = usuario;
	this.contrase�a = contrase�a;
}

/**
 * M�todo que devuelve el usuario del administrador.
 * @return Retorna el usuario del administrador.
 */
public String getUsuario() {
	return usuario;
}

/**
 * M�todo que devuelve la contrase�a del administrador.
 * @return Retorna la contrase�a del administrador.
 */
public String getContrase�a() {
	return contrase�a;
}

}
