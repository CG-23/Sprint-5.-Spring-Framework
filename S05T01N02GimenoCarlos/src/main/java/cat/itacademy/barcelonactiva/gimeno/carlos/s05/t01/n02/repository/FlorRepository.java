package cat.itacademy.barcelonactiva.gimeno.carlos.s05.t01.n02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.gimeno.carlos.s05.t01.n02.model.domain.Flor;

@Repository
public interface FlorRepository extends JpaRepository<Flor, Integer> {
	
	List<Flor> findByNombreFlor(String nombreFlor);
}
