package cat.itacademy.barcelonactiva.gimeno.carlos.s05.t01.n02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.gimeno.carlos.s05.t01.n02.exception.NotFoundException;
import cat.itacademy.barcelonactiva.gimeno.carlos.s05.t01.n02.mapper.FlorMapper;
import cat.itacademy.barcelonactiva.gimeno.carlos.s05.t01.n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.gimeno.carlos.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.gimeno.carlos.s05.t01.n02.repository.FlorRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FlorServiceImpl implements FlorService{
	
	private final FlorMapper flormapper;	
	private final FlorRepository florRepository;
	
	@Override
	public List<FlorDTO> getAllFlor() {
		List<Flor> listaFlores = florRepository.findAll();
		List<FlorDTO> listaFlorDTO = listaFlores
		.stream()
		.map(f -> flormapper.convertToDto(f))
		.toList();//recolectamos en una lista		
		return listaFlorDTO;
	}

	@Override
	public FlorDTO createNew(FlorDTO FlorDTO) {
		Flor newFlor = Flor.builder()
				.nombreFlor(FlorDTO.nombreFlor)
				.paisFlor(FlorDTO.paisFlor)
				.build();
		return this.flormapper.convertToDto(this.florRepository.save(newFlor));
	}

	@Override
	public FlorDTO update(FlorDTO florDTO) {
		Optional<Flor> florOptional = florRepository.findById(florDTO.pk_FlorID);
		if(florOptional.isEmpty()) {
			throw new NotFoundException("Flor con "+florDTO.pk_FlorID+" no existe");
		}		
		Flor flor = florOptional.get();
		flor.setNombreFlor(florDTO.nombreFlor);
		flor.setPaisFlor(florDTO.paisFlor);
		flor = this.florRepository.save(flor);
		FlorDTO florDTO2 = this.flormapper.convertToDto(flor);
		
		return florDTO2 ;
	}

	@Override
	public FlorDTO getOne(Integer idFlor) {
		Optional<Flor> f = florRepository.findById(idFlor);
		if (f.isEmpty()) {
			throw new NotFoundException("Flor con "+idFlor+" no existe");
		}		
		FlorDTO flor = flormapper.convertToDto(f.get());
		return flor ;
	}

	@Override
	public void deleteOne(Integer idFlor) {
		Optional<Flor> florOptional = this.florRepository.findById(idFlor);
		if(florOptional.isEmpty()) {
			throw new NotFoundException("Flor con "+idFlor+" no existe"); 
		}
		Flor flor = florOptional.get();
		this.florRepository.delete(flor);
	}

}
