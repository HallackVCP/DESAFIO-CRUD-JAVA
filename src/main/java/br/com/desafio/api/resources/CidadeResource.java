package br.com.desafio.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.api.domain.Cidade;
import br.com.desafio.api.services.CidadeService;



@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {
	
	
	@Autowired
	private CidadeService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Cidade> find(@PathVariable Integer id) {
		
		Cidade obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	
	}
	@GetMapping(value="/procurada")
	public ResponseEntity<List<Cidade>> findNome(@RequestParam String nome) {
		return ResponseEntity.ok().body(service.findNome(nome));
	
	}
	

}
