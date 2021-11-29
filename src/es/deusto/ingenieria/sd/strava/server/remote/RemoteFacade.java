package es.deusto.ingenieria.sd.strava.server.remote;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;
import es.deusto.ingenieria.sd.strava.server.data.domain.PasswordUsuario;
import es.deusto.ingenieria.sd.strava.server.data.dto.RetoAssembler;
import es.deusto.ingenieria.sd.strava.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.SesionAssembler;
import es.deusto.ingenieria.sd.strava.server.data.dto.SesionDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.UsuarioAssembler;
import es.deusto.ingenieria.sd.strava.server.data.dto.UsuarioDTO;
import es.deusto.ingenieria.sd.strava.server.services.LoginAppService;
import es.deusto.ingenieria.sd.strava.server.services.RetoService;
import es.deusto.ingenieria.sd.strava.server.services.SesionService;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {	
	private static final long serialVersionUID = 1L;

	//Data structure for manage Server State
	private Map<Long, Usuario> serverState = new HashMap<>();
	
	//TODO: Remove this instances when Singleton Pattern is implemented
	private LoginAppService loginService = new LoginAppService();
	private RetoService retoService = new RetoService();
	private SesionService sesionService = new SesionService();

	public RemoteFacade() throws RemoteException {
		super();		
	}
	
	@Override
	public synchronized long login(String email, String password, String plataforma) throws RemoteException {
		System.out.println(" * RemoteFacade login(): " + email + " / " + password);
				
		//Perform login() using LoginAppService
		Usuario user = loginService.getUsuario(email, password);
		boolean existe = loginService.login(email, password, plataforma);	
		//If login() success user is stored in the Server State
		if (user != null && existe == true) {
			//If user is not logged in 
			if (!this.serverState.values().contains(user)) {
				Long token = Calendar.getInstance().getTimeInMillis();		
				this.serverState.put(token, user);		
				return(token);
			} else {
				throw new RemoteException("User is already logged in!");
			}
		} else {
			throw new RemoteException("Login fails!");
		}
	}
	
	@Override
	public synchronized void logout(long token) throws RemoteException {
		System.out.println(" * RemoteFacade logout(): " + token);
		
		if (this.serverState.containsKey(token)) {
			//Logout means remove the User from Server State
			this.serverState.remove(token);
		} else {
			throw new RemoteException("User is not logged in!");
		}
	}

	@Override
	public List<SesionDTO> getSesiones() throws RemoteException {
		System.out.println(" * RemoteFacade getSesiones()");
		
		//Get Sesiones using SesionService		
		List<Sesion> sesiones = sesionService.getSesiones();
		
		
			if (sesiones != null) {
				//Convert domain object to DTO
				List<SesionDTO> sesiondtolista =  new ArrayList<>();
				SesionDTO meter;
				for (int i = 0; i < sesiones.size(); i++) {
					meter = SesionAssembler.getInstance().sesionToDTO(sesiones.get(i));
					sesiondtolista.add(meter);
				}
				return sesiondtolista;
			} else {
				throw new RemoteException("getSesiones() fails!");
			}
			
			//return null;
	}
	@Override
	public List<RetoDTO> getRetos() throws RemoteException {
		System.out.println(" * RemoteFacade getRetos()");
		//Get Retos using RetoService		
		List<Reto> retos = retoService.getRetos();
		
		if (retos != null) {
			//Convert domain object to DTO
			List<RetoDTO> retodtolista =  new ArrayList<>();
			RetoDTO meter;
			for (int i = 0; i < retos.size(); i++) {
				meter = RetoAssembler.getInstance().retoToDTO(retos.get(i));
				retodtolista.add(meter);
			}
			return retodtolista;
		} else {
			throw new RemoteException("getRetos() fails!");
		}
		//return null;
	}

	@Override
	public RetoDTO crearReto(String nombreReto, String fechaIni, String fechaFin, float distancia, int tiempo,
			String deporte) throws RemoteException {
			Reto retoNorm = new Reto(nombreReto, fechaIni, fechaFin, distancia, tiempo, deporte);
			retoService.addReto(retoNorm);
			return RetoAssembler.getInstance().retoToDTO(retoNorm);
		
	}
	
	@Override
	public UsuarioDTO crearUsuario(String email, String nombre, String fecha, int peso, int altura, int max, int rep,
			String contrasena) {
		PasswordUsuario userNorm = new PasswordUsuario(email, nombre, fecha, peso, altura, max, rep, contrasena);
		loginService.addUsuario(userNorm);
		return UsuarioAssembler.getInstance().userToDTO(userNorm);
		
	}
	
	@Override
	public SesionDTO crearSesion(String titulo, float distancia, String fechaIni, String horaIni, int duracion) throws RemoteException {
		Sesion sesionNorm = new Sesion(titulo, distancia, fechaIni, horaIni, duracion);
		sesionService.addSesion(sesionNorm);
		return SesionAssembler.getInstance().sesionToDTO(sesionNorm);
		
	}

	@Override
	public List<RetoDTO> getRetosActivos() throws RemoteException {
		System.out.println(" * RemoteFacade getRetos()");
		//Get Retos using RetoService		
		List<Reto> retos = retoService.getRetos();
		
		if (retos != null) {
			//Convert domain object to DTO
			List<RetoDTO> retodtolista =  new ArrayList<>();
			RetoDTO meter;
			for (int i = 0; i < retos.size(); i++) {
				meter = RetoAssembler.getInstance().retoToDTO(retos.get(i));
				retodtolista.add(meter);
			}
			return retodtolista;
		} else {
			throw new RemoteException("getSesiones() fails!");
		}
		//return null;
	}

	@Override
	public boolean aceptarReto(String nombreReto, float distancia) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 
	@Override
	public List<CategoryDTO> getCategories() throws RemoteException {
		System.out.println(" * RemoteFacade getCategories()");
		
		//Get Categories using BidAppService
		List<Category> categories = bidService.getCategories();
		
		if (categories != null) {
			//Convert domain object to DTO
			return CategoryAssembler.getInstance().categoryToDTO(categories);
		} else {
			throw new RemoteException("getCategories() fails!");
		}
	}
	 */
	
	/**
	 * 
	 * @param category
	 * @return
	 * @throws RemoteException
	
	@Override
	public List<ArticleDTO> getArticles(String category) throws RemoteException {
		System.out.println(" * RemoteFacade getArticle('" + category + "')");

		//Get Articles using BidAppService
		List<Article> articles = bidService.getArticles(category);
		
		if (articles != null) {
			//Convert domain object to DTO
			return ArticleAssembler.getInstance().articleToDTO(articles);
		} else {
			throw new RemoteException("getArticles() fails!");
		}
	}
	 */
	
	/**
	 * 
	 * @param token
	 * @param article
	 * @param amount
	 * @return
	 * @throws RemoteException
	
	@Override
	public boolean makeBid(long token, int article, float amount) throws RemoteException {		
		System.out.println(" * RemoteFacade makeBid article : " + article + " / amount " + amount);
		
		if (this.serverState.containsKey(token)) {						
			//Make the bid using Bid Application Service
			if (bidService.makeBid(this.serverState.get(token), article, amount)) {
				return true;
			} else {
				throw new RemoteException("makeBid() fails!");
			}
		} else {
			throw new RemoteException("To place a bid you must first log in");
		}
	}
	 */
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 
	@Override
	public float getUSDRate() throws RemoteException {
		System.out.println(" * RemoteFacade get USD rate");

		//Get rate using BidAppService
		float rate = bidService.getUSDRate();
		
		if (rate != -1) {
			return rate;
		} else {
			throw new RemoteException("getUSDRate() fails!");
		}
	}
	 */
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 
	@Override
	public float getGBPRate() throws RemoteException {
		System.out.println(" * RemoteFacade get GBP rate");
		
		//Get rate using BidAppService
		float rate = bidService.getGBPRate();
		
		if (rate != -1) {
			return rate;
		} else {
			throw new RemoteException("getGBPRate() fails!");
		}
	}
	*/
	
}