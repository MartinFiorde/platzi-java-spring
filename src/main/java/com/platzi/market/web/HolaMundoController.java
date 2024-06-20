package com.platzi.market.web;

import com.platzi.market.persistence.entity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO class to make fast checks on new implementations
@RestController
@RequestMapping("/saludar")
public class HolaMundoController {

    @GetMapping("/hola")
    public String saludar() {
        Product p1 = new Product();
        p1.setName("maf");

        return "Hola Mundo! Nunca pares de aprender (product "+p1.getName()+")";
    }
}
