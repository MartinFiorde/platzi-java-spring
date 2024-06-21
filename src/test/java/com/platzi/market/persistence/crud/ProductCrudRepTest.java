package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProductCrudRepTest {

//    private final ProductCrudRep productCrudRep;
//
//    @Autowired
//    public ProductCrudRepTest(ProductCrudRep productCrudRep) {
//        this.productCrudRep = productCrudRep;
//    }
//
//    @Test
//    void shouldReturnAProductListFromRepo() {
//        List<Product> productEntities = (List<Product>) productCrudRep.findAll();
//        int productsNum = productEntities.size();
//        assertTrue(productsNum > 0);
//    }
//
//    @Test
//    void shouldReturnAListProductFromIdCategoryNativeQuery() {
//        List<Product> productEntities = productCrudRep.getProductsByCategoryId(1);
//        int productsNum = productEntities.size();
//        assertEquals(10, productsNum);
//    }
//
//    @Test
//    void shouldReturnAListProductAreRunningOutOfStock() {
//        Optional<List<Product>> products = productCrudRep.findByStockQuantityLessThanAndState(5, true);
//        long productsNum = products.stream().count();
//        assertEquals(1, productsNum);
//    }

}
