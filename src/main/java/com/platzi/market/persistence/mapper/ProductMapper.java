package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.dto.ProductDto;
import com.platzi.market.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mapping(target = "productId", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "categoryId", source = "idCategory")
    @Mapping(target = "price", source = "sellPrice")
    @Mapping(target = "stock", source = "stockQuantity")
    @Mapping(target = "active", source = "state")
    @Mapping(target = "category", source = "category")
    ProductDto toProductDto(Product product);

    List<ProductDto> toProductDtos(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "barCode", ignore = true)
    Product toProduct(ProductDto productDto);

    List<Product> toProducts(List<ProductDto> productDtos);

}
