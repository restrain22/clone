package com.coupang.clone.Repository;

import com.coupang.clone.domain.CartProduct;

import java.util.List;
import java.util.Optional;

public interface CartProductRepository {
    CartProduct save(CartProduct product);
    Optional<CartProduct> findById(Long id);
    Optional<CartProduct> findByCartIdAndProductId(Long cartId,Long productId);
    List<CartProduct> findByCartId(Long cartId);
    List<CartProduct> findAll();
    void deleteById(Long id);
}
