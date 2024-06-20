package com.platzi.market.domain.repository;

import com.platzi.market.domain.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<ProductDto> getAll();
    Optional<List<ProductDto>> getByCategory(long categoryId);
    Optional<List<ProductDto>> getScarceProducts(int quantity);
    Optional <ProductDto> getProduct(long productId);
    ProductDto save(ProductDto product);
    void delete(long productId);
}
