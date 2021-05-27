package br.com.desafio.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.api.domain.Cliente;
import br.com.desafio.api.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		
		Cliente obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	
	}
	
//	@RequestMapping(value="/{nome}", method = RequestMethod.GET)
//	public ResponseEntity<Cliente> findNome(@PathVariable Integer id) {
//		
//		Cliente obj = service.findNome(obj.getNome());
//		
//		return ResponseEntity.ok().body(obj);
//	
//	}
	
	
	

}
