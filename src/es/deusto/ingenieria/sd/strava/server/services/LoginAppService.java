package es.deusto.ingenieria.sd.strava.server.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.deusto.ingenieria.sd.strava.external.ExternalLogin;
import es.deusto.ingenieria.sd.strava.external.LoginFactory;
import es.deusto.ingenieria.sd.strava.server.data.domain.PasswordUsuario;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;
import es.deusto.ingenieria.sd.strava.server.data.domain.Tipo;


//TODO: Implement Singleton Pattern
public class LoginAppService {
	
	List<Usuario> usuarios = new ArrayList<>();

	List<ExternalLogin> loginGateways = new ArrayList<>();
	
	public LoginAppService() {
		this.InitializeData();
	}
	
	private void InitializeData() {
		PasswordUsuario pU0 = new PasswordUsuario();
		pU0.setNombre("Thomas");
		pU0.setAltura(167);
		pU0.setContrasena("iwhioqq12");
		pU0.setEmail("thomas.e2001@gmail.com");
		pU0.setFecha("8 de agosto");
		pU0.setMax(10);
		pU0.setPeso(80);
		pU0.setRep(10);
		pU0.setTipo(Tipo.MAIL);
		
		PasswordUsuario pU1 = new PasswordUsuario();
		pU1.setNombre("Eva");
		pU1.setAltura(184);
		pU1.setContrasena("abc123");
		pU1.setEmail("eva@gmail.com");
		pU1.setFecha("1 de agosto");
		pU1.setMax(10);
		pU1.setPeso(80);
		pU1.setRep(10);
		pU1.setTipo(Tipo.MAIL);
		
		usuarios.add(pU0);
		usuarios.add(pU1);
		
		Usuario uG1 = new Usuario();
		uG1.setNombre("Eva");
		uG1.setAltura(184);
		uG1.setEmail("eva@gmail.com");
		uG1.setFecha("1 de agosto");
		uG1.setMax(10);
		uG1.setPeso(80);
		uG1.setRep(10);
		uG1.setTipo(Tipo.GOOGLE);
		
		usuarios.add(uG1);
		
		Usuario uF1 = new Usuario();
		uF1.setNombre("Eva");
		uF1.setAltura(184);
		uF1.setEmail("eva@gmail.com");
		uF1.setFecha("1 de agosto");
		uF1.setMax(10);
		uF1.setPeso(80);
		uF1.setRep(10);
		uF1.setTipo(Tipo.FACEBOOK);
		
		usuarios.add(uF1);
		
		LoginFactory lg = new LoginFactory();
		ExternalLogin gateway = null;
		
		for (Tipo tipoLogin : Tipo.values()) {
			gateway = lg.crearLoginGateway(tipoLogin);
			if (gateway != null) {
				this.loginGateways.add(gateway);
			}
		}	
	}

	
	public boolean login(String email, String password, Tipo tipo) {
		boolean externalLogin = false;
		boolean result = false;
		
		for (ExternalLogin gateway : this.loginGateways) {
			if (gateway.tipo.equals(tipo)) {
				externalLogin = true;
				for(Usuario user: this.usuarios) {
					if (user.getEmail().equals(email) && user.getTipo().equals(tipo)) {
						result = gateway.login(email, user.getEmail());					
					}
				}
			}
		}
		
		if (!externalLogin) {
			//TODO: Tercera entrega: recuperar la info del usuario de la BBDD usando el DAO.
			//Si existe el usuario, se compara la contraseña, si no existe, se devuelve false o
			//una excepcion indicando que el usuario no existe.
			
			for(Usuario user: this.usuarios) {
				if (user.getEmail().equals(email) && user.getContrasena().equals(password) && user.getContrasena() != "") {
					//Recuperar la password del usuario y validar.
					result = true;
					//Se fuerza la salida del FOR.
					break;
				}
			}
		}
		
		return result;
	}
	
	public void addUsuario(PasswordUsuario u) {
		this.usuarios.add(u);
	}
	
}