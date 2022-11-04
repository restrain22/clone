package com.coupang.clone.Service;

import com.coupang.clone.Repository.CartRepository;
import com.coupang.clone.Repository.ProductRepository;
import com.coupang.clone.controller.dto.CartProductRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(SpringRunner.class)
class CartProductServiceTest {

    @Autowired
    CartProductService cartProductService;

    @Autowired
    CartService cartService;
    @Autowired
    ProductRepository productRepository;

    @Test
    void add() {
        CartProductRequestDto cartProductRequestDto = CartProductRequestDto
                .builder()
                .cart(cartService.findCartById(3L))
                .product(productRepository.findById(1L).get())
                .count(2)
                .build();

        cartProductService.add(cartProductRequestDto);
    }

    @Test
    void findById() {
        assertThat(cartProductService.findById(2L).getProduct().getId()).isEqualTo(3L);
    }

    @Test
    void findByCartIdAndProductId() {
        CartProductRequestDto cartProductRequestDto = CartProductRequestDto
                .builder()
                .cart(cartService.findCartById(3L))
                .product(productRepository.findById(1L).get())
                .count(2)
                .build();
        assertThat(cartProductService.findByCartIdAndProductId(cartProductRequestDto.getCart().getId(), cartProductRequestDto.getProduct().getId())
                .getId()).isEqualTo(5L);
    }

    @Test
    void findAll() {
        assertThat(cartProductService.findAll().get(0).getId()).isIn(1L,2L,5L);
    }


/*
* count 업데이트 시 새로 insert됨, id값 체크 확인 필요
*
* */
    @Test
    void updateCount() {
        CartProductRequestDto cartProductRequestDto = CartProductRequestDto
                .builder()
                .cart(cartService.findCartById(3L))
                .product(productRepository.findById(1L).get())
                .count(5)
                .build();

        cartProductService.updateCount(cartProductRequestDto);
    }

    @Test
    void deleteById() {
        cartProductService.deleteById(5L);
    }
}