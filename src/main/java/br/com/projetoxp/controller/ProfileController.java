package br.com.projetoxp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoxp.model.dto.MatchDto;
import br.com.projetoxp.model.dto.SummonerDto;
import br.com.projetoxp.service.MatchService;
import br.com.projetoxp.service.SummonerService;

@RestController
@RequestMapping("profile")
public class ProfileController {
	
	@Autowired
	private SummonerService summonerService;
	
	@Autowired
	private MatchService matchServices;
	
	@RequestMapping(method = RequestMethod.GET, path = "{name}")
	public List<SummonerDto> profile(@PathVariable String name, Model model) {
		return summonerService.getSummonerByname(name);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "{name}/match/{match}")
	public List<MatchDto> profileMatch(@PathVariable String name, @PathVariable String match) {
		return matchServices.getMatchByname(name, match);
	}

}
