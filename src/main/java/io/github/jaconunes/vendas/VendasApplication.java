package io.github.jaconunes.vendas;

import io.github.jaconunes.vendas.domain.entities.Cliente;
import io.github.jaconunes.vendas.domain.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner commandLineRunner(@Autowired ClientesRepository clientes){
		return args -> {
			Cliente cliente = new Cliente(null,"Fulano");
			clientes.save(cliente);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}


}
