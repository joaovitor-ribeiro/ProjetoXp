package br.com.projetoxp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TimesCampeonato {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long idCampeonato;
	private String idTime;
	private String nomeTime;
	private String nomeTimePosicao;
	private int posicao;

	public TimesCampeonato() {
		super();
	}
	
	public TimesCampeonato(Long idCampeonato, String idTime, String nomeTime, String nomeTimePosicao, int posicao) {
		super();
		this.idCampeonato = idCampeonato;
		this.idTime = idTime;
		this.nomeTime = nomeTime;
		this.nomeTimePosicao = nomeTimePosicao;
		this.posicao = posicao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCampeonato() {
		return idCampeonato;
	}

	public void setIdCampeonato(Long idCampeonato) {
		this.idCampeonato = idCampeonato;
	}

	public String getIdTime() {
		return idTime;
	}

	public void setIdTime(String idTime) {
		this.idTime = idTime;
	}

	public String getNomeTimePosicao() {
		return nomeTimePosicao;
	}

	public void setNomeTimePosicao(String nomeTime) {
		this.nomeTimePosicao = nomeTime;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public String getNomeTime() {
		return nomeTime;
	}

	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}

	public void atualizar(TimesCampeonato time) {
		time.setPosicao(time.getPosicao() / 2);
	}

}
