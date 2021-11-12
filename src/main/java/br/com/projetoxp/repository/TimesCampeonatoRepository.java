package br.com.projetoxp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoxp.model.TimesCampeonato;

public interface TimesCampeonatoRepository extends JpaRepository<TimesCampeonato, Long>{
	List<TimesCampeonato> findByIdCampeonato(Long id);
	TimesCampeonato findByTimeCapitao(String timeCapitao);
	List<TimesCampeonato> findByCapitao(String capitao);
}
