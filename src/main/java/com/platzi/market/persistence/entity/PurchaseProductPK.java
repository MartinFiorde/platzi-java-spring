package com.platzi.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class PurchaseProductPK implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L; // TODO https://dzone.com/articles/what-is-serialversionuid

    @Column(name = "id_compra")
    private Long idPurchase;

    @Column(name = "id_producto")
    private Long idProduct;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseProductPK that = (PurchaseProductPK) o;
        return Objects.equals(idPurchase, that.idPurchase) && Objects.equals(idProduct, that.idProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPurchase, idProduct);
    }
}
