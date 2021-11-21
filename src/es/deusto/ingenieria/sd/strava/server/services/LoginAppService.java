package es.deusto.ingenieria.sd.strava.server.services;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.domain.PasswordUsuario;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

//TODO: Implement Singleton Pattern
public class LoginAppService {
	
	List<Usuario> lista = new ArrayList<Usuario>();
	
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
		
		lista.add(pU0);
	}
	public Usuario login(String email, String password) {
		//TODO: Get User using DAO and check 		
		Usuario user = new Usuario();		
		user.setEmail("thomas.e2001@gmail.com");
		user.setNombre("Thomas");	
		PasswordUsuario puser = new PasswordUsuario();
		puser.setEmail("thomas.e2001@gmail.com");
		puser.setNombre("Thomas");
		//Generate the hash of the password
		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");		
		//user.setcontrasena(sha1);
		puser.setContrasena(sha1);
	
		
		if (puser.getEmail().equals(email) && puser.checkcontrasena(password)) {		
			return puser;
		} else {
			return null;
		}
	}
	
	public void addUsuario(PasswordUsuario u) {
		this.lista.add(u);
	}
	
}