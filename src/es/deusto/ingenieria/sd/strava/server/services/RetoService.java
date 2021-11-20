package es.deusto.ingenieria.sd.strava.server.services;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.domain.PasswordUsuario;
import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

//TODO: Implement Singleton Pattern
public class RetoService {
	
	//TODO: remove when DAO Pattern is implemented
	private List<Reto> retos = new ArrayList<>();
	
	public RetoService() {
		//TODO: remove when DAO Pattern is implemented
		this.initilizeData();
	}
	//TODO: remove when DAO Pattern is implemented
	private void initilizeData() {
		//Create Users
		/**
		 * 
		 
		Usuario u0 = new Usuario();
		u0.setNombre("Thomas");
		u0.setAltura(167);
		u0.setcontrasena("iwhioqq12");
		u0.setEmail("thomas.e2001@gmail.com");
		u0.setFecha("8 de agosto");
		u0.setMax(10);
		u0.setPeso(80);
		u0.setRep(10);
		
		Usuario u1 = new Usuario();
		u1.setNombre("Jon");
		u1.setAltura(189);
		u1.setcontrasena("wnfo2q");
		u1.setEmail("jon.e2001@gmail.com");
		u1.setFecha("19 de agosto");
		u1.setMax(17);
		u1.setPeso(65);
		u1.setRep(13);
		*/
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
		
		//Crear Retos
		Reto r0 = new Reto();
		r0.setNombreReto("Saltar");
		r0.setTiempo(100);
		r0.setDistancia(10);
		r0.setDeporte("Atletismo");
		r0.setFechaIni("05/12/2021");
		r0.setFechaFin("06/12/2021");
		
		Reto r1 = new Reto();
		r1.setNombreReto("Andar");
		r1.setTiempo(150);
		r1.setDistancia(20);
		r1.setDeporte("Ciclismo");
		r1.setFechaIni("10/11/2021");
		r1.setFechaFin("12/11/2021");
		
		this.retos.add(r0);
		this.retos.add(r1);
		
		
	}
	
	public List<Reto> getRetos(){
		return this.retos;
	}
	
	/**
	 * 
	 * @param nombreReto
	 * @param fechaIni
	 * @param fechaFin
	 * @param distancia
	 * @param tiempo
	 * @param deporte
	 * @return
	 */
	public Reto retoService(String nombreReto, String fechaIni, String fechaFin, float distancia, int tiempo, String deporte) {
		//TODO: Get User using DAO and check 		
		Reto reto = new Reto();		
		reto.setNombreReto("Reto1");	
		reto.setFechaIni("01/01/2021");
		reto.setFechaFin("25/01/2022");
		reto.setDistancia(110);
		reto.setTiempo(0);
		reto.setDeporte("MTB");

		if (reto.getNombreReto().equals(nombreReto)) {		
			return reto;
		} else {
			return null;
		}
	}
	
	
}