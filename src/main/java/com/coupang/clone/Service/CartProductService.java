package com.coupang.clone.Service;

import com.coupang.clone.controller.dto.CartProductRequestDto;
import com.coupang.clone.domain.CartProduct;

import java.util.List;

public interface CartProductService {
    Long add(CartProductRequestDto cartProductRequestDto);
    CartProduct findById(Long id);
    CartProduct findByCartIdAndProductId(Long cartId,Long productId);
    List<CartProduct> findAll();
    List<CartProduct> findByCartId(Long cartId);
    void updateCount(CartProductRequestDto dto);
    void deleteById(long id);
}
