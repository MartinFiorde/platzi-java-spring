package com.platzi.market.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto {
    private Long productId;
    private String name;
    private Long categoryId;
    private BigDecimal price;
    private Integer stock;
    private Boolean active;
    private CategoryDto category;
}
