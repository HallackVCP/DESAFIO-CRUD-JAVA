package br.com.desafio.api.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.desafio.api.domain.Cidade;
import br.com.desafio.api.domain.Cliente;
import br.com.desafio.api.domain.enums.EstadoEnum;
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
	@GetMapping(value="/estado")
	public ResponseEntity<List<Cidade>> findEstado(@RequestParam EstadoEnum estado){
		return ResponseEntity.ok().body(service.findEstado(estado));
	}
	
	
	
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Cidade obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	

}
