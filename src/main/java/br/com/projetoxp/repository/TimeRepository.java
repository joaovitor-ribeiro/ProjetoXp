package br.com.projetoxp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetoxp.model.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long>{
	List<Time> findByTimeCapitao(String timeCapitao);
	List<Time> findByCapitao(String Capitao);
	List<Time> findByIdCampeonato(Long id);
}
