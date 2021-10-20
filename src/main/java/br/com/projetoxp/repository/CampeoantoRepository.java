package br.com.projetoxp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoxp.model.Campeonato;

public interface CampeoantoRepository extends JpaRepository<Campeonato, Long>{
//	Optional<Campeonato> findByNome(String nome);
	List<Optional<Campeonato>> findByNome(String nome);
}
