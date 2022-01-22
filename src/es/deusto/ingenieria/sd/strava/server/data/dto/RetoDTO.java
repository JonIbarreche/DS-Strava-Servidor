package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.io.Serializable;
import java.util.Date;
//This class implements DTO pattern
public class RetoDTO implements Serializable {

	//This attribute is needed to implement the "Serializable" interface.
	private static final long serialVersionUID = 1L;
	private String nombreReto;
	private Date fechaIni;
	private Date fechaFin;
	private float distancia;
	private int tiempo;
	private String deporte;
	
	
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
	
	
}
