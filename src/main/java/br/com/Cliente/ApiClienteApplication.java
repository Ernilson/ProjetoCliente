package br.com.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.Cliente.Model.ClienteModel;
import br.com.Cliente.Repository.ClienteRepository;

@SpringBootApplication
public class ApiClienteApplication {

	/*
	@Bean
	public CommandLineRunner run( @Autowired ClienteRepository rep) {
		
		return args -> {
			ClienteModel c = ClienteModel.builder().cpf("69779848134").nome("teste").telefone("1234567").build();
			rep.save(c);
		};
	}
	*/
	
	public static void main(String[] args) {
		SpringApplication.run(ApiClienteApplication.class, args);
				
	}

}
