package es.deusto.ingenieria.sd.strava.server.data.domain;

import java.util.Date;

import javax.jdo.annotations.*;

@PersistenceCapable(detachable="true")
public class Reto {
	@PrimaryKey
	private String nombreReto;
	private Date fechaIni;
	private Date fechaFin;
	private float distancia;
	private int tiempo;
	private String deporte;
	@Persistent(defaultFetchGroup="true")
	private Usuario usuario;
	//Constructor
	public Reto(String nombreReto, Date fechaIni, Date fechaFin, float distancia, int tiempo, String deporte) {
		super();
		this.nombreReto = nombreReto;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.distancia = distancia;
		this.tiempo = tiempo;
		this.deporte = deporte;
	}
	
	public Reto() {
		super();
		this.nombreReto = "";
		this.fechaIni = null;
		this.fechaFin = null;
		this.distancia = 0;
		this.tiempo = 0;
		this.deporte = "";
	}
	//getset
	public String getNombreReto() {
		return nombreReto;
	}
	public void setNombreReto(String nombreReto) {
		this.nombreReto = nombreReto;
	}
	public Date getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public float getDistancia() {
		return distancia;
	}
	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public String getDeporte() {
		return deporte;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	public Usuario getUser() {
		return usuario;
	}

	public void setUser(Usuario user) {
		this.usuario = user;
	}
	//tostring
	@Override
	public String toString() {
		return "Reto [nombreReto=" + nombreReto + ", fechaIni=" + fechaIni + ", fechaFin=" + fechaFin + ", distancia="
				+ distancia + ", tiempo=" + tiempo + ", deporte=" + deporte + "]";
	}
	
}
