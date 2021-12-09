package es.deusto.ingenieria.sd.strava.external;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.strava.server.data.domain.Tipo;
import es.deusto.ingenieria.sd.strava.server.data.dto.UsuarioDTO;

public class FacebookService extends ExternalLogin{
	private String serverIP;
	private int serverPort;
	private static String DELIMITER = "#";
	
	public FacebookService (String servIP, int servPort) {
		serverIP = servIP;
		serverPort = servPort;
		super.tipo = Tipo.FACEBOOK;
	}
	
	
	
	@Override
    public boolean login(String mail, String comprueba){
		System.out.println("Estoy en el facebook login");
		System.out.println(mail + "       a " + comprueba);
		System.out.println(serverIP + serverPort);
        String data = mail + DELIMITER + comprueba;

        try {
            try (Socket socket = new Socket(serverIP, serverPort)) {
				DataInputStream in = new DataInputStream(socket.getInputStream());
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				System.out.println("a");
				out.writeUTF(data);
				System.out.println("b");
				String result = in.readUTF();
				System.out.println(result);
				return Boolean.parseBoolean(result);//if server says true, then it is valid
				
			}
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("devuelvo el false malo");
        return false;
    }

	

}
