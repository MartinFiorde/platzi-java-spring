package com.platzi.market.domain.repository;

import com.platzi.market.domain.dto.PurchaseDto;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepo {
    List<PurchaseDto> getAll();
    Optional<List<PurchaseDto>> getByClientId(String clientId);
    PurchaseDto save(PurchaseDto purchaseDto);
}
