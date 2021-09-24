package br.com.projetoxp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoxp.model.Campeonato;
import br.com.projetoxp.model.dto.CampeonatoDto;
import br.com.projetoxp.repository.CampeoantoRepository;

@Service
public class CampeonatoService {
	
	@Autowired
	private CampeoantoRepository campeonatoRepository;
	
	public void cadastrarCampeonato(CampeonatoDto campeonatoDto) {
		Campeonato campeonato = campeonatoDto.converteCampeonato();
		campeonatoRepository.save(campeonato);
	}
	
	public List<Campeonato> listarCampeonatos() {
		return campeonatoRepository.findAll();
	}
	
	public CampeonatoDto getCampeonatoById(Long id) {
		Optional<Campeonato> optionalCampeonato = campeonatoRepository.findById(id);
		if(optionalCampeonato.isPresent()) {
			Campeonato campeonato = optionalCampeonato.get();
			return campeonato.converteCampeonatoDto();
		}
		return null;
	}
	
	public void atualizar(Long id, Campeonato campeonato){
		campeonato.atualizar(id, campeonatoRepository);
	}
	
}
