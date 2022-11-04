package com.coupang.clone.controller.dto;

import com.coupang.clone.domain.Product;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductSimpleResponseDto {
    private Long productId;
    private String name;

    @Builder
    public ProductSimpleResponseDto(Product product) {
        this.productId = product.getId();
        this.name = product.getName();
    }

    public ProductSimpleResponseDto getInstanceByEntity(Product product) {
        ProductSimpleResponseDto productSimpleResponseDto = new ProductSimpleResponseDto(product);
        return productSimpleResponseDto;
    }
}