package es.deusto.ingenieria.sd.strava.external;

import java.rmi.Remote;
import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.strava.server.data.domain.Tipo;
import es.deusto.ingenieria.sd.strava.server.data.dto.UsuarioDTO;

public abstract class ExternalLogin{
	public Tipo tipo;
	public abstract boolean login(String mail, String comprueba);
	
}
