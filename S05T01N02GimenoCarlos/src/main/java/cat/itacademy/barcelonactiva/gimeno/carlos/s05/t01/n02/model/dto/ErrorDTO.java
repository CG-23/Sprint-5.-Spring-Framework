package cat.itacademy.barcelonactiva.gimeno.carlos.s05.t01.n02.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ErrorDTO {
	
	public int httpcode;
	public String message;

}
