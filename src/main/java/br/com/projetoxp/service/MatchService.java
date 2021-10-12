package br.com.projetoxp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoxp.client.MatchInformationClient;
import br.com.projetoxp.model.Match;
import br.com.projetoxp.model.dto.MatchDto;

@Service
public class MatchService {
	
	@Autowired
	private MatchInformationClient matchInformationClient;
	
	public List<MatchDto> getMatchByname(String name, String partida) {
		Match          match    = matchInformationClient.getMatchInformation(partida);
		List<MatchDto> matchDto = matchInformationClient.listaMatchDto(name, match);
		
		matchInformationClient.ordenando(matchDto);
		
		return matchDto;
	}
}
