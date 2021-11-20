package es.deusto.ingenieria.sd.strava.server.data.dto;

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
	
	public SesionDTO sesionToDTO(List<Sesion> sesiones) {
		SesionDTO dto = new SesionDTO();
		
		dto.setTitulo(((Sesion) sesiones).getTitulo());
		dto.setDistancia(((Sesion) sesiones).getDistancia());
		dto.setFechaIni(((Sesion) sesiones).getFechaIni());
		dto.setHoraIni(((Sesion) sesiones).getHoraIni());
		dto.setDuracion(((Sesion) sesiones).getDuracion());
		
		return dto;
	}
}
