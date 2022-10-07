package com.coupang.clone.controller.dto;

import com.coupang.clone.domain.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
public class ProductRegisterRequestDto {
    private Long ProductId;
    private String productName;
    private int price;
//    private String productOwnerId;
    private int stock; //재고
    private Date registerDate;
    private String productInfo;

    @Builder
    public ProductRegisterRequestDto( String productName, int price, String productOwnerId, int stock, Date registerDate, String productInfo) {
        this.productName = productName;
        this.price = price;
//        this.productOwnerId = productOwnerId;
        this.stock = stock;
        this.registerDate = registerDate;
        this.productInfo = productInfo;
    }



    public Product toEntity(){
        return Product.builder()
                .productName(productName)
                .price(price)
                .stock(stock)
                .registerDate(registerDate)
                .productInfo(productInfo)
                .build();
    }

    @Override
    public String toString() {
        return "ProductRegisterRequestDto{" +
//                "categoryId=" + categoryId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
//                ", productOwnerId='" + productOwnerId + '\'' +
                ", stock=" + stock +
                ", registerDate=" + registerDate +
                ", productInfo='" + productInfo + '\'' +
                '}';
    }
}
