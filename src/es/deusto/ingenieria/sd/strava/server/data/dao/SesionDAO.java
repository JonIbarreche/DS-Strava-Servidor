package es.deusto.ingenieria.sd.strava.server.data.dao;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;

public class SesionDAO extends IDataAccessObject{

	private static SesionDAO instance;
	private PersistenceManagerFactory pmf;
	
	private SesionDAO() {}
	
	public static SesionDAO getInstance() {
		if (instance == null) {
			instance = new SesionDAO();
		}
		return instance;
	}
	
	public void guardarSesion(Sesion sesion) {
		this.guardar(sesion);
	}
	
	@Override
	public void guardar(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("   * Almacenando el siguiente objeto: " + object);
			pm.makePersistent(object);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error en el siguiente objeto: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

	@Override
	public void borrar(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object encontrar(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
