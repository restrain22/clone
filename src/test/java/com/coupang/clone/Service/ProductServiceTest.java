package com.coupang.clone.Service;

import com.coupang.clone.controller.dto.ProductResponseDto;
import com.coupang.clone.controller.dto.ProductSimpleResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceTest {

    @Autowired ProductService productService;

//    @Test
//    void 상품등록() {
//        ProductRegisterRequestDto productRegisterRequestDto = ProductRegisterRequestDto.builder()
//                .productInfo("productInfo")
//                .productName("productName")
//                .price(1)
//                .stock(10)
//                .build();
//
//        Long productId = productService.register(productRegisterRequestDto).getProductId();
//        ProductResponseDto productResponseDto= productService.findOne(productId);
//        assertThat(productRegisterRequestDto.getProductName()).isEqualTo(productResponseDto.getName());
//        System.out.println("product = " + productResponseDto + " dto : "+productRegisterRequestDto);
//    }

    @Test
    void 상품조회(){
        ProductResponseDto productResponseDto = productService.findById(5L);
        assertThat(productResponseDto.getProductId()).isEqualTo(5L);
        System.out.println("productResponseDto = " + productResponseDto);
    }

    @Test
    void 상품전체상세조회(){
        List<ProductResponseDto> list = productService.findDetailAll();
        assertThat(list.stream().findAny().get().getProductId()).isEqualTo(1L);
        for (ProductResponseDto productResponseDto : list) {
            System.out.println("product = " + productResponseDto);
        }
    }

    @Test
    void 상품전체간략조회(){
        List<ProductSimpleResponseDto> list = productService.findAllProductIdAndName();
        assertThat(list.stream().findAny().get().getProductId()).isEqualTo(1L);
        for (ProductSimpleResponseDto productSimpleResponseDto : list) {
            System.out.println("product = " + productSimpleResponseDto);
        }
    }

    @Test
    void 상품삭제() {

    }
}