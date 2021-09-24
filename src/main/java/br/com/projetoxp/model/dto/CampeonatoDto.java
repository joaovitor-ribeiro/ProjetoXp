package br.com.projetoxp.model.dto;

import br.com.projetoxp.model.Campeonato;

public class CampeonatoDto {
	
	private String nome;
	private String dataInicio;
	private String dataTermino;
	private int time;
	private Double premiacao;
	private String adm;
	private String descricao;
	private String regra;
	private String file;
	
	public CampeonatoDto() {
		super();
	}
	
	public CampeonatoDto(String nome, String dataInicio, String dataTermino, int time, Double premiacao, String adm,
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
	
	public String getNome() {
		return nome;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public String getDataTermino() {
		return dataTermino;
	}
	public int getTime() {
		return time;
	}
	public Double getPremiacao() {
		return premiacao;
	}
	public String getAdm() {
		return adm;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getRegra() {
		return regra;
	}
	
	public String getFile() {
		return file;
	}
	
	public Campeonato converteCampeonato() {
		Campeonato campeonato = new Campeonato(nome, dataInicio, dataTermino, time, premiacao, adm, descricao, regra, file);
		return campeonato;
	}
	
}
