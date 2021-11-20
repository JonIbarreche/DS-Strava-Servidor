package es.deusto.ingenieria.sd.strava.server.data.domain;

public class Sesion {
	private String titulo;
	private float distancia;
	private String fechaIni;
	private String horaIni;
	private int Duracion;
	
	public Sesion(String titulo, float distancia, String fechaIni, String horaIni, int duracion) {
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
		this.fechaIni = "";
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

	@Override
	public String toString() {
		return "Sesion [titulo=" + titulo + ", distancia=" + distancia + ", fechaIni=" + fechaIni + ", horaIni="
				+ horaIni + ", Duracion=" + Duracion + "]";
	}
	
	
}
