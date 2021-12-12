package es.deusto.ingenieria.sd.strava.external;

import es.deusto.ingenieria.sd.strava.server.data.domain.Tipo;


public class LoginFactory {
	public ExternalLogin crearLoginGateway(Tipo tipo) {
		switch(tipo) {
			case FACEBOOK:
				return new FacebookService("127.0.0.1", 8000);
				
			case GOOGLE:
				return new GoogleService("127.0.0.1", 1099);
				
			default:
				return null;
		}
	}
}
