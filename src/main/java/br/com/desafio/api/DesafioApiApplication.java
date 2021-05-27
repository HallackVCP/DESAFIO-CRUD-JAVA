package br.com.desafio.api;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.desafio.api.domain.Cidade;
import br.com.desafio.api.domain.Cliente;
import br.com.desafio.api.domain.enums.EstadoEnum;
import br.com.desafio.api.domain.enums.SexoCliente;
import br.com.desafio.api.repositories.CidadeRepository;
import br.com.desafio.api.repositories.ClienteRepository;

@SpringBootApplication
public class DesafioApiApplication implements CommandLineRunner{
	
	
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	

	public static void main(String[] args) {
		SpringApplication.run(DesafioApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		clienteRepository.deleteAll();
		cidadeRepository.deleteAll();
		
		Cidade c1 = new Cidade(null, "Juiz de Fora", EstadoEnum.MG);
		Cidade c2 = new Cidade(null, "São Paulo",EstadoEnum.SP);
		Cidade c3 = new Cidade(null, "Campinas", EstadoEnum.SP);
		
		
		
		
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "jao", LocalDate.now(), SexoCliente.MASCULINO, 20, c1);
		
		clienteRepository.saveAll(Collections.singletonList(cli1));
		
		
	}
	
	

}
