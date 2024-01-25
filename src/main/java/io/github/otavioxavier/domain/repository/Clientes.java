package io.github.otavioxavier.domain.repository;

import io.github.otavioxavier.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clientes {

    private static String INSERT = "insert into cliente (name) values (?)";
    private static String SELECT_ALL = "SELECT * FROM CLIENTE";
    private static String UPDATE = "update cliente set name = ? where id = ?";
    private static String DELETE = "DELETE from cliente where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cliente salvar(Cliente cliente) {
        jdbcTemplate.update(  INSERT, new Object[]{ cliente.getName() } );
        return cliente ;
    }

    public Cliente atualizar(Cliente cliente) {
        jdbcTemplate.update(UPDATE, new Object[] {
                cliente.getName(), cliente.getId() } );
        return cliente;
    }

    public void deletar(Cliente cliente) {
           delete(cliente.getId());
    }

    public void delete(Integer id) {
        jdbcTemplate.update(DELETE, new Object[] { id});
    }

    public List<Cliente> buscarNome(String nome) {
        return jdbcTemplate.query(SELECT_ALL.concat(" where name like ?"),
                new Object[] { "%" + nome + "%" },
                obterClienteMapper());
    }

    public List<Cliente> obterTodos() {
     return jdbcTemplate.query(SELECT_ALL, obterClienteMapper());
    }

    private static RowMapper<Cliente> obterClienteMapper() {
        return new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
                String name = resultSet.getString("name");
                Integer id = resultSet.getInt("id");
                return new Cliente(id, name);
            }
        };
    }
}
