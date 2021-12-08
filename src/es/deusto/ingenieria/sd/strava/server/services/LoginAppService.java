package es.deusto.ingenieria.sd.strava.server.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.deusto.ingenieria.sd.strava.external.ExternalLogin;
import es.deusto.ingenieria.sd.strava.external.LoginFactory;
import es.deusto.ingenieria.sd.strava.server.data.domain.PasswordUsuario;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;
import es.deusto.ingenieria.sd.strava.server.data.domain.Tipo;


//TODO: Implement Singleton Pattern
public class LoginAppService {
	
	List<Usuario> lista = new ArrayList<>();

	List<ExternalLogin> listaLogin = new ArrayList<>();
	
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
		pU0.setTipo(Tipo.MAIL);
		
		PasswordUsuario pU1 = new PasswordUsuario();
		pU1.setNombre("Eva");
		pU1.setAltura(184);
		pU1.setContrasena("abc123");
		pU1.setEmail("eva@gmail.com");
		pU1.setFecha("1 de agosto");
		pU1.setMax(10);
		pU1.setPeso(80);
		pU1.setRep(10);
		pU1.setTipo(Tipo.MAIL);
		
		lista.add(pU0);
		lista.add(pU1);
		
		Usuario uG1 = new Usuario();
		uG1.setNombre("Eva");
		uG1.setAltura(184);
		uG1.setEmail("eva@gmail.com");
		uG1.setFecha("1 de agosto");
		uG1.setMax(10);
		uG1.setPeso(80);
		uG1.setRep(10);
		uG1.setTipo(Tipo.GOOGLE);
		
		lista.add(uG1);
		
		Usuario uF1 = new Usuario();
		uF1.setNombre("Eva");
		uF1.setAltura(184);
		uF1.setEmail("eva@gmail.com");
		uF1.setFecha("1 de agosto");
		uF1.setMax(10);
		uF1.setPeso(80);
		uF1.setRep(10);
		uF1.setTipo(Tipo.FACEBOOK);
		
		lista.add(uF1);
		
		LoginFactory lg = new LoginFactory();
		Tipo tipo = Tipo.FACEBOOK;
		listaLogin.add(lg.login(tipo));
		
		tipo = Tipo.GOOGLE;
		listaLogin.add(lg.login(tipo));
		
		for (int i = 0; i < listaLogin.size(); i++) {
			if (listaLogin.get(i) != null) {
				System.out.println("he metido un login " + i);
			}
		}
	}
	public Usuario getUsuario(String email, String password, Tipo plataforma) {
		//TODO: Get User using DAO and check 		
		System.out.println("he  entrado a get usuarios");
		for (int i = 0; i < this.lista.size(); i++) {
			
			if (this.lista.get(i).getEmail().equals(email) && plataforma.equals(this.lista.get(i).getTipo())){	
				return this.lista.get(i);
			}
		}
		return null;
	}
	
	public boolean login(String email, Tipo tipo) {
		
		for (int i = 0; i < listaLogin.size(); i++) {
			if(listaLogin.get(i).tipo.equals(tipo)) {
				for (int j = 0; j < lista.size(); j++) {
					Boolean loginea = listaLogin.get(i).login(email, lista.get(i).getEmail());
					if(loginea) {
						return loginea;
					}
				}
					
			}
		}
		
		return false;
	}
	
	public void addUsuario(PasswordUsuario u) {
		this.lista.add(u);
	}
	
}