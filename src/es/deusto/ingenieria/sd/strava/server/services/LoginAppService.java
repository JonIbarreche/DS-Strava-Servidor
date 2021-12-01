package es.deusto.ingenieria.sd.strava.server.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.deusto.ingenieria.sd.strava.external.LoginFactory;
import es.deusto.ingenieria.sd.strava.server.data.domain.PasswordUsuario;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

//TODO: Implement Singleton Pattern
public class LoginAppService {
	
	List<PasswordUsuario> listaMail = new ArrayList<>();
	List<Usuario> listaGoogle = new ArrayList<>();
	List<Usuario> listaFacebook = new ArrayList<>();
	
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
	}
	public Usuario getUsuario(String email, String password, String plataforma) {
		//TODO: Get User using DAO and check 		
		System.out.println("he  entrado a get usuarios");
		if(plataforma.equals("Mail")) {
			for (int i = 0; i < this.listaMail.size(); i++) {
				if (this.listaMail.get(i).getEmail().equals(email) && this.listaMail.get(i).checkcontrasena(password)) {		
					System.out.println("he cogido al usuario");
					return this.listaMail.get(i);
				}
			}
		} else if(plataforma.equals("Google")) {
			for (int i = 0; i < this.listaGoogle.size(); i++) {
				if (email.equals(this.listaGoogle.get(i).getEmail())) {
					return this.listaGoogle.get(i);
				}
			}
		} else if(plataforma.equals("Facebook")) {
			for (int i = 0; i < this.listaFacebook.size(); i++) {
				if (email.equals(this.listaFacebook.get(i).getEmail())) {
					return this.listaFacebook.get(i);
				}
			}
		}
		return null;
	}
	
	public boolean login(String email, String password, String plataforma) {
		System.out.println("entro y plataforma es" + plataforma);
		for (int i = 0; i < this.listaMail.size(); i++) {
			if (plataforma == "Mail" && this.listaMail.get(i).getEmail().equals(email) 
					&& this.listaMail.get(i).checkcontrasena(password)) {		
				return true;
			} else if (plataforma.equals("Google")) {
				System.out.println("me he metido en el loginappservice de facebook");
				LoginFactory lf = new LoginFactory();
				return lf.login(plataforma, email, this.listaGoogle);
				
			} else if (plataforma.equals("Facebook")) {
				LoginFactory lf = new LoginFactory();
				return lf.login(plataforma, email, this.listaFacebook);
			}
		}
		return false;
	}
	
	public void addUsuario(PasswordUsuario u) {
		this.listaMail.add(u);
	}
	
}