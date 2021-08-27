package br.com.projetoxp.model.dto;

import br.com.projetoxp.model.Usuario;

public class UsuarioDto {
	
	private String nome;
	private String nick;
	private String email;
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Usuario converteUsuario() {
		Usuario usuario = new Usuario(nome, nick, email, senha);
		return usuario;
	}

}
