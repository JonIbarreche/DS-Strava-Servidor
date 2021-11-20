package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.util.List;

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
	
	public RetoDTO retoToDTO(List<Reto> retos) {
		RetoDTO dto = new RetoDTO();
		
		dto.setNombreReto(((Reto) retos).getNombreReto());
		dto.setFechaIni(((Reto) retos).getFechaIni());
		dto.setFechaFin(((Reto) retos).getFechaFin());
		dto.setDistancia(((Reto) retos).getDistancia());
		dto.setTiempo(((Reto) retos).getTiempo());
		dto.setDeporte(((Reto) retos).getDeporte());
		
		return dto;
	}
}
