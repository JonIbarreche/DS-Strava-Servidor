package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.io.Serializable;
//This class implements DTO pattern
public class SesionDTO implements Serializable {

	//This attribute is needed to implement the "Serializable" interface.
	private static final long serialVersionUID = 1L;
	private String titulo;
	private float distancia;
	private String fechaIni;
	private String horaIni;
	private int Duracion;
	
	
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
	public String getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(String fechaIni) {
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
	
	
}
