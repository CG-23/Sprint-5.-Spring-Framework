package cat.itacademy.barcelonactiva.gimeno.carlos.s05.t01.n02.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.gimeno.carlos.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.gimeno.carlos.s05.t01.n02.service.FlorService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/flor")
@AllArgsConstructor
public class FlorController {
	private final FlorService florService;
	
	@GetMapping(path = "/getOne/{id}")
	public ResponseEntity<FlorDTO> getById (@PathVariable(name = "id",required = true)Integer idFlor){
		FlorDTO flor = florService.getOne(idFlor);
		return ResponseEntity.status(HttpStatus.OK).body(flor);
	}
	
	@GetMapping(path = "/getAll")
	public ResponseEntity <List<FlorDTO>> getAll(){
		List<FlorDTO> listaflores = florService.getAllFlor();
		return ResponseEntity.status(HttpStatus.OK).body(listaflores);
	}
	
	@PostMapping(path = "/add")
	public ResponseEntity<FlorDTO> createNewFlor(@RequestBody(required = true)FlorDTO florDTO){
		FlorDTO florDTO2 = this.florService.createNew(florDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(florDTO2);
	}
	
	@PutMapping(path = "/update")
	public ResponseEntity<FlorDTO> updateFlor(@RequestBody(required = true)FlorDTO florDTO){
		FlorDTO florDTO2 = this.florService.update(florDTO);
		return ResponseEntity.status(HttpStatus.OK).body(florDTO2);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Void> deleteFlor(@PathVariable(name = "id",required = true)Integer idFlor){
		this.florService.deleteOne(idFlor);
		return ResponseEntity.status(HttpStatus.OK).build();		
	}	
}
