package br.com.projetoxp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoxp.model.Time;
import br.com.projetoxp.repository.TimeRepository;

@RestController
@RequestMapping("time")
public class TimeController {
	
	@Autowired
	private TimeRepository timeRepository;
	
	@RequestMapping(method = RequestMethod.POST, path = "cadastro")
	public void cadastroCampeonato(@RequestBody Time time) {
		time.setPontuacao(0);
		timeRepository.save(time);
	}

}
