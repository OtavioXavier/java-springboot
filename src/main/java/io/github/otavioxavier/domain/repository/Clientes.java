package io.github.otavioxavier.domain.repository;

import io.github.otavioxavier.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    @Query(value = " select * from Cliente c where c.name like '%name%' ", nativeQuery = true)
    List<Cliente> encontraPorNome( @Param("name") String name );

    @Query( " delete from Cliente c where c.name =:name ")
    @Modifying //Obrigatorio para atualização em tabelas
    void deleteByName(String name);

    boolean existsByName(String name);

}
