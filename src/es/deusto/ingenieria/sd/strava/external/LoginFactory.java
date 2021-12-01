package es.deusto.ingenieria.sd.strava.external;

import java.rmi.RemoteException;

public class LoginFactory {
	public boolean login(String plataforma, String email) {
		System.out.println("estoy en el factry");
		switch(plataforma) {
			case "Facebook":
				ExternalLogin fb = new ExternalLogin("127.0.0.1", 1099);
				try {
					System.out.println("estoy aquí");
					return fb.facebookLogin(email);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
			case "Google":
				ExternalLogin g = new ExternalLogin("127.0.0.1", 1099);
				try {
					System.out.println("estoy en google");
					return g.googleLogin(email);
				} catch (Exception e) {
					// TODO: handle exception
				}
			default:
				return false;
		}
	}
}
