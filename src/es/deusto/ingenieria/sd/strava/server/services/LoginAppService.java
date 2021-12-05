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
	
	List<PasswordUsuario> listaMail = new ArrayList<>();
	List<Usuario> listaGoogle = new ArrayList<>();
	List<Usuario> listaFacebook = new ArrayList<>();
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
		
		PasswordUsuario pU1 = new PasswordUsuario();
		pU0.setNombre("Eva");
		pU0.setAltura(184);
		pU0.setContrasena("abc123");
		pU0.setEmail("eva@gmail.com");
		pU0.setFecha("1 de agosto");
		pU0.setMax(10);
		pU0.setPeso(80);
		pU0.setRep(10);
		
		listaMail.add(pU0);
		listaMail.add(pU1);
		
		Usuario uG1 = new Usuario();
		uG1.setNombre("Eva");
		uG1.setAltura(184);
		uG1.setEmail("eva@gmail.com");
		uG1.setFecha("1 de agosto");
		uG1.setMax(10);
		uG1.setPeso(80);
		uG1.setRep(10);
		
		listaGoogle.add(uG1);
		
		Usuario uF1 = new Usuario();
		uF1.setNombre("Eva");
		uF1.setAltura(184);
		uF1.setEmail("eva@gmail.com");
		uF1.setFecha("1 de agosto");
		uF1.setMax(10);
		uF1.setPeso(80);
		uF1.setRep(10);
		
		listaFacebook.add(uF1);
		
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
		if(plataforma.equals(Tipo.MAIL)) {
			for (int i = 0; i < this.listaMail.size(); i++) {
				if (this.listaMail.get(i).getEmail().equals(email) && this.listaMail.get(i).checkcontrasena(password)) {		
					System.out.println("he cogido al usuario");
					return this.listaMail.get(i);
				}
			}
		} else if(plataforma.equals(Tipo.GOOGLE)) {
			for (int i = 0; i < this.listaGoogle.size(); i++) {
				if (email.equals(this.listaGoogle.get(i).getEmail())) {
					System.out.println("he gettteado al usuario");
					return this.listaGoogle.get(i);
				}
			}
		} else if(plataforma.equals(Tipo.FACEBOOK)) {
			for (int i = 0; i < this.listaFacebook.size(); i++) {
				if (email.equals(this.listaFacebook.get(i).getEmail())) {
					return this.listaFacebook.get(i);
				}
			}
		}
		return null;
	}
	
	public boolean login(String email, String comprueba, Tipo tipo) {
		for (int i = 0; i < listaLogin.size(); i++) {
			System.out.println(listaLogin.get(i).tipo);
			if(listaLogin.get(i).tipo.equals(tipo)) {
				System.out.println("he encontrado");
				System.out.println("loginappservice"+email+comprueba);
				Boolean loginea = listaLogin.get(i).login(email, comprueba);
				System.out.println(loginea);
				return loginea;
			}
		}
		
		return false;
	}
	
	public void addUsuario(PasswordUsuario u) {
		this.listaMail.add(u);
	}
	
}