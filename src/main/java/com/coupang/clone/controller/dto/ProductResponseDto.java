package com.coupang.clone.controller.dto;

import com.coupang.clone.domain.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class ProductResponseDto {
    private Long ProductId;
    private String productName;
    private int price;
    private int stock; //재고
    private Date registerDate;
    private String productInfo;

    public ProductResponseDto(Product product) {
        this.ProductId = product.getId();
        this.productName = product.getProductName();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.registerDate = product.getRegisterDate();
        this.productInfo = product.getProductInfo();
    }

    public ProductResponseDto getInstanceByEntity(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto(product);
        return productResponseDto;
    }

    @Override
    public String toString() {
        return "ProductResponseDto{" +
                "ProductId=" + ProductId +
//                ", categoryId=" + categoryId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
//                ", productOwnerId='" + productOwnerId + '\'' +
                ", stock=" + stock +
                ", registerDate=" + registerDate +
                ", productInfo='" + productInfo + '\'' +
                '}';
    }
}
