package br.com.desafio.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.api.domain.Cliente;
import br.com.desafio.api.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		
		Cliente obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	
	}
	
	@GetMapping(value="/procurado")
	public ResponseEntity<List<Cliente>> findNome(@RequestParam String nome) {
		
		
		
		return ResponseEntity.ok().body(service.findNome(nome));
	
	}
	
	
	

}
