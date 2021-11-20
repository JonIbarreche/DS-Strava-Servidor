package es.deusto.ingenieria.sd.strava.server.data.dto;

import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;

//This class is part of the DTO pattern. It also implements Singleton Pattern.
public class RetoAssembler {
	private static RetoAssembler instance;
	
	private RetoAssembler() {}
	
	public static RetoAssembler getInstance() {
		if (instance == null) {
			instance = new RetoAssembler();
		}
		return instance;
	}
	
	public RetoDTO retoToDTO(Reto reto) {
		RetoDTO dto = new RetoDTO();
		
		dto.setNombreReto(reto.getNombreReto());
		dto.setFechaIni(reto.getFechaIni());
		dto.setFechaFin(reto.getFechaFin());
		dto.setDistancia(reto.getDistancia());
		dto.setTiempo(reto.getTiempo());
		dto.setDeporte(reto.getDeporte());
		
		return dto;
	}
}
