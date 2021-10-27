package br.com.projetoxp.service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	public int cadastrarCampeonato(CampeonatoDto campeonatoDto) {
		try {
			List<Optional<Campeonato>> optionalCampeonato = campeonatoRepository.findByNome(campeonatoDto.getNome());
			if(optionalCampeonato.isEmpty()) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				
				Date date1;
				Date date2;
				Date dateHoje = new Date();
				
				date1 = dateFormat.parse(campeonatoDto.getDataInicio());
				date2 = dateFormat.parse(campeonatoDto.getDataTermino());
				
				if(!(date1.compareTo(date2) < 0)  ||  !(dateHoje.compareTo(date2) < 0)){
					return 2;
				} 
				Campeonato campeonato = campeonatoDto.converteCampeonato();
				campeonatoRepository.save(campeonato);
				return 3;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 1;
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
	
	public int atualizar(Long id, Campeonato campeonato){
		try {
			Campeonato campeonatoId = campeonatoRepository.getById(id);
			if(!campeonatoId.getNome().equals(campeonato.getNome())) {
				List<Optional<Campeonato>> optionalCampeonato = campeonatoRepository.findByNome(campeonato.getNome());
				if(!optionalCampeonato.isEmpty()) {
					return 1;
				}
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date1;
			Date date2;
			Date dateHoje = new Date();

			date1 = dateFormat.parse(campeonato.getDataInicio());
			date2 = dateFormat.parse(campeonato.getDataTermino());
			if(!(date1.compareTo(date2) < 0)  ||  !(dateHoje.compareTo(date2) < 0)){
				return 2;
			} 
			campeonato.atualizar(id, campeonatoRepository);
			return 3;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
	
}
