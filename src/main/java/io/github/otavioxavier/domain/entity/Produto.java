package io.github.otavioxavier.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table( name = "Produto" )
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "id" )
    private Integer id;

    @Column( name = "description")
    private String description;

    @Column( name = "unit_price" )
    private BigDecimal unitPrice;

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
