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
        String data = mail + "#";

        final String host = "localhost";
        final int portNumber = 69;
        try {
            Socket socket = new Socket(host, portNumber);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF(data);
            boolean valid = in.readUTF().equals("true"); //if server says true, then it is valid
            return valid;
        } catch (IOException e){
            e.printStackTrace();
        }

        return false;
    }

}
