package com.coupang.clone.repository;

import com.coupang.clone.Repository.CartProductRepository;
import com.coupang.clone.Repository.CartRepository;
import com.coupang.clone.Repository.ProductRepository;
import com.coupang.clone.domain.Cart;
import com.coupang.clone.domain.CartProduct;
import com.coupang.clone.domain.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class CartProductRepositoryTest {

    @Autowired
    CartProductRepository cartProductRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    void save() {
        Cart cart = cartRepository.findById(2L).get();
        Product product = productRepository.findById(2L).get();

        CartProduct cartProduct = CartProduct
                .builder()
                .cart(cart)
                .product(product)
                .count(5)
                .build();

        cartProductRepository.save(cartProduct);
    }

    @Test
    void findById() {
        assertThat(cartProductRepository.findById(1L).get().getCount()).isEqualTo(5);
    }

    @Test
    void findAll() {
        List<CartProduct> cartProducts = cartProductRepository.findAll();
        CartProduct cartProduct = cartProducts.get(0);
        assertThat(cartProducts.stream().findAny()).contains(cartProduct);
    }

    @Test
    void deleteById() {
    }
}