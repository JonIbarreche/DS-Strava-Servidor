package es.deusto.ingenieria.sd.strava.external;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.strava.server.data.dto.UsuarioDTO;

public class ExternalLogin implements IExternalLogin{
	private String serverIP;
	private int serverPort;
	private static String DELIMITER = "#";
	
	public ExternalLogin (String servIP, int servPort) {
		serverIP = servIP;
		serverPort = servPort;
	}
	
	@Override
    public boolean facebookLogin(String mail) throws RemoteException{
		System.out.println("Estoy en el facebook login");
        String data = mail + DELIMITER;

        try {
            Socket socket = new Socket(serverIP, serverPort);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.println("he creado bien el socket");
            out.writeUTF(data);
            System.out.println(in.readUTF());
            boolean valid = in.readUTF().equals("true");//if server says true, then it is valid
            System.out.println(valid);
            return valid;
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("no me he conectado");
        return false;
    }

	@Override
	public boolean googleLogin(String mail) throws RemoteException {
		System.out.println("estoy en googlelogin");
		GoogleService service = new GoogleService();
		service.setService(serverIP, Integer.toString(serverPort), "google");
		//LoginGoogleServer serviceStub = (LoginGoogleServer) java.rmi.Naming.lookup(name);
		boolean login = service.getService().login(mail);
		System.out.println("he getteado" + login);
		if(login) {
			return true;
		} else {
			return false;
		}
		
	}

}
