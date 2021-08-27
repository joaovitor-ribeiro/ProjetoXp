package br.com.projetoxp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoxp.model.Usuario;
import br.com.projetoxp.model.dto.UsuarioDto;
import br.com.projetoxp.repository.UsuarioRepository;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	public void cadastro(@RequestBody UsuarioDto requisicao) {
		System.out.println(requisicao);
		Usuario usuario = requisicao.converteUsuario();
		usuarioRepository.save(usuario);
	}

}
