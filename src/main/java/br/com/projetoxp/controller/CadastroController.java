package br.com.projetoxp.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.projetoxp.model.Campeonato;
import br.com.projetoxp.model.Usuario;
import br.com.projetoxp.model.dto.UsuarioDto;
import br.com.projetoxp.repository.UsuarioRepository;
import br.com.projetoxp.service.FileUploadService;

@RestController
@RequestMapping("usuario")
@CrossOrigin
public class CadastroController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping(method = RequestMethod.POST, path = "cadastro")
	public void cadastroUsuario(@RequestBody UsuarioDto usuarioDto) {
		Usuario usuario = usuarioDto.converteUsuario();
		usuarioRepository.save(usuario);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/editar/{id}")
	public UsuarioDto getUsuarioById(@PathVariable Long id) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
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
	
	@PostMapping("/upload")
	public void uploadLocal(@RequestParam("file")MultipartFile multipartFile) {
		fileUploadService.uploadToLocal(multipartFile);
	}
	
}
