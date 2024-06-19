package com.platzi.market.persistence;

import com.platzi.market.domain.DomainProduct;
import com.platzi.market.domain.repository.DomainProductRepository;
import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.Product;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements DomainProductRepository {

    private final ProductCrudRepository crudRepository;
    private final ProductMapper mapper;

    @Autowired
    public ProductRepository(ProductCrudRepository crudRepository, ProductMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<DomainProduct> getAll() {
        List<Product> products = (List<Product>) crudRepository.findAll();
        return mapper.toDomainProducts(products);
    }

    @Override
    public Optional<List<DomainProduct>> getByCategory(long idCategory) {
        List<Product> products = crudRepository.findByIdCategoryOrderByNameAsc(idCategory);
        return Optional.of(mapper.toDomainProducts(products));
    }

    @Override
    public Optional<List<DomainProduct>> getScarceProducts(int stockQuantity) {
        Optional<List<Product>> products = crudRepository.findByStockQuantityLessThanAndState(stockQuantity, true);
        return products.map(mapper::toDomainProducts);
//      return products.map(prods -> mapper.toDomainProducts(prods)); // TODO equivalent sintax
    }

    @Override
    public Optional<DomainProduct> getProduct(long id) {
        return crudRepository.findById(id).map(mapper::toDomainProduct);
    }

    @Override
    public DomainProduct save(DomainProduct domainProduct) {
        Product product = mapper.toProduct(domainProduct);
        return mapper.toDomainProduct(crudRepository.save(product));
    }

    @Override
    public void delete(long id) {
        crudRepository.deleteById(id);
    }
}
