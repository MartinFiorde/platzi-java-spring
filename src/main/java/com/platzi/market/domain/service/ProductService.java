package com.platzi.market.domain.service;

import com.platzi.market.domain.dto.ProductDto;
import com.platzi.market.domain.repository.ProductDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductDtoRepository productDtoRepository;

    @Autowired
    public ProductService(ProductDtoRepository productDtoRepository) {
        this.productDtoRepository = productDtoRepository;
    }

    public List<ProductDto> getAll() {
        return productDtoRepository.getAll();
    }

    public Optional<ProductDto> getProduct(long id) {
        return productDtoRepository.getProduct(id);
    }

    public Optional<List<ProductDto>> getByCategory(long categoryId) {
        return productDtoRepository.getByCategory(categoryId);
    }

    public ProductDto save(ProductDto product) {
        return productDtoRepository.save(product);
    }

    public boolean delete(long id) {
        try {
            productDtoRepository.delete(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

}


