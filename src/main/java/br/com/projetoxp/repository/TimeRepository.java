package br.com.projetoxp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetoxp.model.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long>{

}
