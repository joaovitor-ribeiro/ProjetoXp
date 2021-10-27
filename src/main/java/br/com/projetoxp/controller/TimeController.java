package br.com.projetoxp.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoxp.model.Time;
import br.com.projetoxp.model.TimesCampeonato;
import br.com.projetoxp.service.TimeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("time")
public class TimeController {
	
	@Autowired
	private TimeService timeService;
	
	@RequestMapping(method = RequestMethod.POST, path = "cadastro/{id}")
	public int cadastrarTimeNoCampeonato(@PathVariable Long id, @RequestBody Time time) {
		return timeService.cadastrarNovoTimeNoCampeonato(id, time);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "editar/{id}/{timeCapitao}")
	@Transactional
	public int editarTime(@PathVariable Long id, @PathVariable String timeCapitao, @RequestBody Time time) {
		return timeService.atualizarTimeNoCampeonato(id, timeCapitao, time);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "participantes/{id}")
	public List<TimesCampeonato> listarTimesParticipantes(@PathVariable Long id) {
		return timeService.listarTimesParticipantes(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/atualizar/posicao/{id}")
	@Transactional
	public void atualizarPosicaoEPontos(@PathVariable Long id, @RequestBody String timeCapitao){
		timeService.atualizarPosicaoEPontosDoTime(id, timeCapitao);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "listar")
	public List<Time> listarTimes() {
		return timeService.listarTimes();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "listar/{capitao}")
	public List<Time> listarTimes(@PathVariable String capitao) {
		return timeService.findTimeByCapitao(capitao);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "{id}/{timeCapitao}")
	public Time listarTimes(@PathVariable Long id, @PathVariable String timeCapitao) {
		return timeService.findTime(id, timeCapitao);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/detalhes/{id}")
	public Time getTimeDetalhes(@PathVariable Long id) {
		return timeService.getTimeDetalhes(id);
	}

}
