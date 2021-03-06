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
import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

public class RetoDAO extends DataAccessObjectBase implements IDataAccessObject<Reto>{
	private static RetoDAO instance;	
	
	private RetoDAO() { }
	
	public static RetoDAO getInstance() {
		if (instance == null) {
			instance = new RetoDAO();
		}		
		
		return instance;
	}
	
	@Override
	public void save(Reto object) {
		super.saveObject(object);
	}

	@Override
	public void delete(Reto object) {
		super.deleteObject(object);
	}

	@Override
	public List<Reto> getAll() {				
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();

		List<Reto> retos = new ArrayList<>();
		
		try {
			tx.begin();
			
			Extent<Reto> extent = pm.getExtent(Reto.class, true);

			for (Reto reto : extent) {
				retos.add(reto);
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

		return retos;		
	}

	@Override
	public Reto find(String param) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		
		Reto result = null; 

		try {
			tx.begin();
						
			Query<?> query = pm.newQuery("SELECT FROM " + Reto.class.getName() + " WHERE nombreReto == '" + param + "'");
			query.setUnique(true);
			result = (Reto) query.execute();
			
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
