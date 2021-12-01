package es.deusto.ingenieria.sd.strava.external;

import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

public class LoginFactory {
	public boolean login(String plataforma, String email, List<Usuario> lista) {
		boolean login;
		switch(plataforma) {
			case "Facebook":
				ExternalLogin fb = new ExternalLogin("127.0.0.1", 1099);
				try {
					for (int i = 0; i < lista.size(); i++) {
						login =fb.facebookLogin(email, lista.get(i).getEmail());
						if (login) {
							return login;
						}
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
			case "Google":
				ExternalLogin g = new ExternalLogin("127.0.0.1", 1099);
				try {
					for (int i = 0; i < lista.size(); i++) {
						login = g.googleLogin(email, lista.get(i).getEmail());
						if (login) {
							return login;
						}
					}
						
				} catch (Exception e) {
					// TODO: handle exception
				}
			default:
				return false;
		}
	}
}
