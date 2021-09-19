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
	private String timeCapitao;
	private String nomeTime;
	private String capitao;
	private int posicao;

	public TimesCampeonato() {
		super();
	}
	
	public TimesCampeonato(Long idCampeonato, String timeCapitao, String nomeTime, String capitao, int posicao) {
		super();
		this.idCampeonato = idCampeonato;
		this.timeCapitao = timeCapitao;
		this.nomeTime = nomeTime;
		this.capitao = capitao;
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

	public String getTimeCapitao() {
		return timeCapitao;
	}

	public void setTimeCapitao(String timeCapitao) {
		this.timeCapitao = timeCapitao;
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

	public String getCapitao() {
		return capitao;
	}

	public void setCapitao(String capitao) {
		this.capitao = capitao;
	}

}
