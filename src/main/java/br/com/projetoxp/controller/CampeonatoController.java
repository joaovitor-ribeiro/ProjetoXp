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
import br.com.projetoxp.model.dto.CampeonatoDto;
import br.com.projetoxp.repository.CampeoantoRepository;
import br.com.projetoxp.service.FileUploadService;

@RestController
@RequestMapping("campeonato")
@CrossOrigin
public class CampeonatoController {
	
	@Autowired
	private CampeoantoRepository campeonatoRepository;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping(method = RequestMethod.POST, path = "cadastro")
	public void cadastroCampeonato(@RequestBody CampeonatoDto campeonatoDto) {
		Campeonato campeonato = campeonatoDto.converteCampeonato();
		campeonatoRepository.save(campeonato);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "listar")
	public List<Campeonato> listarCampeonato() {
		return campeonatoRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/editar/{id}")
	public CampeonatoDto getCampeonatoById(@PathVariable Long id) {
		Optional<Campeonato> optionalCampeonato = campeonatoRepository.findById(id);
		if(optionalCampeonato.isPresent()) {
			Campeonato campeonato = optionalCampeonato.get();
			return campeonato.converteCampeonatoDto();
		}
		return null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/atualizar/{id}")
	@Transactional
	public void atualizar(@PathVariable Long id, @RequestBody Campeonato campeonato){
		campeonato.atualizar(id, campeonatoRepository);
	}

	@PostMapping("/upload")
	public void uploadLocal(@RequestParam("file")MultipartFile multipartFile) {
		fileUploadService.uploadToLocal(multipartFile);
	}
	
}
