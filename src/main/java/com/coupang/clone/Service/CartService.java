package com.coupang.clone.Service;

import com.coupang.clone.controller.dto.CartReponseDto;
import com.coupang.clone.controller.dto.CartRequestDto;
import com.coupang.clone.domain.Cart;

import java.util.List;

public interface CartService {
    Long save(CartRequestDto cartRequestDto);
//    CartReponseDto findCartById(Long id);
//    CartReponseDto findCartByMemberId(Long id);
    Cart findCartById(Long id);
    Cart findCartByMemberId(Long id);
    List<Cart> findAll();
    void deleteCartByMemberId(Long id);
}
