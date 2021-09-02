package br.com.projetoxp.model.dto;

import br.com.projetoxp.model.Usuario;

public class UsuarioDto {
	
	private String nome;
	private String nick;
	private String email;
	private String senha;
	private String file;
	
	public UsuarioDto() {
		super();
	}
	
	public UsuarioDto(String nome, String nick, String email, String senha, String file) {
		super();
		this.nome = nome;
		this.nick = nick;
		this.email = email;
		this.senha = senha;
		this.file = file;
	}

	public String getNome() {
		return nome;
	}
	public String getNick() {
		return nick;
	}
	public String getEmail() {
		return email;
	}
	public String getSenha() {
		return senha;
	}
	public String getFile() {
		return file;
	}
	
	public Usuario converteUsuario() {
		Usuario usuario = new Usuario(nome, nick, email, senha, file);
		return usuario;
	}

}
