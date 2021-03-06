package es.deusto.ingenieria.sd.strava.server.data.domain;

import java.util.Date;

import javax.jdo.annotations.*;
import java.util.ArrayList;
import java.util.List;


@PersistenceCapable(detachable="true")
public class Sesion {
	@PrimaryKey
	private String titulo;
	private float distancia;
	private Date fechaIni;
	private String horaIni;
	private int Duracion;
	@Join
	@Persistent(mappedBy="sesiones", dependentElement="true", defaultFetchGroup="true")
	private List<Usuario> usuarios = new ArrayList<>();
	
	public Sesion(String titulo, float distancia, Date fechaIni, String horaIni, int duracion) {
		super();
		this.titulo = titulo;
		this.distancia = distancia;
		this.fechaIni = fechaIni;
		this.horaIni = horaIni;
		Duracion = duracion;
	}
	
	public Sesion() {
		super();
		this.titulo = "";
		this.distancia = 0;
		this.fechaIni = null;
		this.horaIni = "";
		Duracion = 0;
	}

	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getDistancia() {
		return distancia;
	}

	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public String getHoraIni() {
		return horaIni;
	}

	public void setHoraIni(String horaIni) {
		this.horaIni = horaIni;
	}

	public int getDuracion() {
		return Duracion;
	}

	public void setDuracion(int duracion) {
		Duracion = duracion;
	}
	
	public List<Usuario> getUsuario() {
		return usuarios;
	}
	
	public void setUsuario(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void addUsuarios(Usuario usuario) {
		if (usuario != null && !this.usuarios.contains(usuario)) {
			this.usuarios.add(usuario);
		}
	}
	
	@Override
	public String toString() {
		return "Sesion [titulo=" + titulo + ", distancia=" + distancia + ", fechaIni=" + fechaIni + ", horaIni="
				+ horaIni + ", Duracion=" + Duracion + "]";
	}
	
	
}
