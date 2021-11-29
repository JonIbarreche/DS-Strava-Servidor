package es.deusto.ingenieria.sd.strava.external;

import java.rmi.RemoteException;

public class LoginFactory {
	public boolean login(String plataforma, String email) {
		switch(plataforma) {
			case "Facebook":
				FacebookLogin fb = new FacebookLogin();
				try {
					System.out.println("estoy aquí");
					return fb.facebookLogin(email);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
			default:
				return false;
		}
	}
}
