package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.io.Serializable;
//This class implements DTO pattern
public class RetoDTO implements Serializable {

	//This attribute is needed to implement the "Serializable" interface.
	private static final long serialVersionUID = 1L;
	private String nombreReto;
	private String fechaIni;
	private String fechaFin;
	private float distancia;
	private int tiempo;
	private String deporte;
	
	
	public String getNombreReto() {
		return nombreReto;
	}
	public void setNombreReto(String nombreReto) {
		this.nombreReto = nombreReto;
	}
	public String getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
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
