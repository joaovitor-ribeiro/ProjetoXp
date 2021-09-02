package br.com.projetoxp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.projetoxp.model.dto.UsuarioDto;
import br.com.projetoxp.repository.CampeoantoRepository;
import br.com.projetoxp.repository.UsuarioRepository;

@Entity
public class Usuario {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String nick;
	private String email;
	private String senha;
	private String file;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String nome, String nick, String email, String senha, String file) {
		super();
		this.nome = nome;
		this.nick = nick;
		this.email = email;
		this.senha = senha;
		this.file = file;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public UsuarioDto converteUsuarioDto() {
		UsuarioDto usuarioDto = new UsuarioDto(nome, nick, email, senha, file);
		return usuarioDto;
	}
	
	public void atualizar(Long id, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.getById(id);
		usuario.setNome(this.nome);
		usuario.setNick(this.nick);
		usuario.setEmail(this.email);
		usuario.setSenha(this.senha);
		usuario.setFile(this.file);
	}
	
}
