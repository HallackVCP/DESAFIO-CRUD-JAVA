package br.com.desafio.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.api.domain.Cliente;
import br.com.desafio.api.repositories.ClienteRepository;
import br.com.desafio.api.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	
	public List<Cliente> findNome(String nome) {
		List<Cliente> lista = repo.findAllByNome(nome);
		int i = lista.size();
		return lista;
	}

}
