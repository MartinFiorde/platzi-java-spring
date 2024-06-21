package com.platzi.market.domain.repository.implementation;

import com.platzi.market.domain.dto.ProductDto;
import com.platzi.market.domain.repository.ProductRepo;
import com.platzi.market.persistence.crud.ProductCrudRep;
import com.platzi.market.persistence.entity.Product;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepoImpl implements ProductRepo {

    private final ProductCrudRep crudRepo;
    private final ProductMapper mapper;

    @Autowired
    public ProductRepoImpl(ProductCrudRep crudRepo, ProductMapper mapper) {
        this.crudRepo = crudRepo;
        this.mapper = mapper;
    }

    @Override
    public List<ProductDto> getAll() {
        return mapper.toProductDtos((List<Product>) crudRepo.findAll());
    }

    @Override
    public Optional<List<ProductDto>> getByCategory(long idCategory) {
        return Optional.of(mapper.toProductDtos(crudRepo.getProductsByCategoryId(idCategory)));
    }

    @Override
    public Optional<List<ProductDto>> getScarceProducts(int stockQuantity) {
        return crudRepo.findByStockQuantityLessThanAndState(stockQuantity, true)
                .map(mapper::toProductDtos); // equivalent sintax: .map(prod -> mapper.toProductDtos(prod))
    }

    @Override
    public Optional<ProductDto> getProduct(long id) {
        return crudRepo.findById(id).map(mapper::toProductDto);
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        return mapper.toProductDto(crudRepo.save(mapper.toProduct(productDto)));
    }

    @Override
    public boolean existsById(long id) {
        return crudRepo.existsById(id);
    }

    @Override
    public void delete(long id) {
        crudRepo.deleteById(id);
    }
}
