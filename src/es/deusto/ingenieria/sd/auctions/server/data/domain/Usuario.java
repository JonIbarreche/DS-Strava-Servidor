package es.deusto.ingenieria.sd.auctions.server.data.domain;

public class Usuario {
	private String email;
	private String nombre;
	private String fecha;
	private String contraseña;
	private int peso;
	private int altura;
	private int max;
	private int rep;
	
	public Usuario(String email, String nombre, String fecha, String contraseña, int peso, int altura, int max,
			int rep) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.fecha = fecha;
		this.contraseña = contraseña;
		this.peso = peso;
		this.altura = altura;
		this.max = max;
		this.rep = rep;
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

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nombre=" + nombre + ", fecha=" + fecha + ", contraseña=" + contraseña
				+ ", peso=" + peso + ", altura=" + altura + ", max=" + max + ", rep=" + rep + "]";
	}
	
}
