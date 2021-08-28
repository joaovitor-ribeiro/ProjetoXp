package br.com.projetoxp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Campeonato {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Date dataInicio;
	private Date dataTermino;
	private int time;
	private Double premiacao;
	private String adm;
	private String regra;
	private String file;
	
	public Campeonato() {
		super();
	}
	
	public Campeonato(String nome, Date dataInicio, Date dataTermino, int time, Double premiacao, String adm,
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
	
	public Long getId() {
		return id;
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

}
