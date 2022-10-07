package com.coupang.clone.Service;

import com.coupang.clone.Repository.ProductRepository;
import com.coupang.clone.controller.dto.ProductRegisterRequestDto;
import com.coupang.clone.controller.dto.ProductResponseDto;
import com.coupang.clone.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceTest {


    @Autowired ProductRepository productRepository;
    @Autowired ProductService productService;



    @Test
    void 상품등록() {
        ProductRegisterRequestDto productRegisterRequestDto = ProductRegisterRequestDto.builder()
                .productInfo("productInfo")
                .productName("productName")
                .price(1)
                .registerDate(new Date())
                .stock(10)
                .build();

        Long productId = productService.register(productRegisterRequestDto).getId();
        ProductResponseDto productResponseDto= productService.findOne(productId);
        assertThat(productRegisterRequestDto.getProductName()).isEqualTo(productResponseDto.getProductName());
        System.out.println("product = " + productResponseDto + " dto : "+productRegisterRequestDto);
    }

    @Test
    void 상품조회(){
        ProductResponseDto productResponseDto = productService.findOne(5L);
        assertThat(productResponseDto.getProductId()).isEqualTo(5L);
        System.out.println("productResponseDto = " + productResponseDto);
    }

    @Test
    void 상품전체조회(){
        List<ProductResponseDto> list = productService.findAll();
        assertThat(list.stream().findAny().get().getProductId()).isEqualTo(1L);
        for (ProductResponseDto productResponseDto : list) {
            System.out.println("product = " + productResponseDto);
        }
    }

    @Test
    void 상품삭제() {

    }
}