package br.com.desafio.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.api.domain.Cidade;
import br.com.desafio.api.domain.enums.EstadoEnum;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
	List<Cidade> findAllByNome(String nome);
	
	List<Cidade> findByEstado(EstadoEnum estado);

}
