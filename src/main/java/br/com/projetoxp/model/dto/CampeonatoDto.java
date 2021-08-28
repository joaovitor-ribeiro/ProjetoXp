package br.com.projetoxp.model.dto;

import java.util.Date;
import br.com.projetoxp.model.Campeonato;

public class CampeonatoDto {
	
	private String nome;
	private Date dataInicio;
	private Date dataTermino;
	private int time;
	private Double premiacao;
	private String adm;
	private String regra;
	private String file;
	
	public CampeonatoDto() {
		super();
	}
	
	public CampeonatoDto(String nome, Date dataInicio, Date dataTermino, int time, Double premiacao, String adm,
			String regra, String file) {
		super();
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.time = time;
		this.premiacao = premiacao;
		this.adm = adm;
		this.regra = regra;
		this.file = file;
	}
	
	public String getNome() {
		return nome;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public Date getDataTermino() {
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
	public String getRegra() {
		return regra;
	}
	public String getFile() {
		return file;
	}
	
	public Campeonato converteCampeonato() {
		Campeonato campeonato = new Campeonato(nome, dataInicio, dataTermino, time, premiacao, adm, regra, file);
		return campeonato;
	}

}
