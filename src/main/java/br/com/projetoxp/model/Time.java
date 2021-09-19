package br.com.projetoxp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Time {
	
	@Id
	private String id;
	private String nome;
	private String capitao;
	private String jogador2;
	private String jogador3;
	private String jogador4;
	private String jogador5;
	private int   pontuacao;
	private String file;
	
	public Time() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

}
