package com.platzi.market.web.controller;

import com.platzi.market.domain.dto.PurchaseDto;
import com.platzi.market.domain.service.PurchaseServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseServ service;

    @Autowired
    public PurchaseController(PurchaseServ serv) {
        this.service = serv;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseDto>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<PurchaseDto>> getByClientId(@PathVariable("id") String clientId) {
        return ResponseEntity.of(service.getByClientId(clientId));
    }

    @PostMapping
    public ResponseEntity<PurchaseDto> save(@RequestBody PurchaseDto purchaseDto) {
        return new ResponseEntity<>(service.save(purchaseDto), HttpStatus.CREATED);
    }
}
