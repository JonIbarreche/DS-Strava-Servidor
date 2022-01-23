package es.deusto.ingenieria.sd.strava.server.services;

import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.dao.SesionDAO;
import es.deusto.ingenieria.sd.strava.server.data.dao.UsuarioDAO;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

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

		public List<Sesion> getSesionesUsuario(String usuario){
			Usuario u = UsuarioDAO.getInstance().find(usuario);
			return u.getSesiones();
		}
		
		public void aceptarSesion(String usuario, String sesion) {
			Usuario u = UsuarioDAO.getInstance().find(usuario);
			Sesion s = SesionDAO.getInstance().find(sesion);
			u.addSesion(s);
			UsuarioDAO.getInstance().save(u);
		}
}
