package es.deusto.ingenieria.sd.strava.external;

import java.rmi.Naming;
import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.strava.google.remote.ILoginGoogleGateway;
import es.deusto.ingenieria.sd.strava.server.data.domain.Tipo;

public class GoogleService extends ExternalLogin{
	
	private ILoginGoogleGateway service;
	private String serverIP;
	private int serverPort;
	
	public GoogleService() {
		super.tipo = Tipo.GOOGLE;
	}
	
	public void setService(String ip, String port, String serviceName) {
		//Activate Security Manager. It is needed for RMI.
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		//Get Remote Facade reference using RMIRegistry (IP + Port) and the service name.
		try {		
			String URL = "//" + ip + ":" + port + "/" + serviceName;
			this.service = (ILoginGoogleGateway) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote facade: " + ex);
		}		
	}

	public ILoginGoogleGateway getService() {
		return this.service;
	}
	
	@Override
	public boolean login(String mail, String comprueba) {
		System.out.println("estoy en googlelogin");
		GoogleService service = new GoogleService();
		service.setService(serverIP, Integer.toString(serverPort), "google");
		//LoginGoogleServer serviceStub = (LoginGoogleServer) java.rmi.Naming.lookup(name);
		boolean login;
		try {
			login = service.getService().login(mail, comprueba);
			System.out.println("he getteado" + login);
			if(login) {
				return true;
			} else {
				return false;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
