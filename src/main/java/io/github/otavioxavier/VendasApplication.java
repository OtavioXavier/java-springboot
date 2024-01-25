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
            clientes.salvar(new Cliente( "Cibele"));
            clientes.salvar(new Cliente("Otavio"));

            System.out.println("Mostrar");
            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);


            System.out.println("Atualizando");
            todosClientes.forEach( cliente -> {
                cliente.setName(cliente.getName() + " Atualizado");
                clientes.atualizar(cliente);
            });

            System.out.println("Buscando por nome");
            clientes.buscarNome("Ci").forEach(System.out::println);

//            System.out.println("Deletando clientes");
//            clientes.obterTodos().forEach(cliente -> {
//                clientes.deletar(cliente);
//            });

            todosClientes = clientes.obterTodos();
            if(todosClientes.isEmpty()) {
                System.out.println("Não há clientes");
            } else {
            todosClientes.forEach(System.out::println);
            }
        };
    }

    public static void main(String[] args) {
       SpringApplication.run(VendasApplication.class, args);
    }
}