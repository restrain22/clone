package com.coupang.clone.controller.dto;

import com.coupang.clone.domain.Cart;
import com.coupang.clone.domain.CartProduct;
import com.coupang.clone.domain.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartProductRequestDto {
    private Long id;
    private int count;
    private Cart cart;
    private Product product;

    @Builder
    public CartProductRequestDto(int count, Cart cart, Product product) {
        this.count = count;
        this.cart = cart;
        this.product = product;
    }

    public CartProduct toEntity() {
        return CartProduct.builder()
                .product(product)
                .cart(cart)
                .count(count)
                .build();
    }
}
