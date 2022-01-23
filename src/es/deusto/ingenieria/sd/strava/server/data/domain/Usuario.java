package es.deusto.ingenieria.sd.strava.server.data.domain;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")
public class Usuario {
	@PrimaryKey
	private String email;
	private String nombre;
	private String fecha;
	private int peso;
	private int altura;
	private int max;
	private int rep;
	private Tipo tipo;
	private String contrasena;
	
	@Join
	//This annotation maps the 1-N relationship as an intermediate table.
	@Persistent(mappedBy="usuarios", dependentElement="true", defaultFetchGroup="true")
	//"mappedBy" indicates the name of the attribute defining the relationship at the other end
	//"dependentElement" indicates that the objects in the list are automatically deleted from 
	//the DB when this object is deleted.
	private List<Reto> retos = new ArrayList<>();
	
	@Join
	//This annotation maps the 1-N relationship as an intermediate table.
	@Persistent(mappedBy="usuarios", dependentElement="true", defaultFetchGroup="true")
	//"mappedBy" indicates the name of the attribute defining the relationship at the other end
	//"dependentElement" indicates that the objects in the list are automatically deleted from 
	//the DB when this object is deleted.
	private List<Sesion> sesiones = new ArrayList<>();
	
	public Usuario(String email, String nombre, String fecha, int peso, int altura, int max, int rep, Tipo tipo,
			String contrasena) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.fecha = fecha;
		this.peso = peso;
		this.altura = altura;
		this.max = max;
		this.rep = rep;
		this.tipo = tipo;
		this.contrasena = contrasena;
	}

	public Usuario() {
		super();
		this.email = "";
		this.nombre = "";
		this.fecha = "";
		this.peso = 0;
		this.altura = 0;
		this.max = 0;
		this.rep = 0;
		this.tipo = Tipo.MAIL;
		this.contrasena = "";
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
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

	public List<Reto> getRetos() {
		return retos;
	}
	
	public void setRetos(List<Reto> retos) {
		this.retos = retos;
	}
	
	public void addReto(Reto reto) {
		if (reto != null && !this.retos.contains(reto)) {
			this.retos.add(reto);
		}
	}
	
	public List<Sesion> getSesiones() {
		return sesiones;
	}
	
	public void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}
	
	public void addSesion(Sesion sesion) {
		if (sesion != null && !this.sesiones.contains(sesion)) {
			this.sesiones.add(sesion);
		}
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
	
	public String getContrasena() {
		return contrasena;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nombre=" + nombre + ", fecha=" + fecha 
				+ ", peso=" + peso + ", altura=" + altura + ", max=" + max + ", rep=" + rep + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this.getClass().getName().equals(obj.getClass().getName())) {
			return this.email.equals(((Usuario)obj).getEmail());
		}
		
		return false;
	}
}

