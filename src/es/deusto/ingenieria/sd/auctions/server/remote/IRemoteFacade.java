package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.dto.ArticleDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.CategoryDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.SesionDTO;

//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	
	
	public long login(String email, String password) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 
	
	public List<SesionDTO> getSesiones() throws RemoteException;
	
	public List<RetoDTO> getRetos() throws RemoteException;
	
	public void crearReto	(String nombreReto, String fechaIni, String fechaFin, 
							float distancia, int tiempo, String deporte) throws RemoteException; 
	
	public void crearSesion	(String titulo, float distancia, 
							String fechaIni, String horaIni, int duracion) throws RemoteException;
	
	public List<RetoDTO> getRetosActivos() throws RemoteException;
	
	public boolean aceptarReto (String nombreReto, float distancia)throws RemoteException;

	//public List<CategoryDTO> getCategories() throws RemoteException;
	
	//public List<ArticleDTO> getArticles(String aCategory) throws RemoteException;
	
	//public boolean makeBid(long token, int article, float amount) throws RemoteException;
	
	//public float getUSDRate() throws RemoteException;
	
	//public float getGBPRate() throws RemoteException;	
}