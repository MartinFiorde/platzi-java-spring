package com.platzi.market.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
    private Long categoryId;
    private String category;
    private Boolean active;
}
