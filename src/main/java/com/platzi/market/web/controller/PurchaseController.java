package com.platzi.market.web.controller;

import com.platzi.market.domain.dto.PurchaseDto;
import com.platzi.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseService service;

    @Autowired
    public PurchaseController(PurchaseService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseDto>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/clientId/")
    public ResponseEntity<List<PurchaseDto>> getByClientId(String clientId) {
        return ResponseEntity.of(service.getByClientId(clientId));
    }

    @PostMapping
    public ResponseEntity<PurchaseDto> save(PurchaseDto purchaseDto) {
        return new ResponseEntity<>(service.save(purchaseDto), HttpStatus.OK);
    }
}
