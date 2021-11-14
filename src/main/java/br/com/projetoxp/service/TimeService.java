package br.com.projetoxp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoxp.model.Campeonato;
import br.com.projetoxp.model.Time;
import br.com.projetoxp.model.TimesCampeonato;
import br.com.projetoxp.repository.CampeoantoRepository;
import br.com.projetoxp.repository.TimeRepository;
import br.com.projetoxp.repository.TimesCampeonatoRepository;

@Service
public class TimeService {
	
	@Autowired
	private CampeoantoRepository campeonatoRepository;
	@Autowired
	private TimeRepository timeRepository;
	@Autowired
	private TimesCampeonatoRepository timesCampeonatoRepository;
	@Autowired
	private TimeCampeonatoService timesCampeonatoService;
	
	public int cadastrarNovoTimeNoCampeonato(Long id, Time time) {
		Optional<Campeonato> optionalCampeonato = campeonatoRepository.findById(id);
		if(optionalCampeonato.isPresent()) {
			Campeonato campeonato = optionalCampeonato.get();
			
			List<Time> timeLista = timeRepository.findByCapitao(time.getCapitao());
			
			for (Time time2 : timeLista) {
				if(time2.getIdCampeonato() == id) {
					return 2;
				}
			}
			
			List<TimesCampeonato> timesParticipantes = timesCampeonatoRepository.findByIdCampeonato(id);
			TimesCampeonato timesCampeonato = timesCampeonatoService.create(campeonato, time, timesParticipantes.size() + 1);
			
			timesCampeonatoService.atualizarPosicao(timesParticipantes, campeonato);
			
			timesCampeonatoRepository.save(timesCampeonato);
		}
		time.setPontuacao(0);
		timeRepository.save(time);
		return 1;
	}
	
	public List<TimesCampeonato> listarTimesParticipantes(Long id) {
		return timesCampeonatoRepository.findByIdCampeonato(id);
	}
	
	public List<Time> listarTimes() {
		return timeRepository.findAll();
	}
	
	public void atualizarPosicaoEPontosDoTime(Long id, String timeCapitao){
		TimesCampeonato timescampeonato;
		List<Time> times;
		timescampeonato = timesCampeonatoRepository.findByTimeCapitao(timeCapitao);
		times = timeRepository.findByTimeCapitao(timeCapitao);
		atualizarPontuacao(times, id);
		timescampeonato.setPosicao(timescampeonato.getPosicao() / 2);
	}
	
	public List<Time> findTimeByCapitao(String capitao){
		return timeRepository.findByCapitao(capitao);
	}
	
	public void atualizarPontuacao(List<Time> times, Long id) {
		for (int i = 0; i < times.size(); i++) {
			if(times.get(i).getIdCampeonato() == id) {
				times.get(i).setPontuacao(times.get(i).getPontuacao() + 20);
			}
		}
	}

	public Time findTime(Long id, String timeCapitao) {
		List<Time> times = timeRepository.findByIdCampeonato(id);
		for (Time time : times) {
			if(time.getTimeCapitao().equals(timeCapitao)) {
				return time;
			}
		}
		return null;
	}

	public int atualizarTimeNoCampeonato(Long id, String timeCapitao, Time time) {
		TimesCampeonato timeCampeonato = timesCampeonatoService.findTime(id, timeCapitao);
		int contador = 1;
		List<Time> timeLista = timeRepository.findByCapitao(time.getCapitao());
		for (Time time2 : timeLista) {
			if(time2.getIdCampeonato() == id) {
				contador++;
			}
		}
		if(contador > 2) {
			return 2;
		}
		time.atualizar(id, timeCapitao, this);
		timeCampeonato.atualizar(time, timesCampeonatoRepository);
		return 1;
	}

	public Time getTimeDetalhes(Long id) {
		return timeRepository.findById(id).get();
	}

}
