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
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

public class SesionDAO extends IDataAccessObject{

	private static SesionDAO instance;
	private PersistenceManagerFactory pmf;
	
	public SesionDAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
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

	public void borrarSesion(Sesion sesion) {
		this.borrar(sesion);
	}
	
	@Override
	public void borrar(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		
		
		try {
			System.out.println("   * Querying a Product: " + ((Sesion) object).getTitulo());

			tx.begin();
			Query<?> query = pm.newQuery("DELETE FROM " + "Usuario" + " WHERE EMAIL == '" +  ((Sesion) object).getTitulo() + "'");
			
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
	public Object encontrar(String titulo) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		Sesion sesion = null;

		try {
			System.out.println("   * Querying a Product: " + titulo);

			tx.begin();
			Query<?> query = pm.newQuery("SELECT FROM " + "usuario" + " WHERE EMAIL == '" + titulo + "'");
			query.setUnique(true);
			sesion = (Sesion) query.execute();
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return sesion;
	}
	
	public List<Sesion> listaSesiones(){
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		List<Sesion> sesiones = new ArrayList<Sesion>();

		try {
			System.out.println("   * Executing a Query for usuarios");

			tx.begin();
			Extent<Sesion> extent = pm.getExtent(Sesion.class, true);
			Query<Sesion> query = pm.newQuery(extent);

			for (Sesion sesion : (List<Sesion>) query.execute()) {
				sesiones.add(sesion);
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

		return sesiones;
	}
}
