package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.dto.PurchaseItemDto;
import com.platzi.market.persistence.entity.PurchaseProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface PurchaseItemMapper {

    @Mapping(target = "productId", source = "id.idProduct")
    //@Mapping(target = "quantity", source = "quantity") // names match. No need to specify mapping between both attributes
    //@Mapping(target = "total", source = "total") // names match. No need to specify mapping between both attributes
    @Mapping(target = "active", source = "state")
    PurchaseItemDto toPurchaseItemDto(PurchaseProduct purchaseProduct);

    @InheritInverseConfiguration
    @Mapping(target = "purchase", ignore = true)
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "id.idPurchase", ignore = true)
    PurchaseProduct toPurchaseProduct(PurchaseItemDto purchaseItemDto);
}
