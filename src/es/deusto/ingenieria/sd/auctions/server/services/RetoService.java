package es.deusto.ingenieria.sd.auctions.server.services;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;

//TODO: Implement Singleton Pattern
public class RetoService {
		
	public Reto retoService(String nombreReto, String fechaIni, String fechaFin, float distancia, int tiempo, String deporte) {
		//TODO: Get User using DAO and check 		
		Reto reto = new Reto();		
		reto.setNombreReto("Reto1");	
		reto.setFechaIni("01/01/2021");
		reto.setFechaFin("25/01/2022");
		reto.setDistancia(110);
		reto.setTiempo(0);
		reto.setDeporte("MTB");

		if (reto.getNombreReto().equals(nombreReto)) {		
			return reto;
		} else {
			return null;
		}
	}
}