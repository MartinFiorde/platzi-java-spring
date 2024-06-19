package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
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

    public Optional<Product> getProduct(long id) {
        return crudRepository.findById(id);
    }

    public Product save(Product product) {
        return crudRepository.save(product);
    }

    public void delete(long id) {
        crudRepository.deleteById(id);
    }
}
