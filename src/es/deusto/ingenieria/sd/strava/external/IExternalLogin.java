package es.deusto.ingenieria.sd.strava.external;

import java.rmi.Remote;
import java.rmi.RemoteException;
import es.deusto.ingenieria.sd.strava.server.data.dto.UsuarioDTO;

public interface IExternalLogin extends Remote{
	public boolean facebookLogin(String mail) throws RemoteException;
	public boolean googleLogin(String mail) throws RemoteException;
}
