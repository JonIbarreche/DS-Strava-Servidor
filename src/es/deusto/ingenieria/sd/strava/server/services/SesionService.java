package es.deusto.ingenieria.sd.strava.server.services;

import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.dao.SesionDAO;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;

	public class SesionService {
		
		public SesionService() {
		}
		
		public List<Sesion> getSesiones(){
			List<Sesion> sesiones = SesionDAO.getInstance().getAll();
			return sesiones;
		}
		
		public void addSesion(Sesion s) {
			SesionDAO.getInstance().save(s);
		}
}
