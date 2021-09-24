package br.com.projetoxp.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoxp.model.Campeonato;
import br.com.projetoxp.model.dto.CampeonatoDto;
import br.com.projetoxp.service.CampeonatoService;

@RestController
@RequestMapping("campeonato")
@CrossOrigin
public class CampeonatoController {
	
	@Autowired
	private CampeonatoService campeonatoService;
	
	@RequestMapping(method = RequestMethod.POST, path = "cadastro")
	public void cadastroCampeonato(@RequestBody CampeonatoDto campeonatoDto) {
		campeonatoService.cadastrarCampeonato(campeonatoDto);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "listar")
	public List<Campeonato> listarCampeonatos() {
		return campeonatoService.listarCampeonatos();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/editar/{id}")
	public CampeonatoDto getCampeonatoById(@PathVariable Long id) {
		return campeonatoService.getCampeonatoById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/atualizar/{id}")
	@Transactional
	public void atualizar(@PathVariable Long id, @RequestBody Campeonato campeonato){
		campeonatoService.atualizar(id, campeonato);
	}
	
}
