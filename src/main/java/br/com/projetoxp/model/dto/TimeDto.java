package br.com.projetoxp.model.dto;

import br.com.projetoxp.model.Time;

public class TimeDto {
	
	private String timeCapitao;
	private Long   idCampeonato;
	private String nome;
	private String capitao;
	private String jogador2;
	private String jogador3;
	private String jogador4;
	private String jogador5;
	private int    pontuacao;
	private String file;
	
	public TimeDto() {
		super();
	}

	public String getIdTime() {
		return timeCapitao;
	}

	public void setIdTime(String idTime) {
		this.timeCapitao = idTime;
	}
	public Long getIdCampeonato() {
		return idCampeonato;
	}
	
	public void setIdCampeonato(Long idCampeonato) {
		this.idCampeonato = idCampeonato;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCapitao() {
		return capitao;
	}
	public void setCapitao(String capitao) {
		this.capitao = capitao;
	}
	public String getJogador2() {
		return jogador2;
	}
	public void setJogador2(String jogador2) {
		this.jogador2 = jogador2;
	}
	public String getJogador3() {
		return jogador3;
	}
	public void setJogador3(String jogador3) {
		this.jogador3 = jogador3;
	}
	public String getJogador4() {
		return jogador4;
	}
	public void setJogador4(String jogador4) {
		this.jogador4 = jogador4;
	}
	public String getJogador5() {
		return jogador5;
	}
	public void setJogador5(String jogador5) {
		this.jogador5 = jogador5;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Time converteTime() {
		Time time = new Time(timeCapitao, idCampeonato, nome, capitao, jogador2, jogador3, jogador4, jogador5, pontuacao, file);
		return time;
	}
	
}
