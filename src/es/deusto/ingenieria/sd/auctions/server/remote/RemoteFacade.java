package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Article;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Category;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Usuario;
import es.deusto.ingenieria.sd.auctions.server.data.dto.ArticleAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.ArticleDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.CategoryAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.CategoryDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.SesionAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.SesionDTO;
import es.deusto.ingenieria.sd.auctions.server.services.BidAppService;
import es.deusto.ingenieria.sd.auctions.server.services.LoginAppService;
import es.deusto.ingenieria.sd.auctions.server.services.RetoService;
import es.deusto.ingenieria.sd.auctions.server.services.SesionService;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {	
	private static final long serialVersionUID = 1L;

	//Data structure for manage Server State
	private Map<Long, Usuario> serverState = new HashMap<>();
	
	//TODO: Remove this instances when Singleton Pattern is implemented
	private LoginAppService loginService = new LoginAppService();
	private BidAppService bidService = new BidAppService();
	private RetoService retoService = new RetoService();
	private SesionService sesionService = new SesionService();

	public RemoteFacade() throws RemoteException {
		super();		
	}
	
	@Override
	public synchronized long login(String email, String password) throws RemoteException {
		System.out.println(" * RemoteFacade login(): " + email + " / " + password);
				
		//Perform login() using LoginAppService
		Usuario user = loginService.login(email, password);
			
		//If login() success user is stored in the Server State
		if (user != null) {
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
			return SesionAssembler.getInstance().sesionToDTO(sesiones);
		} else {
			throw new RemoteException("getSesiones() fails!");
		}
		
		return null;
	}
	@Override
	public List<RetoDTO> getRetos() throws RemoteException {
		System.out.println(" * RemoteFacade getRetos()");
		//Get Retos using RetoService		
		List<Reto> retos = retoService.getRetos();
		
		if (retos != null) {
			//Convert domain object to DTO
			return RetoAssembler.getInstance().retoToDTO(retos);
		} else {
			throw new RemoteException("getSesiones() fails!");
		}
		
		return null;
	}

	@Override
	public void crearReto(String nombreReto, String fechaIni, String fechaFin, float distancia, int tiempo,
			String deporte) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearSesion(String titulo, float distancia, String fechaIni, String horaIni, int duracion) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RetoDTO> getRetosActivos() throws RemoteException {
		System.out.println(" * RemoteFacade getRetosActivos()");
		//Get Retos using RetoService		
		List<Reto> retos = retoService.getRetos();
		
		if (retos != null) {
			//Convert domain object to DTO
			return RetoAssembler.getInstance().retoToDTO(retos);
		} else {
			throw new RemoteException("getSesiones() fails!");
		}
		
		return null;
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