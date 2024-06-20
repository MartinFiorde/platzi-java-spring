package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.dto.CategoryDto;
import com.platzi.market.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CategoryMapper {

    @Mapping(target = "categoryId", source = "id")
    @Mapping(target = "category", source = "description")
    @Mapping(target = "active", source = "state")
    CategoryDto toCategoryDto(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategory(CategoryDto categoryDto);

}
