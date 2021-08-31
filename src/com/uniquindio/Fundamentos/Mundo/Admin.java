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
private String contraseña;

/**
 * Constructor para el administrador
 * @param usuario El parámetro usuario define al usuario con el que el administrador deberá entrar en la ventana de inicio de sesión.
 * @param contraseña El parámetro contraseña define a la contraseña con la que el administrador deberá entrar en la ventana de inicio de sesión.
 */
public Admin(String usuario, String contraseña) {
	super();
	this.usuario = usuario;
	this.contraseña = contraseña;
}

/**
 * Método que devuelve el usuario del administrador.
 * @return Retorna el usuario del administrador.
 */
public String getUsuario() {
	return usuario;
}

/**
 * Método que devuelve la contraseña del administrador.
 * @return Retorna la contraseña del administrador.
 */
public String getContraseña() {
	return contraseña;
}

}
