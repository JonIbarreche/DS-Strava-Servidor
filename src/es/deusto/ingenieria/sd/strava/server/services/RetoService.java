package es.deusto.ingenieria.sd.strava.server.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import es.deusto.ingenieria.sd.strava.server.data.dao.RetoDAO;
import es.deusto.ingenieria.sd.strava.server.data.dao.SesionDAO;
import es.deusto.ingenieria.sd.strava.server.data.dao.UsuarioDAO;
import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;
import es.deusto.ingenieria.sd.strava.server.data.dto.RetoDTO;

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
	
	public boolean aceptarReto(String r, String u) {
	
		boolean anyadido = false;
		
		Reto reto = RetoDAO.getInstance().find(r);
		if(reto == null) {
			return anyadido;
		}
		
		List<Sesion> sesiones = SesionDAO.getInstance().getAll();
		List<Sesion> sesionesMirar = new ArrayList<Sesion>();
		//cogemos las sesiones que encajen con la fecha
		for (int i = 0; i < sesiones.size(); i++) {
			if (sesiones.get(i).getFechaIni().before(reto.getFechaFin())
					&& sesiones.get(i).getFechaIni().after(reto.getFechaIni())) {
				sesionesMirar.add(sesiones.get(i));
			}
		}
		if (sesionesMirar.isEmpty()) {
			Usuario usuario = UsuarioDAO.getInstance().find(u);
			if(usuario != null) {
					usuario.addReto(reto);
					UsuarioDAO.getInstance().save(usuario);
					return true;
			}

		}
		
		//sumamos los datos de esas sesiones
		float distancia = 0;
		float duracion = 0;
		for (int i = 0; i < sesionesMirar.size(); i++) {
			distancia += sesionesMirar.get(i).getDistancia();
			duracion += sesionesMirar.get(i).getDuracion();
		}
		//comprobamos que no se ha cumplido ya el reto

		if (reto.getTiempo() > duracion) {
			anyadido = true;
		}
		
		if (reto.getDistancia() > distancia) {
			anyadido = true;
		}
		
		Usuario usuario = UsuarioDAO.getInstance().find(u);
		if(usuario != null) {
				usuario.addReto(reto);
				UsuarioDAO.getInstance().save(usuario);
				return anyadido;
		}
		return anyadido;
	}
	
	public List<Reto> getRetosActivos(String u) {	
		System.out.println("estoy en getRetosActivos");
		Usuario usuario = UsuarioDAO.getInstance().find(u);
		System.out.println(usuario.toString());
		if(usuario!=null) {
			System.out.println("el usuario existe es " + usuario.toString());
			List<Reto> retos = usuario.getRetos();
			System.out.println("he cogido los retos del usuario");
			System.out.println("tamaño retos "+ retos.size());
			
			return retos;
		} else {
			return null;
		}
	}
}