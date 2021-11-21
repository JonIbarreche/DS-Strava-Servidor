package es.deusto.ingenieria.sd.strava.server.services;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.domain.PasswordUsuario;
import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;
import es.deusto.ingenieria.sd.strava.server.data.dto.SesionDTO;

	public class SesionService {
		
		//TODO: remove when DAO Pattern is implemented
		private List<Sesion> sesiones = new ArrayList<>();
		
		public SesionService() {
			//TODO: remove when DAO Pattern is implemented
			this.initilizeData();
		}
		
		//TODO: remove when DAO Pattern is implemented
		private void initilizeData() {
			//Create Users
			Usuario u0 = new Usuario();
			u0.setNombre("Thomas");
			u0.setAltura(167);
			u0.setEmail("thomas.e2001@gmail.com");
			u0.setFecha("8 de agosto");
			u0.setMax(10);
			u0.setPeso(80);
			u0.setRep(10);
			
			Usuario u1 = new Usuario();
			u1.setNombre("Jon");
			u1.setAltura(189);
			u1.setEmail("jon.e2001@gmail.com");
			u1.setFecha("19 de agosto");
			u1.setMax(17);
			u1.setPeso(65);
			u1.setRep(13);
			
			//Create Users
			PasswordUsuario pU0 = new PasswordUsuario();
			pU0.setNombre("Thomas");
			pU0.setAltura(167);
			pU0.setContrasena("iwhioqq12");
			pU0.setEmail("thomas.e2001@gmail.com");
			pU0.setFecha("8 de agosto");
			pU0.setMax(10);
			pU0.setPeso(80);
			pU0.setRep(10);
			
			PasswordUsuario pU1 = new PasswordUsuario();
			pU1.setNombre("Jon");
			pU1.setAltura(189);
			pU1.setContrasena("wnfo2q");
			pU1.setEmail("jon.e2001@gmail.com");
			pU1.setFecha("19 de agosto");
			pU1.setMax(17);
			pU1.setPeso(65);
			pU1.setRep(13);
			
			//Crear Sesiones
			Sesion s0 = new Sesion();
			s0.setTitulo("Maraton");
			s0.setHoraIni("10 am");
			s0.setFechaIni("9 marzo");
			s0.setDuracion(100);
			s0.setDistancia(10);
			
			Sesion s1 = new Sesion();
			s1.setTitulo("Triatlon");
			s1.setHoraIni("8 am");
			s1.setFechaIni("16 marzo");
			s1.setDuracion(150);
			s1.setDistancia(20);
			
			this.sesiones.add(s0);
			this.sesiones.add(s1);
			
			
			
		}
		/**
		 * 
		 * @param titulo
		 * @param distancia
		 * @param fechaIni
		 * @param horaIni
		 * @param duracion
		 * @return
		 */
		public Sesion sesionService(String titulo, float distancia, String fechaIni, String horaIni, int duracion) {
			//TODO: Get User using DAO and check 		
			Sesion sesion = new Sesion();		
			sesion.setTitulo("Sesion1");	
			sesion.setFechaIni("01/01/2021");
			sesion.setHoraIni("00:00");
			sesion.setDistancia(110);
			sesion.setDuracion(0);
			
			if (sesion.getTitulo().equals(titulo)) {		
				return sesion;
			} else {
				return null;
			}
		}
		
		public List<Sesion> getSesiones(){
			//TODO: Get all the categories using DAO Pattern		
			return this.sesiones;
		}
		
		public void addSesion(Sesion s) {
			this.sesiones.add(s);
		}
}
