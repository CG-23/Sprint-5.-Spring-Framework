package cat.itacademy.barcelonactiva.gimeno.carlos.s05.t01.n02.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "tbl_sucursal")
public class Flor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer pk_FlorID;

	@Column(name = "nombre")
	private String nombreFlor;
	
	@Column(name = "pais")
	private	String paisFlor;

}
