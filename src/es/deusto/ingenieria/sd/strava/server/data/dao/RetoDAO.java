package es.deusto.ingenieria.sd.strava.server.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

public class RetoDAO extends IDataAccessObject{

	private static RetoDAO instance;
	private PersistenceManagerFactory pmf;
	
	public RetoDAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	
	public static RetoDAO getInstance() {
		if (instance == null) {
			instance = new RetoDAO();
		}
		return instance;
	}
	
	public void guardarReto(Reto reto) {
		this.guardar(reto);
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
	
	public void borrarReto(Reto reto) {
		this.borrar(reto);
	}
	
	@Override
	public void borrar(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		
		
		try {
			System.out.println("   * Querying a Product: " + ((Reto) object).getNombreReto());

			tx.begin();
			Query<?> query = pm.newQuery("DELETE FROM " + "Usuario" + " WHERE EMAIL == '" +  ((Reto) object).getNombreReto() + "'");
			
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

	@Override
	public Object encontrar(String nombre) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		Usuario usuario = null;

		try {
			System.out.println("   * Querying a Product: " + nombre);

			tx.begin();
			Query<?> query = pm.newQuery("SELECT FROM " + "reto" + " WHERE NOMBRERETO == '" + nombre + "'");
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
	
	public List<Reto> listaRetos(){
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		List<Reto> retos = new ArrayList<Reto>();

		try {
			System.out.println("   * Executing a Query for usuarios");

			tx.begin();
			Extent<Reto> extent = pm.getExtent(Reto.class, true);
			Query<Reto> query = pm.newQuery(extent);

			for (Reto reto : (List<Reto>) query.execute()) {
				retos.add(reto);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return retos;
	}
}
