package es.deusto.ingenieria.sd.strava.server.services;

import es.deusto.ingenieria.sd.strava.server.data.domain.PasswordUsuario;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

//TODO: Implement Singleton Pattern
public class LoginAppService {
		
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
	
	
}