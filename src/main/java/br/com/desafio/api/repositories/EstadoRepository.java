package br.com.desafio.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.api.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}