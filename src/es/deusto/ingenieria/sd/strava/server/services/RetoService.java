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
		
		//sabemos que no es el metodo más eficiente pero la clase date nos estaba dando problemas
		
		List<Reto> retosActivos = new ArrayList<>();
		
		List<Reto> todoRetos = RetoDAO.getInstance().getAll();
		
		StringTokenizer tokenizadorHoy = new StringTokenizer(fecha, "/");
		String diaHoy = tokenizadorHoy.nextToken();
		String mesHoy = tokenizadorHoy.nextToken();
		String anoHoy = tokenizadorHoy.nextToken();
		
		for (int i = 0; i < todoRetos.size(); i++) {
			StringTokenizer tokenizador = new StringTokenizer(todoRetos.get(i).getFechaFin(), "/");
			String diaFin = tokenizador.nextToken();
			String mesFin = tokenizador.nextToken();
			String anoFin = tokenizador.nextToken();
			if (Integer.parseInt(anoHoy) >= Integer.parseInt(anoFin) && 
					Integer.parseInt(mesHoy) >= Integer.parseInt(mesFin)
					&& Integer.parseInt(diaHoy) >= Integer.parseInt(diaFin)) {
						retosActivos.add(todoRetos.get(i));
			}
		}
		
		return retosActivos;
	}
	
	public boolean comprobarReto(Reto r) {
		
		StringTokenizer tokenizadorIniR = new StringTokenizer(r.getFechaIni(), "/");
		String diaIniR = tokenizadorIniR.nextToken();
		String mesIniR = tokenizadorIniR.nextToken();
		String anoIniR = tokenizadorIniR.nextToken();
		
		StringTokenizer tokenizadorFinR = new StringTokenizer(r.getFechaIni(), "/");
		String diaFinR = tokenizadorFinR.nextToken();
		String mesFinR = tokenizadorFinR.nextToken();
		String anoFinR = tokenizadorFinR.nextToken();
		
		List<Sesion> sesiones = SesionDAO.getInstance().getAll();
		
		List<Sesion> sesionesActivas = new ArrayList<>();
		
		//for para meter las sesiones que coincidan en el limite de tiempo
		for (int i = 0; i < sesiones.size(); i++) {
			StringTokenizer tokenizadorIniS = new StringTokenizer(sesiones.get(i).getFechaIni(), "/");
			String diaIniS = tokenizadorIniS.nextToken();
			String mesIniS = tokenizadorIniS.nextToken();
			String anoIniS = tokenizadorIniS.nextToken();
			
			StringTokenizer tokenizadorFinS = new StringTokenizer(sesiones.get(i).getFechaIni(), "/");
			String diaFinS = tokenizadorIniS.nextToken();
			String mesFinS = tokenizadorIniS.nextToken();
			String anoFinS = tokenizadorIniS.nextToken();
			
			if(Integer.parseInt(anoIniR) >= ) {
				
			}
		}
		
		return false;
	}
}