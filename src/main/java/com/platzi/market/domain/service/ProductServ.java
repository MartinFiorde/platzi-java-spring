package com.platzi.market.domain.service;

import com.platzi.market.domain.dto.ProductDto;
import com.platzi.market.domain.exceptions.ProductNotFoundException;
import com.platzi.market.domain.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServ {

    private final ProductRepo repo;

    @Autowired
    public ProductServ(ProductRepo repo) {
        this.repo = repo;
    }

    public List<ProductDto> getAll() {
        return repo.getAll();
    }

    public Optional<ProductDto> getProduct(long id) {
        return repo.getProduct(id);
    }

    public Optional<List<ProductDto>> getByCategory(long categoryId) {
        return repo.getByCategory(categoryId).filter(prods -> !prods.isEmpty()); // another way: [...].filter(Predicate.not(List::isEmpty)
    }

    public Optional<List<ProductDto>> getScarceProducts(int stockQuantity) {
        return repo.getScarceProducts(stockQuantity);
    }

    public ProductDto save(ProductDto product) {
        return repo.save(product);
    }

    // TODO PROBAR Y REVISAR. SOLUCION PROPUESTA POR UN ALUMNO Y CHATGPT. REVISAR VALIDACIONES https://chatgpt.com/share/a073ce0a-2443-493c-969d-04763e964a5f
    public Optional<ProductDto> update(long id, ProductDto productDto) {
        ProductDto productToUpdate = repo.getProduct(id).orElse(null);
        if (productToUpdate == null) {
            return Optional.empty();
        }
        if (productDto.getName() != null) productToUpdate.setName(productDto.getName());
        if (productDto.getCategoryId() != null) productToUpdate.setCategoryId(productDto.getCategoryId());
        if (productDto.getPrice() != null) productToUpdate.setPrice(productDto.getPrice());
        if (productDto.getStock() != null) productToUpdate.setStock(productDto.getStock());
        if (productDto.getActive() != null) productToUpdate.setActive(productDto.getActive());
        return Optional.of(repo.save(productToUpdate));
    }

    public boolean delete(long id) {
        try {
            if (!repo.existsById(id)) throw new ProductNotFoundException(id);
            repo.delete(id);
            return true;
        } catch (ProductNotFoundException e) {
            // TODO REGISTER ERROR IN LOGS
            return false;
        }
    }

}


