package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

public class ProductRepository {

    private ProductCrudRepository crudRepository;

    public List<Product> getAll() {
        return (List<Product>) crudRepository.findAll();
    }

    public List<Product> getByCategory(long idCategory) {
        return crudRepository.findByIdCategoryOrderByNameAsc(idCategory);
    }

    public Optional<List<Product>> getEscasos(int stockQuantity) {
        return crudRepository.findByStockQuantityLessThanAndState(stockQuantity, true);
    }
}
