package com.platzi.market.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
@Getter
@Setter
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Long id;

    @Column(name = "id_cliente")
    private String idClient;

    @Column(name = "fecha")
    private LocalDateTime date;

    @Column(name = "medio_pago")
    private String paymentMethod;

    @Column(name = "comentario")
    private Integer comment;

    @Column(name = "estado")
    private String state;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Client client;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseProduct> purchaseProducts;

}
