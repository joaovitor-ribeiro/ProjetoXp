package br.com.projetoxp.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoxp.model.Usuario;
import br.com.projetoxp.model.dto.UsuarioDto;
import br.com.projetoxp.repository.UsuarioRepository;

@RestController
@RequestMapping("usuario")
@CrossOrigin
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PasswordEncoder encoder;
	
	@RequestMapping(method = RequestMethod.POST, path = "cadastro")
	public void cadastroUsuario(@RequestBody UsuarioDto usuarioDto) {
		Usuario usuario = usuarioDto.converteUsuario();
		usuario.setSenha(encoder.encode(usuario.getSenha()));
		usuarioRepository.save(usuario);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/editar/{nick}")
	public UsuarioDto getUsuarioById(@PathVariable String nick) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findByNick(nick);
		if(optionalUsuario.isPresent()) {
			Usuario usuario = optionalUsuario.get();
			return usuario.converteUsuarioDto();
		}
		return null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/atualizar/{id}")
	@Transactional
	public void atualizar(@PathVariable Long id, @RequestBody Usuario usuario){
		usuario.atualizar(id, usuarioRepository);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/login/{nick}/{senha}")
	public boolean login(@PathVariable String nick, @PathVariable String senha) {
		Optional<Usuario> usuario = usuarioRepository.findByNick(nick);
		if(!usuario.isEmpty()) {
			if(encoder.matches(senha, usuario.get().getSenha())) {
				return true;
			}
		}
		return false; 
	}
	
}
