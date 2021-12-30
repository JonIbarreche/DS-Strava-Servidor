package es.deusto.ingenieria.sd.strava.server.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

public class UsuarioDAO extends IDataAccessObject{
	
	private static UsuarioDAO instance;
	private PersistenceManagerFactory pmf;
	
	public UsuarioDAO() {
		System.out.println("eo");
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}
		return instance;
	}
	
	public void guardarUsuario(Usuario usuario) {
		System.out.println("llamada");
		this.guardar(usuario);
	}
	
	@Override
	public void guardar(Object object) {
		System.out.println("entra");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("   * Almacenando el siguiente objeto: " + object);
			pm.makePersistent(object);
			tx.commit();
			System.out.println("bien commiteado");
		} catch (Exception ex) {
			System.out.println("   $ Error en el siguiente objeto: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}
	
	public void borrarUsuario(Usuario usuario) {
		this.borrar(usuario);
	}
	
	@Override
	public void borrar(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		
		
		try {
			System.out.println("   * Querying a Product: " + ((Usuario) object).getEmail());

			tx.begin();
			Query<?> query = pm.newQuery("DELETE FROM " + "Usuario" + " WHERE EMAIL == '" +  ((Usuario) object).getEmail() +
					"' AND TIPO == '" + ((Usuario) object).getTipo() + "'");
			
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

	public List<Usuario> listaUsuarios(){
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		
		List<Usuario> lista = new ArrayList<>();
		
		
		return lista;
	}
	
	@Override
	public Object encontrar(String email) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		Usuario usuario = null;

		try {
			System.out.println("   * Querying a Product: " + email);

			tx.begin();
			Query<?> query = pm.newQuery("SELECT FROM " + "Usuario" + " WHERE EMAIL == '" + email + "'");
			query.setUnique(true);
			usuario = (Usuario) query.execute();
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return usuario;
	}
	
}
