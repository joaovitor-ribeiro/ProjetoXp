package br.com.projetoxp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoxp.client.MatchClient;
import br.com.projetoxp.client.MatchInformationClient;
import br.com.projetoxp.client.SummonerClient;
import br.com.projetoxp.model.Match;
import br.com.projetoxp.model.Summoner;
import br.com.projetoxp.model.dto.SummonerDto;

@Service
public class SummonerService {
	
	@Autowired
	private SummonerClient summonerClient;
	@Autowired
	private MatchClient matchClient;
	@Autowired
	private MatchInformationClient matchInformationClient;

	public List<SummonerDto> getSummonerByname(String name) {
		List<Match>   	  matchInfo      = new ArrayList<Match>();
		List<SummonerDto> summerDto      = new ArrayList<SummonerDto>();
		Summoner      	  summoner       = summonerClient.getSummonerByName(name);
		List<String>      matchs;
		
		if(summoner != null) {
			
			matchs = matchClient.getMatchByName(summoner.getPuuid());
			matchInformationClient.litaMatchInformation(matchInfo, matchs);
			summerDto = summonerClient.listaSummerDto(summoner, matchInfo, summoner.getName());

			return summerDto;
		}
		
		return null;
	}

}
