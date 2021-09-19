package br.com.projetoxp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.projetoxp.model.dto.CampeonatoDto;
import br.com.projetoxp.repository.CampeoantoRepository;

@Entity
public class Campeonato {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String dataInicio;
	private String dataTermino;
	private int time;
	private Double premiacao;
	private String adm;
	private String descricao;
	private String regra;
	private int timesInscritos;
	private String file;
	
	public Campeonato() {
		super();
	}
	
	public Campeonato(String nome, String dataInicio, String dataTermino, int time, Double premiacao, String adm,
			String descricao, String regra, String file) {
		super();
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.time = time;
		this.premiacao = premiacao;
		this.adm = adm;
		this.descricao = descricao;
		this.regra = regra;
		this.file = file;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Double getPremiacao() {
		return premiacao;
	}

	public void setPremiacao(Double premiacao) {
		this.premiacao = premiacao;
	}

	public String getAdm() {
		return adm;
	}

	public void setAdm(String adm) {
		this.adm = adm;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public String getRegra() {
		return regra;
	}

	public void setRegra(String regra) {
		this.regra = regra;
	}
	
	public int getTimesInscritos() {
		return timesInscritos;
	}
	
	public void setTimesInscritos(int timesInscritos) {
		this.timesInscritos = timesInscritos;
	}
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public CampeonatoDto converteCampeonatoDto() {
		CampeonatoDto campeonatoDto = new CampeonatoDto(nome, dataInicio, dataTermino, time, premiacao, adm, descricao, regra, file);
		return campeonatoDto;
	}
	
	public void atualizar(Long id, CampeoantoRepository campeonatoRepository) {
		Campeonato campeonato = campeonatoRepository.getById(id);
		campeonato.setNome(this.nome);
		campeonato.setTime(this.time);
		campeonato.setAdm(this.adm);
		campeonato.setDescricao(this.descricao);
		campeonato.setRegra(this.regra);
		campeonato.setFile(this.file);
	}

	public void atualizarTimesInscritos(Long id, CampeoantoRepository campeonatoRepository) {
		Campeonato campeonato = campeonatoRepository.getById(id);
		if(campeonato.getTimesInscritos() >= 1) {
			campeonato.setTimesInscritos(campeonato.getTimesInscritos() + 1);
		}else {
			campeonato.setTimesInscritos(1);
		}
	}


}
