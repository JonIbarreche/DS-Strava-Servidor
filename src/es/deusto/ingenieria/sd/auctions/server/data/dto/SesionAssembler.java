package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Sesion;

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
	
	public SesionDTO sesionToDTO() {
		SesionDTO dto = new SesionDTO();
		
		dto.setTitulo(sesiones.getTitulo());
		dto.setDistancia(sesiones.getDistancia());
		dto.setFechaIni(sesiones.getFechaIni());
		dto.setHoraIni(sesiones.getHoraIni());
		dto.setDuracion(sesiones.getDuracion());
		
		return dto;
	}
}
