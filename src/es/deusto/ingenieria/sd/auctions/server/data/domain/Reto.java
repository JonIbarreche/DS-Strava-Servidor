package es.deusto.ingenieria.sd.auctions.server.data.domain;

public class Reto {
	private String nombreReto;
	private String fechaIni;
	private String fechaFin;
	private float distancia;
	private int tiempo;
	private String deporte;
	
	//Constructor
	public Reto(String nombreReto, String fechaIni, String fechaFin, float distancia, int tiempo, String deporte) {
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
		this.fechaIni = "";
		this.fechaFin = "";
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
	
	//tostring
	@Override
	public String toString() {
		return "Reto [nombreReto=" + nombreReto + ", fechaIni=" + fechaIni + ", fechaFin=" + fechaFin + ", distancia="
				+ distancia + ", tiempo=" + tiempo + ", deporte=" + deporte + "]";
	}
	
}
