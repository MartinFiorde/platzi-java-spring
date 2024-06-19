package com.platzi.market.domain.repository;

import com.platzi.market.domain.DomainProduct;

import java.util.List;
import java.util.Optional;

public interface DomainProductRepository {
    List<DomainProduct> getAll();
    Optional<List<DomainProduct>> getByCategory(long categoryId);
    Optional<List<DomainProduct>> getScarceProducts(int quantity);
    Optional <DomainProduct> getProduct(long productId);
    DomainProduct save(DomainProduct product);
    void delete(long productId);

}
