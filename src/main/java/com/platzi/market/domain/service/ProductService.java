package com.platzi.market.domain.service;

import com.platzi.market.domain.dto.ProductDto;
import com.platzi.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getAll() {
        return productRepository.getAll();
    }

    public Optional<ProductDto> getProduct(long id) {
        return productRepository.getProduct(id);
    }

    public Optional<List<ProductDto>> getByCategory(long categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public ProductDto save(ProductDto product) {
        return productRepository.save(product);
    }

    public boolean delete(long id) {
        try {
            productRepository.delete(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

}


