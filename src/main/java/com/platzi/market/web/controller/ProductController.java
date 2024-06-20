package com.platzi.market.web.controller;

import com.platzi.market.domain.dto.ProductDto;
import com.platzi.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<ProductDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ProductDto> getProduct(@PathVariable long id) {
        return service.getProduct(id);
    }

    @GetMapping("/category/{id}")
    public Optional<List<ProductDto>> getByCategory(@PathVariable("id") long categoryId) {
        return service.getByCategory(categoryId);
    }

    @PutMapping
    public Optional<ProductDto> update(@RequestBody ProductDto product) {
        return service.update(product.getProductId(), product);
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto product) {
        return service.save(product);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        return service.delete(id);
    }

}
