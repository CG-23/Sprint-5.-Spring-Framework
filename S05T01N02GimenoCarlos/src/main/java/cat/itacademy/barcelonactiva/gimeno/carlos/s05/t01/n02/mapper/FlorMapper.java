package cat.itacademy.barcelonactiva.gimeno.carlos.s05.t01.n02.mapper;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import cat.itacademy.barcelonactiva.gimeno.carlos.s05.t01.n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.gimeno.carlos.s05.t01.n02.model.dto.FlorDTO;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FlorMapper { 	
	private ModelMapper modelMapper;

	  public FlorDTO convertToDto(Flor Flor) {
	    FlorDTO FlorDto = modelMapper.map(Flor, FlorDTO.class);
	    FlorDto.checkEUCountry();
	    FlorDto.setPaisesUE(null);
	    return FlorDto;
	  }

	  public Flor convertToEntity(FlorDTO FlorDTO) {
	    Flor Flor = modelMapper.map(FlorDTO, Flor.class);
	    return Flor;
	  }
}

