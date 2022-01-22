package es.deusto.ingenieria.sd.strava.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.strava.server.data.domain.Tipo;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;
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
	public synchronized long login(String email, String password, Tipo plataforma) throws RemoteException {
		System.out.println(" * RemoteFacade login(): " + email + " / " + password);
		
		boolean existe;
		
		System.out.println("llamo a login de loginservice desde remote facade");
		existe = loginService.login(email, password, plataforma);
		if (existe == true) {
			Long token = Calendar.getInstance().getTimeInMillis();
			return(token);
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
	public RetoDTO crearReto(String nombreReto, Date fechaIni, Date fechaFin, float distancia, int tiempo,
			String deporte) throws RemoteException {
			Reto retoNorm = new Reto(nombreReto, fechaIni, fechaFin, distancia, tiempo, deporte);
			retoService.addReto(retoNorm);
			return RetoAssembler.getInstance().retoToDTO(retoNorm);
		
	}
	
	@Override
	public UsuarioDTO crearUsuario(String email, String nombre, String fecha, int peso, int altura, int max, int rep,
			String contrasena, Tipo tipo) {
		Usuario userNorm = new Usuario(email, nombre, fecha, peso, altura, max, rep, tipo, contrasena);
		loginService.addUsuario(userNorm);
		return UsuarioAssembler.getInstance().userToDTO(userNorm);
		
	}
	
	@Override
	public SesionDTO crearSesion(String titulo, float distancia, Date fechaIni, String horaIni, int duracion) throws RemoteException {
		Sesion sesionNorm = new Sesion(titulo, distancia, fechaIni, horaIni, duracion);
		sesionService.addSesion(sesionNorm);
		return SesionAssembler.getInstance().sesionToDTO(sesionNorm);
		
	}

	@Override
	public List<RetoDTO> getRetosActivos(String u) throws RemoteException {
		System.out.println(" * RemoteFacade getRetos()");
		//Get Retos using RetoService	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String date = sdf.format(new Date()); 
		
		List<Reto> retos = retoService.getRetosActivos(u);
		
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
			throw new RemoteException("getRetosActivos() fails!");
		}
	}
	
	@Override
	public boolean aceptarReto(String r, String u) throws RemoteException {
		
		if(retoService.aceptarReto(r, u)) {
			return retoService.aceptarReto(r, u);
		} else {

			throw new RemoteException("aceptarReto() fails!");
		}
		
	}
	
}