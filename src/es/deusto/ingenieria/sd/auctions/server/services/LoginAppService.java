package es.deusto.ingenieria.sd.auctions.server.services;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Usuario;

//TODO: Implement Singleton Pattern
public class LoginAppService {
		
	public Usuario login(String email, String password) {
		//TODO: Get User using DAO and check 		
		Usuario user = new Usuario();		
		user.setEmail("thomas.e2001@gmail.com");
		user.setNombre("Thomas");		
		//Generate the hash of the password
		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");		
		user.setContraseña(sha1);
		
		if (user.getEmail().equals(email) && user.checkContraseña(password)) {		
			return user;
		} else {
			return null;
		}
	}
}