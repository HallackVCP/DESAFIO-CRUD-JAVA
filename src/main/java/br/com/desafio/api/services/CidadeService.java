package br.com.desafio.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.api.domain.Cidade;
import br.com.desafio.api.domain.Cliente;
import br.com.desafio.api.repositories.CidadeRepository;
import br.com.desafio.api.services.exceptions.ObjectNotFoundException;


@Service
public class CidadeService {
	
	
	@Autowired
	CidadeRepository repo;

	public Cidade find(Integer id) {
		Optional<Cidade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	
	}

}
