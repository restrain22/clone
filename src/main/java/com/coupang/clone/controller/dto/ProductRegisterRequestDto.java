package com.coupang.clone.controller.dto;

import com.coupang.clone.domain.Product;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductRegisterRequestDto {
    private String productName;
    private int price;
    private String productOwnerId;
    private int stock; //재고
    private String productInfo;
    private String categoryName;
    private MultipartFile multipartFile;

    @Builder
    public ProductRegisterRequestDto(String productName, int price, String productOwnerId, int stock, String productInfo, String categoryName,MultipartFile multipartFile) {
        this.productName = productName;
        this.price = price;
        this.productOwnerId = productOwnerId;
        this.stock = stock;
        this.productInfo = productInfo;
        this.categoryName = categoryName;
        this.multipartFile = multipartFile;
    }

    public Product toEntity(){
        return Product.builder()
                .name(productName)
                .price(price)
                .stock(stock)
                .info(productInfo)
                .build();
    }
}
