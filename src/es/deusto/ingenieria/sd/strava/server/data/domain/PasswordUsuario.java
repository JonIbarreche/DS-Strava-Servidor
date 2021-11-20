package es.deusto.ingenieria.sd.strava.server.data.domain;

import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

public class PasswordUsuario extends Usuario{
	private String contrasena;

	
	public PasswordUsuario(String email, String nombre, String fecha, int peso, int altura, int max, int rep,
			String contrasena) {
		super(email, nombre, fecha, peso, altura, max, rep);
		this.contrasena = contrasena;
	}

	public PasswordUsuario() {
		super();
		this.contrasena = "";
	}
	
	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "PasswordUsuario [contrasena=" + contrasena + "]";
	}
	
	
	public boolean checkcontrasena(String password) {
		return this.contrasena.equals(password);
	}

}
