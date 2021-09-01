package br.com.projetoxp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.projetoxp.model.Usuario;
import br.com.projetoxp.model.dto.UsuarioDto;
import br.com.projetoxp.repository.UsuarioRepository;
import br.com.projetoxp.service.FileUploadService;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@PostMapping
	public void cadastro(@RequestBody UsuarioDto requisicaoUsuario) {
		Usuario usuario = requisicaoUsuario.converteUsuario();
		usuarioRepository.save(usuario);
	}
	
	@PostMapping("/upload")
	public void uploadLocal(@RequestParam("file")MultipartFile multipartFile) {
		fileUploadService.uploadToLocal(multipartFile);
	}
	
}
