package es.deusto.ingenieria.sd.strava.external;

import es.deusto.ingenieria.sd.strava.server.data.domain.Tipo;


public class LoginFactory {
	public ExternalLogin login(Tipo tipo) {
		switch(tipo) {
			case FACEBOOK:
				System.out.println("he creado facebook en el factory");
				return new FacebookService("127.0.0.1", 8000);
				
			case GOOGLE:
				System.out.println("estoy en factory google");
				return new GoogleService("127.0.0.1", 1099);
				
			default:
				return null;
		}
	}
}
