package com.coupang.clone.controller.dto;

import com.coupang.clone.domain.Cart;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CartReponseDto {
    Long id;
    int count;

    public CartReponseDto(Long id, int count) {
        this.id = id;
        this.count = count;
    }

    public CartReponseDto(Cart cart) {
        this.id = cart.getId();
        this.count = cart.getCount();
    }

    public CartReponseDto getInstanceByEntity(Cart cart) {
        return new CartReponseDto(cart);
    }

}
