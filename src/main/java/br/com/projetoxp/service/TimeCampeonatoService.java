package br.com.projetoxp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoxp.model.Campeonato;
import br.com.projetoxp.model.Time;
import br.com.projetoxp.model.TimesCampeonato;
import br.com.projetoxp.repository.TimesCampeonatoRepository;

@Service
public class TimeCampeonatoService {
	
	@Autowired
	private TimesCampeonatoRepository timesCampeonatoRepository;
	
	public TimesCampeonato create(Campeonato campeonato, Time time, int posicao) {
		TimesCampeonato timesCampeonato = new TimesCampeonato(campeonato.getId(), time.getTimeCapitao(), time.getNome(), time.getCapitao(), posicao);
		return timesCampeonato;
	}

	public void atualizarPosicao(List<TimesCampeonato> timesParticipantes, Campeonato campeonato) {
		for (TimesCampeonato timesCampeonato : timesParticipantes) {
			timesCampeonato.setPosicao(timesCampeonato.getPosicao() + 1);
		}
	}
	
	public TimesCampeonato findTime(Long id, String timeCapitao) {
		List<TimesCampeonato> times = timesCampeonatoRepository.findByIdCampeonato(id);
		for (TimesCampeonato time : times) {
			if(time.getTimeCapitao().equals(timeCapitao)) {
				return time;
			}
		}
		return null;
	}

}
