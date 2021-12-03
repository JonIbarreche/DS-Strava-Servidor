package es.deusto.ingenieria.sd.strava.external;

import es.deusto.ingenieria.sd.strava.server.data.domain.Tipo;


public class LoginFactory {
	public ExternalLogin login(Tipo tipo) {
		boolean login;
		switch(tipo) {
			case FACEBOOK:
				return new FacebookService("127.0.0.1", 1099);
				
			case GOOGLE:
				System.out.println("estoy en factory google");
				return new GoogleService();
				
			default:
				return null;
		}
	}
}
