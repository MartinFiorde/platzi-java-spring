package com.platzi.market.persistence;

import com.platzi.market.domain.dto.ProductDto;
import com.platzi.market.domain.repository.ProductDtoRepository;
import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.Product;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductDtoRepository {

    private final ProductCrudRepository crudRepository;
    private final ProductMapper mapper;

    @Autowired
    public ProductRepositoryImpl(ProductCrudRepository crudRepository, ProductMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = (List<Product>) crudRepository.findAll();
        return mapper.toDomainProducts(products);
    }

    @Override
    public Optional<List<ProductDto>> getByCategory(long idCategory) {
        List<Product> products = crudRepository.findByIdCategoryOrderByNameAsc(idCategory);
        return Optional.of(mapper.toDomainProducts(products));
    }

    @Override
    public Optional<List<ProductDto>> getScarceProducts(int stockQuantity) {
        Optional<List<Product>> products = crudRepository.findByStockQuantityLessThanAndState(stockQuantity, true);
        return products.map(mapper::toDomainProducts);
//      return products.map(prods -> mapper.toDomainProducts(prods)); // TODO equivalent sintax
    }

    @Override
    public Optional<ProductDto> getProduct(long id) {
        return crudRepository.findById(id).map(mapper::toDomainProduct);
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = mapper.toProduct(productDto);
        return mapper.toDomainProduct(crudRepository.save(product));
    }

    @Override
    public void delete(long id) {
        crudRepository.deleteById(id);
    }
}
