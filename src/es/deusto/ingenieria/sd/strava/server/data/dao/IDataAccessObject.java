package es.deusto.ingenieria.sd.strava.server.data.dao;

public abstract class IDataAccessObject {
	public static IDataAccessObject instance;
	public abstract void guardar(Object object);
	public abstract void borrar(Object object);
	public abstract Object encontrar(String string);
}
