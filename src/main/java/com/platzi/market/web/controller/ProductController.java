package com.platzi.market.web.controller;

import com.platzi.market.domain.dto.ProductDto;
import com.platzi.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ProductDto>> getAll() { // OLD VERSION: List<ProductDto> getAll()
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK); // OLD VERSION: return service.getAll()
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable long id) {
        return ResponseEntity.of(service.getProduct(id)); // ResponseEntity OK/NOT_FOUND split for Spring 5.X and over
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductDto>> getByCategory(@PathVariable("id") long categoryId) { // specify @pathVar because varaible name doesnt match path reference
        return service.getByCategory(categoryId)
                .map(prods -> new ResponseEntity<>(prods,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); // ResponseEntity OK/NOT_FOUND split for Spring versions bellow 5.X
    }

    @GetMapping("/stock-bellow/{quantity}")
    public ResponseEntity<List<ProductDto>> getScarceProducts(@PathVariable int quantity) {
        return ResponseEntity.of(service.getScarceProducts(quantity));
    }

    @PutMapping
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto product) {
        return ResponseEntity.of(service.update(product.getProductId(), product));
    }

    @PostMapping
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto product) {
        return new ResponseEntity<>(service.save(product),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        return service.delete(id)
                ? new ResponseEntity(HttpStatus.NO_CONTENT)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
