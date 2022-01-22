package es.deusto.ingenieria.sd.strava.server.services;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import es.deusto.ingenieria.sd.strava.server.data.dao.RetoDAO;
import es.deusto.ingenieria.sd.strava.server.data.dao.SesionDAO;
import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;

//TODO: Implement Singleton Pattern
public class RetoService {
	
	public RetoService() {}

	public List<Reto> getRetos(){
		List<Reto> retos = RetoDAO.getInstance().getAll();
		return retos;
	}
	
	public void addReto(Reto r) {
		RetoDAO.getInstance().save(r);
	}
	
	public List<Reto> getRetosActivos(String fecha){
		
		
		return null;
	}
	
	public boolean comprobarReto(Reto r) {
		
		
		return false;
	}
}