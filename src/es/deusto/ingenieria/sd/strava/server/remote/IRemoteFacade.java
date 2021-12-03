package es.deusto.ingenieria.sd.strava.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.domain.Tipo;
import es.deusto.ingenieria.sd.strava.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.SesionDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.UsuarioDTO;

//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	
	
	public long login(String email, String password, Tipo plataforma) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 
	
	public List<SesionDTO> getSesiones() throws RemoteException;
	
	public List<RetoDTO> getRetos() throws RemoteException;
	
	public RetoDTO crearReto	(String nombreReto, String fechaIni, String fechaFin, 
							float distancia, int tiempo, String deporte) throws RemoteException; 
	public UsuarioDTO crearUsuario (String email, String nombre, String fecha, int peso, int altura, int max, int rep,
			String contrasena) throws RemoteException;
	
	public SesionDTO crearSesion	(String titulo, float distancia, 
							String fechaIni, String horaIni, int duracion) throws RemoteException;
	
	public List<RetoDTO> getRetosActivos() throws RemoteException;
	

	
	public boolean aceptarReto (String nombreReto, float distancia)throws RemoteException;

}