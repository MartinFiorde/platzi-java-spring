package com.platzi.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "compras_productos")
@Getter
@Setter
public class PurchaseProduct {

    @EmbeddedId
    private PurchaseProductPK id;

    @Column(name = "cantidad")
    private Integer quantity;

    private BigDecimal total; // TODO if variable name and column name match, dont need to specify an anotation with column name

    @Column(name = "estado")
    private Boolean state;

}
