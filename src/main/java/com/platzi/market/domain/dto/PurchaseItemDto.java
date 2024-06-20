package com.platzi.market.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PurchaseItemDto {
    private Long productId;
    private Integer quantity;
    private BigDecimal total;
    private Boolean active;
}
