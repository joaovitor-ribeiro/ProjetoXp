package br.com.projetoxp.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoxp.model.Usuario;
import br.com.projetoxp.model.dto.UsuarioDto;
import br.com.projetoxp.service.UsuarioService;

@RestController
@RequestMapping("usuario")
@CrossOrigin
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.POST, path = "cadastro")
	public void cadastroUsuario(@RequestBody UsuarioDto usuarioDto) {
		usuarioService.cadastrarUsuario(usuarioDto);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/editar/{nick}")
	public UsuarioDto getUsuarioById(@PathVariable String nick) {
		return usuarioService.getUsuarioById(nick);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/atualizar/{nick}")
	@Transactional
	public void atualizar(@PathVariable String nick, @RequestBody Usuario usuario){
		usuarioService.atualizar(nick, usuario);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/login/{nick}/{senha}")
	public UsuarioDto login(@PathVariable String nick, @PathVariable String senha) {
		return usuarioService.login(nick, senha);
	}
}
