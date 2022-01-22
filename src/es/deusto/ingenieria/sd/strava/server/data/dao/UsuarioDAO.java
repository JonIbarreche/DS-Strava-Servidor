package es.deusto.ingenieria.sd.strava.server.data.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;


import es.deusto.ingenieria.sd.strava.server.data.dao.DataAccessObjectBase;
import es.deusto.ingenieria.sd.strava.server.data.dao.IDataAccessObject;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

public class UsuarioDAO extends DataAccessObjectBase implements IDataAccessObject<Usuario>{
	
	private static UsuarioDAO instance;	
	
	private UsuarioDAO() { }
	
	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}		
		
		return instance;
	}
	
	@Override
	public void save(Usuario object) {
		super.saveObject(object);
	}

	@Override
	public void delete(Usuario object) {
		super.deleteObject(object);
	}

	@Override
	public List<Usuario> getAll() {				
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();

		List<Usuario> usuarios = new ArrayList<>();
		
		try {
			tx.begin();
			
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);

			for (Usuario usuario : extent) {
				usuarios.add(usuario);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Usuarios: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return usuarios;		
	}

	@Override
	public Usuario find(String param) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		
		StringTokenizer tokenizador = new StringTokenizer(param, "#");
		String email = tokenizador.nextToken();
		String contrasena = tokenizador.nextToken();
		System.out.println(email+contrasena+"estoy en el dao");
		Usuario result = null; 

		try {
			tx.begin();
						
			Query<?> query = pm.newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE email == '" + email + 
					"' && contrasena == '"+ contrasena + "'");
			query.setUnique(true);
			result = (Usuario) query.execute();
			System.out.println(result.getEmail()+" hola "+result.getContrasena());
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a usuario: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}

}
