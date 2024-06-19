package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.DomainCategory;
import com.platzi.market.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "categoryId", source = "id")
    @Mapping(target = "category", source = "description")
    @Mapping(target = "active", source = "state")
    DomainCategory toDomainCategory(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategory(DomainCategory domainCategory);

}
