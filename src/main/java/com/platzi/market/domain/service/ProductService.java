package com.platzi.market.domain.service;

import com.platzi.market.domain.dto.ProductDto;
import com.platzi.market.domain.exceptions.ProductNotFoundException;
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
        return productRepository.getByCategory(categoryId).filter(prods -> !prods.isEmpty()); // another way: [...].filter(Predicate.not(List::isEmpty)
        // VERSION MIA Optional<List<ProductDto>> optProds = productRepository.getByCategory(categoryId)
        // VERSION MIA return (optProds.orElse(Collections.emptyList()).isEmpty()) ? Optional.empty() : optProds
    }

    public Optional<List<ProductDto>> getScarceProducts(int stockQuantity) {
        return productRepository.getScarceProducts(stockQuantity);
    }

    public ProductDto save(ProductDto product) {
        return productRepository.save(product);
    }

    // TODO PROBAR Y REVISAR. SOLUCION PROPUESTA POR UN ALUMNO Y CHATGPT. REVISAR VALIDACIONES https://chatgpt.com/share/a073ce0a-2443-493c-969d-04763e964a5f
    public Optional<ProductDto> update(long id, ProductDto productDto) {
        ProductDto productToUpdate = productRepository.getProduct(id).orElse(null);
        if (productToUpdate == null) {
            return Optional.empty();
        }
        if (productDto.getName() != null) productToUpdate.setName(productDto.getName());
        if (productDto.getCategoryId() != null) productToUpdate.setCategoryId(productDto.getCategoryId());
        if (productDto.getPrice() != null) productToUpdate.setPrice(productDto.getPrice());
        if (productDto.getStock() != null) productToUpdate.setStock(productDto.getStock());
        if (productDto.getActive() != null) productToUpdate.setActive(productDto.getActive());
        return Optional.of(productRepository.save(productToUpdate));
    }

    public boolean delete(long id) {
        try {
            if (!productRepository.existsById(id)) throw new ProductNotFoundException(id);
            productRepository.delete(id);
            return true;
        } catch (ProductNotFoundException e) {
            // TODO REGISTER ERROR IN LOGS
            return false;
        }
    }

}


