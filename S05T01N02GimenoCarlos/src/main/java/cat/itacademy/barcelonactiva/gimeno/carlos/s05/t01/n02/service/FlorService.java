package cat.itacademy.barcelonactiva.gimeno.carlos.s05.t01.n02.service;

import java.util.List;

import cat.itacademy.barcelonactiva.gimeno.carlos.s05.t01.n02.model.dto.FlorDTO;


public interface FlorService {
	
	List<FlorDTO> getAllFlor();
	FlorDTO createNew(FlorDTO FlorDTO);
	FlorDTO update(FlorDTO FlorDTO);
	FlorDTO getOne(Integer idFlor);
	void deleteOne(Integer idFlor);
}
