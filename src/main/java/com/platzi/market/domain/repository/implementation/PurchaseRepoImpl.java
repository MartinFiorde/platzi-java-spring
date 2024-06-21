package com.platzi.market.domain.repository.implementation;

import com.platzi.market.domain.dto.PurchaseDto;
import com.platzi.market.domain.repository.PurchaseRepo;
import com.platzi.market.persistence.crud.PurchaseCrudRepo;
import com.platzi.market.persistence.entity.Purchase;
import com.platzi.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepoImpl implements PurchaseRepo {

    private final PurchaseCrudRepo crudRepo;
    private final PurchaseMapper mapper;

    @Autowired
    public PurchaseRepoImpl(PurchaseCrudRepo crudRepo, PurchaseMapper mapper) {
        this.crudRepo = crudRepo;
        this.mapper = mapper;
    }

    @Override
    public List<PurchaseDto> getAll() {
        return mapper.toPurchaseDtos((List<Purchase>) crudRepo.findAll());
    }

    @Override
    public Optional<List<PurchaseDto>> getByClientId(String clientId) {
        return crudRepo.findByIdClient(clientId).map(mapper::toPurchaseDtos);
    }

    @Override
    public PurchaseDto save(PurchaseDto purchaseDto) {
        Purchase purchase = mapper.toPurchase(purchaseDto);
        purchase.getPurchaseProducts().forEach(prod -> prod.setPurchase(purchase));
        return mapper.toPurchaseDto(crudRepo.save(purchase));
    }

}
