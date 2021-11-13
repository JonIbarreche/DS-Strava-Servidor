package es.deusto.ingenieria.sd.auctions.server.services;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Sesion;

	public class SesionService {
		public Sesion sesionService(String titulo, float distancia, String fechaIni, String horaIni, int duracion) {
			//TODO: Get User using DAO and check 		
			Sesion sesion = new Sesion();		
			sesion.setTitulo("Sesion1");	
			sesion.setFechaIni("01/01/2021");
			sesion.setHoraIni("00:00");
			sesion.setDistancia(110);
			sesion.setDuracion(0);
			
			if (sesion.getTitulo().equals(titulo)) {		
				return sesion;
			} else {
				return null;
			}
		}
}
