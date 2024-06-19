package com.platzi.market.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "productos")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id; // use class wrappers, not primitives (Integer over int in this case)

    @Column(name = "nombre")
    private String name;

    @Column(name = "id_categoria")
    private Integer idCategory;

    @Column(name = "codigo_barras")
    private String barCode;

    @Column(name = "precio_venta")
    private BigDecimal sellPrice; // https://dzone.com/articles/never-use-float-and-double-for-monetary-calculatio

    @Column(name = "cantidad_stock")
    private Integer stockQuantity;

    //@Column(name = "estado") // No hace falta especificar el nombre si nombre de clase y nombre de columna coinciden
    private Boolean estado;

}
