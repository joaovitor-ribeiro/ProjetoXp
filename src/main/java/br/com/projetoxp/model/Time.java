package br.com.projetoxp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.projetoxp.service.TimeService;

@Entity
public class Time {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String timeCapitao;
	private Long    idCampeonato;
	private String nome;
	private String capitao;
	private String jogador2;
	private String jogador3;
	private String jogador4;
	private String jogador5;
	private int    pontuacao;
	private String file;
	
	public Time() {
		super();
	}
	
	public Time(String timeCapitao, Long idCampeonato, String nome, String capitao, String jogador2, String jogador3,
			String jogador4, String jogador5, int pontuacao, String file) {
		super();
		this.timeCapitao = timeCapitao;
		this.idCampeonato = idCampeonato;
		this.nome = nome;
		this.capitao = capitao;
		this.jogador2 = jogador2;
		this.jogador3 = jogador3;
		this.jogador4 = jogador4;
		this.jogador5 = jogador5;
		this.pontuacao = pontuacao;
		this.file = file;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getTimeCapitao() {
		return timeCapitao;
	}

	public void setTimeCapitao(String idTime) {
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

	public void atualizar(Long id, String timeCapitao, TimeService timeService) {
		Time time = timeService.findTime(id, timeCapitao);
		time.setNome(this.nome);
		time.setCapitao(this.capitao);
		time.setTimeCapitao(this.nome + this.capitao);
		time.setJogador2(this.jogador2);
		time.setJogador3(this.jogador3);
		time.setJogador4(this.jogador4);
		time.setJogador5(this.jogador5);
		time.setFile(this.file);
	}


}
