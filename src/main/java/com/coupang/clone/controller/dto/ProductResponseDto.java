package com.coupang.clone.controller.dto;

import com.coupang.clone.domain.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductResponseDto {
    private Long productId;
    private String name;
    private int price;
    private int stock; //재고
    private Date registerDate;
    private String info;

    public ProductResponseDto(Product product) {
        this.productId = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.registerDate = product.getRegisteredDate();
        this.info = product.getInfo();
    }

    public ProductResponseDto toDto(Product product) {
        return new ProductResponseDto(product);
    }
}
