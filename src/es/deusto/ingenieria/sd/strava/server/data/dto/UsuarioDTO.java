package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.io.Serializable;

//This class implements DTO pattern
public class UsuarioDTO implements Serializable {

	//This attribute is needed to implement the "Serializable" interface.
	private static final long serialVersionUID = 1L;
	private String email;
	private String nombre;
	private String fecha;
	private String contrasena;
	private int peso;
	private int altura;
	private int max;
	private int rep;
	
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getRep() {
		return rep;
	}
	public void setRep(int rep) {
		this.rep = rep;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
