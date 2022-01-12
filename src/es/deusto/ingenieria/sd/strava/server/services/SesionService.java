package es.deusto.ingenieria.sd.strava.server.services;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.dao.SesionDAO;
import es.deusto.ingenieria.sd.strava.server.data.domain.PasswordUsuario;
import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;
import es.deusto.ingenieria.sd.strava.server.data.dto.SesionDTO;

	public class SesionService {
		
		private SesionDAO sesionDAO = new SesionDAO();
		public SesionService() {
		}
		
		public List<Sesion> getSesiones(){
			List<Sesion> sesiones = sesionDAO.listaSesiones();
			return sesiones;
		}
		
		public void addSesion(Sesion s) {
			sesionDAO.guardarSesion(s);
		}
}
