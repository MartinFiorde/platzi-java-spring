package com.platzi.market.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto {
    private long productId;
    private String name;
    private long categoryId;
    private BigDecimal price;
    private int stock;
    private boolean active;
    private CategoryDto category;
}
