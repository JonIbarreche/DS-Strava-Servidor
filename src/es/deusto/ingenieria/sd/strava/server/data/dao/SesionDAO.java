package es.deusto.ingenieria.sd.strava.server.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;


import es.deusto.ingenieria.sd.strava.server.data.dao.DataAccessObjectBase;
import es.deusto.ingenieria.sd.strava.server.data.dao.IDataAccessObject;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

public class SesionDAO extends DataAccessObjectBase implements IDataAccessObject<Sesion>{
	
	private static SesionDAO instance;	
	
	private SesionDAO() { }
	
	public static SesionDAO getInstance() {
		if (instance == null) {
			instance = new SesionDAO();
		}		
		
		return instance;
	}
	
	@Override
	public void save(Sesion object) {
		super.saveObject(object);
	}

	@Override
	public void delete(Sesion object) {
		super.deleteObject(object);
	}

	@Override
	public List<Sesion> getAll() {				
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();

		List<Sesion> sesiones = new ArrayList<>();
		
		try {
			tx.begin();
			
			Extent<Sesion> extent = pm.getExtent(Sesion.class, true);

			for (Sesion sesion : extent) {
				sesiones.add(sesion);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Categories: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return sesiones;		
	}

	@Override
	public Sesion find(String param) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		
		Sesion result = null; 

		try {
			tx.begin();
						
			Query<?> query = pm.newQuery("SELECT FROM " + Sesion.class.getName() + " WHERE titulo == '" + param + "'");
			query.setUnique(true);
			result = (Sesion) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a Category: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}
}
