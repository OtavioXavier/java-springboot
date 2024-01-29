package io.github.otavioxavier.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table( name = "produto")
public class Pedido {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column( name = "id" )
    private Integer id;

    @ManyToOne //Um cliente pode ter muitos pedidos
    @JoinColumn( name = "id_cliente") //estabelecendo conexão de tabelas
    private Cliente client;

    @Column( name = "date_pedido" )
    private LocalDate datePedido;

    @Column( name = "total", length = 20, precision = 2)
    private BigDecimal total;

    @OneToMany( mappedBy = "pedido")
    private List<ItemPedido> itens;

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public LocalDate getDatePedido() {
        return datePedido;
    }

    public void setDatePedido(LocalDate datePedido) {
        this.datePedido = datePedido;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
