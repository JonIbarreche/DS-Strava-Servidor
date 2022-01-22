package es.deusto.ingenieria.sd.strava.server.services;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.strava.external.ExternalLogin;
import es.deusto.ingenieria.sd.strava.external.LoginFactory;
import es.deusto.ingenieria.sd.strava.server.data.dao.UsuarioDAO;
import es.deusto.ingenieria.sd.strava.server.data.domain.Tipo;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;


//TODO: Implement Singleton Pattern
public class LoginAppService {
	

	List<ExternalLogin> loginGateways = new ArrayList<>();
	
	public LoginAppService() {
		this.InitializeData();
	}
	
	private void InitializeData() {
		
		LoginFactory lg = new LoginFactory();
		ExternalLogin gateway = null;
		
		for (Tipo tipoLogin : Tipo.values()) {
			gateway = lg.crearLoginGateway(tipoLogin);
			if (gateway != null) {
				this.loginGateways.add(gateway);
			}
		}	
	}

	
	public boolean login(String email, String password, Tipo tipo) {
		List<Usuario> usuarios = UsuarioDAO.getInstance().getAll();
		
		for (int i = 0; i < usuarios.size(); i++) {
			System.out.println("usuario es "+usuarios.get(i).getEmail() + usuarios.get(i).getContrasena());
		}
		
		boolean externalLogin = false;
		boolean result = false;
		
		for (ExternalLogin gateway : this.loginGateways) {
			if (gateway.tipo.equals(tipo)) {
				externalLogin = true;
				for(Usuario user: usuarios) {
					if (user.getEmail().equals(email) && user.getTipo().equals(tipo)) {
						result = gateway.login(email, user.getEmail());					
					}
				}
			}
		}
		
		if (!externalLogin) {
			String param = email+"#"+password;
			
			Usuario user = UsuarioDAO.getInstance().find(param);
			System.out.println(user.getContrasena() + "     " + user.getEmail());
			if (user!=null) {
				//no hace falta validar la constraseña ya que recogemos al usuario usando como parametros
				//el email y la contrasela
				result = true;
			} else {
				System.out.println("el usuario no existe");
			}
			
		}
		
		return result;
	}
	
	public void addUsuario(Usuario u) {
		System.out.println(u.getContrasena());
		UsuarioDAO.getInstance().save(u);
		
	}
	
}