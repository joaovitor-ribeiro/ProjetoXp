package br.com.projetoxp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.projetoxp.model.Time;


@Service
public class TimeService {
	
	public void atualizarPontuacao(List<Time> times, Long id) {
		for (int i = 0; i < times.size(); i++) {
			if(times.get(i).getIdCampeonato() == id) {
				times.get(i).setPontuacao(times.get(i).getPontuacao() + 20);
			}
		}
	}

}
