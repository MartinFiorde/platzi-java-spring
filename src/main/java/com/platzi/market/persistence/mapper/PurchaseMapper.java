package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.dto.PurchaseDto;
import com.platzi.market.persistence.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class}, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface PurchaseMapper {

    @Mapping(target = "purchaseId", source = "id")
    @Mapping(target = "clientId", source = "idClient")
    @Mapping(target = "items", source = "purchaseProducts")
    PurchaseDto toPurchaseDto(Purchase purchase);

    List<PurchaseDto> toPurchaseDtos(List<Purchase> purchases);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    Purchase toPurchase(PurchaseDto purchaseDto);

    List<Purchase> toPurchases(List<PurchaseDto> purchaseDtos);

}
