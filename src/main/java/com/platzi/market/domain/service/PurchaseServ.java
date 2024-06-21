package com.platzi.market.domain.service;

import com.platzi.market.domain.dto.PurchaseDto;
import com.platzi.market.domain.repository.PurchaseRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServ {

    private final PurchaseRepo repo;

    @Autowired
    public PurchaseServ(PurchaseRepo repo) {
        this.repo = repo;
    }

    public List<PurchaseDto> getAll() {
        return repo.getAll();
    }

    public Optional<List<PurchaseDto>> getByClientId(String clientId) {
        return repo.getByClientId(clientId).filter(purch -> !purch.isEmpty());
    }

    @Transactional
    public PurchaseDto save(PurchaseDto purchaseDto) {
        return repo.save(purchaseDto);
    }

}
