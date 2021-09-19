package br.com.projetoxp.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoxp.model.Campeonato;
import br.com.projetoxp.model.Time;
import br.com.projetoxp.model.TimesCampeonato;
import br.com.projetoxp.repository.CampeoantoRepository;
import br.com.projetoxp.repository.TimeRepository;
import br.com.projetoxp.repository.TimesCampeonatoRepository;
import br.com.projetoxp.service.TimeCampeonatoService;
import br.com.projetoxp.service.TimeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("time")
public class TimeController {
	
	@Autowired
	private CampeoantoRepository campeonatoRepository;
	@Autowired
	private TimeRepository timeRepository;
	@Autowired
	private TimesCampeonatoRepository timesCampeonatoRepository;
	@Autowired
	private TimeCampeonatoService timesCampeonatoService;
	@Autowired
	private TimeService timeSerivice;
	
	@RequestMapping(method = RequestMethod.POST, path = "cadastro/{id}")
	public void cadastroTimeNoCampeonato(@PathVariable Long id, @RequestBody Time time) {
		Optional<Campeonato> optionalCampeonato = campeonatoRepository.findById(id);
		if(optionalCampeonato.isPresent()) {
			Campeonato campeonato = optionalCampeonato.get();
			
			List<TimesCampeonato> timesParticipantes = timesCampeonatoRepository.findByIdCampeonato(id);
			TimesCampeonato timesCampeonato = timesCampeonatoService.create(campeonato, time, timesParticipantes.size() + 1);
			
			timesCampeonatoService.atualizarPosicao(timesParticipantes, campeonato);
			
			timesCampeonatoRepository.save(timesCampeonato);
		}
		time.setPontuacao(0);
		timeRepository.save(time);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "participantes/{id}")
	public List<TimesCampeonato> listarTimesParticipantes(@PathVariable Long id) {
		return timesCampeonatoRepository.findByIdCampeonato(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/atualizar/posicao/{id}")
	@Transactional
	public void atualizarPosicao(@PathVariable Long id, @RequestBody String timeCapitao){
		TimesCampeonato timescampeonato;
		List<Time> times;
		timescampeonato = timesCampeonatoRepository.findByTimeCapitao(timeCapitao);
		times = timeRepository.findByTimeCapitao(timeCapitao);
		timeSerivice.atualizarPontuacao(times, id);
		timescampeonato.setPosicao(timescampeonato.getPosicao() / 2);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "listar")
	public List<Time> listarTodosTimes() {
		return timeRepository.findAll();
	}

}
