package com.platzi.market.persistence.entity;

import jakarta.persistence.*;
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

    private BigDecimal total; // if variable name and column name match, don't need to specify an anotation with column name

    @Column(name = "estado")
    private Boolean state;

    @ManyToOne
    // @MapsId("id") // when a purchase is made, MapsId anotation link with the purchase attribute. when PurchaseProducts are saved in cascade from the origin Purchase, it will know the PK for each one
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Product product;

}
