package io.github.otavioxavier;

import io.github.otavioxavier.domain.entity.Cliente;
import io.github.otavioxavier.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes) {
        return args -> {
            System.out.println("Salvado");
            clientes.save(new Cliente( "Cibele"));
            clientes.save(new Cliente("Otavio"));

            List<Cliente> result = clientes.encontraPorNome("Cibele");
            result.forEach(System.out::println);

        };
    }

    public static void main(String[] args) {
       SpringApplication.run(VendasApplication.class, args);
    }
}