package cat.itacademy.barcelonactiva.gimeno.carlos.s05.t01.n02.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlorDTO {
	public Integer pk_FlorID;
	public String nombreFlor;
	public String paisFlor;
	public String tipoFlor;
	private List<String> paisesUE = List.of("Alemania", "Bélgica", "Croacia", "Dinamarca", "España", "Francia", "Irlanda",
			"Letonia", "Luxemburgo", "Países Bajos", "Suecia", "Bulgaria", "Eslovaquia", "Estonia", "Grecia", "Malta",
			"Polonia", "República Checa", "Austria", "Chipre", "Eslovenia", "Finlandia", "Hungría", "Italia", "Lituania",
			"Portugal", "Rumanía");

	public void checkEUCountry() {
		if (paisFlor != null) {
			this.tipoFlor = "Fuera UE";
			for(String pais:this.paisesUE) {
				if(pais.toUpperCase().equals(paisFlor.toUpperCase())){
					this.tipoFlor = "UE";
					break;
				}
			}
			return ;
		}
		paisFlor = "N/A";
	}
}
