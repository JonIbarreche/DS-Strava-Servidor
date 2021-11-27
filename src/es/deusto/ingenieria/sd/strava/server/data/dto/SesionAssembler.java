package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;

//This class is part of the DTO pattern. It also implements Singleton Pattern.
public class SesionAssembler {
	private static SesionAssembler instance;
	
	private SesionAssembler() {}
	
	public static SesionAssembler getInstance() {
		if (instance == null) {
			instance = new SesionAssembler();
		}
		return instance;
	}
	
	public SesionDTO sesionToDTO(Sesion sesion) {
		SesionDTO dto = new SesionDTO();
		
		dto.setTitulo(sesion.getTitulo());
		dto.setDistancia(sesion.getDistancia());
		dto.setFechaIni(sesion.getFechaIni());
		dto.setHoraIni(sesion.getHoraIni());
		dto.setDuracion(sesion.getDuracion());
		
		return dto;
	}
	
}
