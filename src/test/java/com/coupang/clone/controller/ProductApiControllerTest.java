package com.coupang.clone.controller;

import com.coupang.clone.controller.dto.ProductRegisterRequestDto;
import com.coupang.clone.controller.dto.ProductResponseDto;
import com.coupang.clone.controller.dto.ProductSimpleResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class ProductApiControllerTest {

    @Autowired
    ProductApiController productApiController;

    @Test
    void getProductDetailList() {
        List<ProductResponseDto> productDetailList = productApiController.getProductDetailList();
        for (ProductResponseDto productResponseDto : productDetailList) {
            System.out.println("productResponseDto = " + productResponseDto);
        }
    }

    @Test
    void getProductSimpleList() {
        List<ProductSimpleResponseDto> productSimpleList = productApiController.getProductSimpleList();
        for (ProductSimpleResponseDto productSimpleResponseDto : productSimpleList) {
            System.out.println("productSimpleResponseDto = " + productSimpleResponseDto);
        }
    }

    @Test
    void getProduct() {
        ProductResponseDto product = productApiController.getProduct(1L);
        System.out.println("product = " + product);
    }

    @Test
    void saveProduct() {
        ProductRegisterRequestDto productRegisterRequestDto=ProductRegisterRequestDto.builder()
                .productOwnerId("a1")
                .categoryName("식품")
                .price(5000)
                .productInfo("핫도그")
                .productName("핫도그")
                .stock(30)
                .build();
        productApiController.saveProduct(productRegisterRequestDto);
    }

    @Test
    void deleteProduct() {
    }
}