package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Long> {

    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true) // TODO equivalent anotation for the query method. with this anotation, method name can be anything
    List<Product> getProductsByIdCategory(long idCategory);
    //List<Product> findByIdCategory(long idCategory); // TODO query method if we dont use native query anotation

    List<Product> findByIdCategoryOrderByNameAsc(long idCathegory); // TODO query method. the name itself sets the conditions for the query on DB

    Optional<List<Product>> findByStockQuantityLessThanAndState(int stockQuantity, boolean state);
}
