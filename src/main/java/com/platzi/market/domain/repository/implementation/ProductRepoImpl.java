package com.platzi.market.domain.repository.implementation;

import com.platzi.market.domain.dto.ProductDto;
import com.platzi.market.domain.repository.ProductRepo;
import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.Product;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepoImpl implements ProductRepo {

    private final ProductCrudRepository crudRepository;
    private final ProductMapper mapper;

    @Autowired
    public ProductRepoImpl(ProductCrudRepository crudRepository, ProductMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = (List<Product>) crudRepository.findAll();
        return mapper.toProductDtos(products);
    }

    @Override
    public Optional<List<ProductDto>> getByCategory(long idCategory) {
        List<Product> products = crudRepository.getProductsByCategoryId(idCategory);
        return Optional.of(mapper.toProductDtos(products));
    }

    @Override
    public Optional<List<ProductDto>> getScarceProducts(int stockQuantity) {
        Optional<List<Product>> products = crudRepository.findByStockQuantityLessThanAndState(stockQuantity, true);
        return products.map(mapper::toProductDtos); // equivalent sintax: products.map(prod -> mapper.toProductDtos(prod))
    }

    @Override
    public Optional<ProductDto> getProduct(long id) {
        return crudRepository.findById(id).map(mapper::toProductDto);
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = mapper.toProduct(productDto);
        return mapper.toProductDto(crudRepository.save(product));
    }

    @Override
    public boolean existsById(long id) {
        return crudRepository.existsById(id);
    }

    @Override
    public void delete(long id) {
        crudRepository.deleteById(id);
    }
}
