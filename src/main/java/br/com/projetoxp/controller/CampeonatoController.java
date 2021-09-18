package br.com.projetoxp.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.projetoxp.model.Campeonato;
import br.com.projetoxp.model.Time;
import br.com.projetoxp.model.TimesCampeonato;
import br.com.projetoxp.model.dto.CampeonatoDto;
import br.com.projetoxp.repository.CampeoantoRepository;
import br.com.projetoxp.repository.TimeRepository;
import br.com.projetoxp.repository.TimesCampeonatoRepository;
import br.com.projetoxp.service.TimeCampeonatoService;
import br.com.projetoxp.service.FileUploadService;

@RestController
@RequestMapping("campeonato")
@CrossOrigin
public class CampeonatoController {
	
	@Autowired
	private CampeoantoRepository campeonatoRepository;
	@Autowired
	private TimeRepository timeRepository;
	@Autowired
	private TimesCampeonatoRepository timesCampeonatoRepository;
	@Autowired
	private TimeCampeonatoService timesCampeonatoService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping(method = RequestMethod.POST, path = "cadastro")
	public void cadastroCampeonato(@RequestBody CampeonatoDto campeonatoDto) {
		Campeonato campeonato = campeonatoDto.converteCampeonato();
		campeonato.setTimesInscritos(0);
		campeonatoRepository.save(campeonato);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "listar")
	public List<Campeonato> listarCampeonato() {
		return campeonatoRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/editar/{id}")
	public CampeonatoDto getCampeonatoById(@PathVariable Long id) {
		Optional<Campeonato> optionalCampeonato = campeonatoRepository.findById(id);
		if(optionalCampeonato.isPresent()) {
			Campeonato campeonato = optionalCampeonato.get();
			return campeonato.converteCampeonatoDto();
		}
		return null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/atualizar/{id}")
	@Transactional
	public void atualizar(@PathVariable Long id, @RequestBody Campeonato campeonato){
		campeonato.atualizar(id, campeonatoRepository);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "cadastro/time/{id}")
	public void cadastroCampeonato(@PathVariable Long id, @RequestBody Time time) {
		Optional<Campeonato> optionalCampeonato = campeonatoRepository.findById(id);
		if(optionalCampeonato.isPresent()) {
			Campeonato campeonato = optionalCampeonato.get();
			
			campeonato.atualizarTimesInscritos(id, campeonatoRepository);
			TimesCampeonato timesCampeonato = timesCampeonatoService.create(campeonato, time);
			
			List<TimesCampeonato> timesInscritos = timesCampeonatoRepository.findByIdCampeonato(id);
			timesCampeonatoService.atualizarPosicao(timesInscritos, campeonato);
			
			timesCampeonatoRepository.save(timesCampeonato);
		}
		timeRepository.save(time);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "participantes/{id}")
	public List<TimesCampeonato> listarCampeonato(@PathVariable Long id) {
		return timesCampeonatoRepository.findByIdCampeonato(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/atualizar/posicao")
	@Transactional
	public void atualizarPosicao(@RequestBody String IdTime){
		TimesCampeonato time;
		time = timesCampeonatoRepository.findByIdTime(IdTime);
		time.atualizar(time);
	}

}
