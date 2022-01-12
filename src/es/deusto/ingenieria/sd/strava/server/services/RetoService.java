package es.deusto.ingenieria.sd.strava.server.services;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.dao.RetoDAO;
import es.deusto.ingenieria.sd.strava.server.data.domain.PasswordUsuario;
import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

//TODO: Implement Singleton Pattern
public class RetoService {
	
	private RetoDAO retoDAO = new RetoDAO();
	
	public RetoService() {}

	public List<Reto> getRetos(){
		List<Reto> retos = retoDAO.listaRetos();
		return retos;
	}
	
	public void addReto(Reto r) {
		retoDAO.guardarReto(r);
	}
	
	
}