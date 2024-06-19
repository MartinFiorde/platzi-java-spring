package com.platzi.market.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
    private long categoryId;
    private String category;
    private boolean active;
}
