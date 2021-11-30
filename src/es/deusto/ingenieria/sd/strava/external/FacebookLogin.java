package es.deusto.ingenieria.sd.strava.external;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.strava.server.data.dto.UsuarioDTO;

public class FacebookLogin implements IExternalLogin{
	@Override
    public boolean facebookLogin(String mail) throws RemoteException{
		System.out.println("Estoy en el facebook login");
        String data = mail + "#";

        final String host = "localhost";
        final int portNumber = 69;
        try {
            Socket socket = new Socket(host, portNumber);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            
            out.writeUTF(data);
            System.out.println("he creado bien el socket");
            boolean valid = in.readUTF().equals("true");//if server says true, then it is valid
            System.out.println(valid);
            return valid;
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("no me he conectado");
        return false;
    }

}
