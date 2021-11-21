package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;

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
	
	public List<RetoDTO> retosToDTO(List<Reto> retos) {
		List<RetoDTO> dtoLista = null;
		
		for (int i = 0; i < dtoLista.size(); i++) {
			RetoDTO dto = new RetoDTO();
			dto.setNombreReto(retos.get(i).getNombreReto());
			dto.setDistancia(retos.get(i).getDistancia());
			dto.setFechaIni(retos.get(i).getFechaIni());
			dto.setFechaFin(retos.get(i).getFechaFin());
			dto.setTiempo(retos.get(i).getTiempo());
			dto.setDeporte(retos.get(i).getDeporte());
			dtoLista.add(dto);
		}
		return dtoLista;
	}
}
