package es.deusto.ingenieria.sd.strava.external;

import java.rmi.Naming;

import es.deusto.ingenieria.sd.strava.google.remote.ILoginGoogleGateway;

public class GoogleService {
	private ILoginGoogleGateway service;

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
}
