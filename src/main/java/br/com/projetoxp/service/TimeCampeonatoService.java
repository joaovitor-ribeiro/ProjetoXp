package br.com.projetoxp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.projetoxp.model.Campeonato;
import br.com.projetoxp.model.Time;
import br.com.projetoxp.model.TimesCampeonato;

@Service
public class TimeCampeonatoService {
	
	public TimesCampeonato create(Campeonato campeonato, Time time) {
		TimesCampeonato timesCampeonato = new TimesCampeonato(campeonato.getId(), time.getId(), time.getNome(), time.getNome() + "-" + campeonato.getTime(), campeonato.getTimesInscritos());
		return timesCampeonato;
	}

	public void atualizarPosicao(List<TimesCampeonato> timesInscritos, Campeonato campeonato) {
		for (TimesCampeonato timesCampeonato : timesInscritos) {
			timesCampeonato.setPosicao(campeonato.getTimesInscritos());
		}
	}

}
