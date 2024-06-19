package com.platzi.market.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomainCategory {
    private long categoryId;
    private String category;
    private boolean active;
}
