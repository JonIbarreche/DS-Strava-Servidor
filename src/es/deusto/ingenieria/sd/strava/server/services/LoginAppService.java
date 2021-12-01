package es.deusto.ingenieria.sd.strava.server.services;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.strava.external.LoginFactory;
import es.deusto.ingenieria.sd.strava.server.data.domain.PasswordUsuario;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

//TODO: Implement Singleton Pattern
public class LoginAppService {
	
	List<PasswordUsuario> lista = new ArrayList<>();
	
	public LoginAppService() {
		this.InitializeData();
	}
	
	private void InitializeData() {
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
		pU0.setNombre("Eva");
		pU0.setAltura(184);
		pU0.setContrasena("abc123");
		pU0.setEmail("eva@gmail.com");
		pU0.setFecha("1 de agosto");
		pU0.setMax(10);
		pU0.setPeso(80);
		pU0.setRep(10);
		
		lista.add(pU0);
		lista.add(pU1);
	}
	public Usuario getUsuario(String email, String password) {
		//TODO: Get User using DAO and check 		
		System.out.println("he  entrado a get usuarios");
		for (int i = 0; i < this.lista.size(); i++) {
			if (this.lista.get(i).getEmail().equals(email) && this.lista.get(i).checkcontrasena(password)) {		
				System.out.println("he cogido al usuario");
				return this.lista.get(i);
			}
		}
		return null;
	}
	
	public boolean login(String email, String password, String plataforma) {
		System.out.println("entro y plataforma es" + plataforma);
		for (int i = 0; i < this.lista.size(); i++) {
			if (plataforma == "Mail" && this.lista.get(i).getEmail().equals(email) 
					&& this.lista.get(i).checkcontrasena(password)) {		
				return true;
			} else if (plataforma.equals("Google") || plataforma.equals("Facebook")) {
				System.out.println("me he metido en el loginappservice de facebook");
				LoginFactory lf = new LoginFactory();
				return lf.login(plataforma, email);
				
			}
		}
		return false;
	}
	
	public void addUsuario(PasswordUsuario u) {
		this.lista.add(u);
	}
	
}