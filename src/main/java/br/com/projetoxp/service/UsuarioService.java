package br.com.projetoxp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.projetoxp.model.Usuario;
import br.com.projetoxp.model.dto.SenhaDto;
import br.com.projetoxp.model.dto.UsuarioDto;
import br.com.projetoxp.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PasswordEncoder encoder;
	
	public boolean cadastrarUsuario(UsuarioDto usuarioDto) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findByNick(usuarioDto.getNick());
		if(optionalUsuario.isEmpty()) {
			Usuario usuario = usuarioDto.converteUsuario();
			usuario.setSenha(encoder.encode(usuario.getSenha()));
			usuarioRepository.save(usuario);
			return true;
		}
		return false;
	}
	
	public UsuarioDto getUsuarioById(String nick) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findByNick(nick);
		if(optionalUsuario.isPresent()) {
			Usuario usuario = optionalUsuario.get();
			return usuario.converteUsuarioDto();
		}
		return null;
	}
	
	public void atualizar( String nick, Usuario usuario){
		usuario.atualizar(nick,usuarioRepository);
	}
	
	public UsuarioDto login( String nick, String senha) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findByNick(nick);
		if(!optionalUsuario.isEmpty()) {
			if(encoder.matches(senha, optionalUsuario.get().getSenha())) {
				Usuario usuario = optionalUsuario.get();
				return usuario.converteUsuarioDto();
			}
			return null;
		}
		return null; 
	}
	
	public int alterarSenha( String nick, SenhaDto senhadto) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findByNick(nick);
		if(!optionalUsuario.isEmpty()) {
			if(encoder.matches(senhadto.getSenhaAntiga(), optionalUsuario.get().getSenha())) {
				Usuario usuario = optionalUsuario.get();
				usuario.setSenha(encoder.encode(senhadto.getSenhaNova()));
				usuario.atualizar(nick,usuarioRepository);
				return 1;
			} else {
				return 2;
			}
		}
		return 3; 
	}
}
