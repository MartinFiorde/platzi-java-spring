package com.platzi.market.web.controller;

import com.platzi.market.domain.dto.ProductDto;
import com.platzi.market.domain.service.ProductServ;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductServ service;

    @Autowired
    public ProductController(ProductServ serv) {
        this.service = serv;
    }

    @GetMapping("/all")
    @Operation(summary = "Get a list with all products")
    @ApiResponse(responseCode = "200", description = "Ok")
    public ResponseEntity<List<ProductDto>> getAll() { // OLD VERSION: List<ProductDto> getAll()
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK); // OLD VERSION: return service.getAll()
    }

    @GetMapping("/{id}")
    @Operation(summary = "Search a product with an ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
    })
    public ResponseEntity<ProductDto> getProduct(
            @Parameter(description = "The id of product", required = true, example = "7")
            @PathVariable long id) {
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
    public ResponseEntity<Void> delete(@PathVariable long id) {
        return service.delete(id)
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
