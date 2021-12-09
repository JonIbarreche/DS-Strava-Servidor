package es.deusto.ingenieria.sd.strava.server.test;

import es.deusto.ingenieria.sd.strava.external.FacebookService;

public class LocalTest {

	public static void main(String[] args) {	
		
		try {
			
			FacebookService fb = new FacebookService("127.0.0.1", 8000);
			fb.login("a@b", "a@b");
				
		} catch (Exception e) {			
			System.out.println("\t# Error: " + e.getMessage());
		} 
		

		//Force exit to stop RMI Server
		System.exit(0);
	}

}