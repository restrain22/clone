package com.coupang.clone.Repository;

import com.coupang.clone.domain.CartProduct;

import java.util.List;
import java.util.Optional;

public interface CartProductRepository {
    CartProduct save(CartProduct product);
    Optional<CartProduct> findById(Long id);
    List<CartProduct> findAll();
    void deleteById(Long id);
}
