package com.platzi.market.domain.service;

import com.platzi.market.domain.dto.ProductDto;
import com.platzi.market.domain.exceptions.CustomEmptyResultException;
import com.platzi.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

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

    // TODO PROBAR Y REVISAR. SOLUCION PROPUESTA POR UN ALUMNO Y CHATGPT. REVISAR VALIDACIONES
    // https://chatgpt.com/share/a073ce0a-2443-493c-969d-04763e964a5f
    public Optional<ProductDto> update(long id, ProductDto productDto) {
        Optional<ProductDto> optProductDto = productRepository.getProduct(id);
        if (optProductDto.isEmpty()) {
            return Optional.empty();
        } else {
            ProductDto productToUpdate = optProductDto.get();
            if (productDto.getName() != null) productToUpdate.setName(productDto.getName());
            if (productDto.getCategoryId() != null) productToUpdate.setCategoryId(productDto.getCategoryId());
            if (productDto.getPrice() != null) productToUpdate.setPrice(productDto.getPrice());
            if (productDto.getStock() != null) productToUpdate.setStock(productDto.getStock());
            if (productDto.getActive() != null) productToUpdate.setActive(productDto.getActive());
            return Optional.of(productRepository.save(productToUpdate));
        }
    }

    public boolean delete(long id) {
        try {
            if (!productRepository.existsById(id)) throw new CustomEmptyResultException(id);
            productRepository.delete(id);
            return true;
        } catch (CustomEmptyResultException e) {
            // TODO REGISTER ERROR IN LOGS
            return false;
        }
    }

}


