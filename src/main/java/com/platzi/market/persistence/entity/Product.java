package com.platzi.market.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "productos")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id; // TODO use class wrappers, not primitives (Integer over int in this case) to avoid errors with null values in DB

    @Column(name = "nombre")
    private String name;

    @Column(name = "id_categoria")
    private Long idCategory; // TODO for ids, its recomended to use Long over Integers, because rows in ral production enviroments can surpass Integer limit easly

    @Column(name = "codigo_barras")
    private String barCode;

    @Column(name = "precio_venta")
    private BigDecimal sellPrice; // TODO https://dzone.com/articles/never-use-float-and-double-for-monetary-calculatio

    @Column(name = "cantidad_stock")
    private Integer stockQuantity;

    @Column(name = "estado")
    private Boolean state;

    @ManyToOne
    @JoinColumn( name = "id_categoria", insertable = false, updatable = false) //TODO insertable and updatable on false avoid making changes on category table from a product. need to change directly from their asociated category class
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<PurchaseProduct> purchaseProducts;
}
