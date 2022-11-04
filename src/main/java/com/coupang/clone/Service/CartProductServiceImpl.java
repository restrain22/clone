package com.coupang.clone.Service;

import com.coupang.clone.Repository.CartProductRepository;
import com.coupang.clone.controller.dto.CartProductRequestDto;
import com.coupang.clone.domain.CartProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartProductServiceImpl implements CartProductService{

    private final CartProductRepository cartProductRepository;

    @Override
    public List<CartProduct> findByCartId(Long cartId) {
        return cartProductRepository.findByCartId(cartId);
    }

    @Override
    public Long add(CartProductRequestDto dto) {
        duplicateCartProductValidation(dto);
        return cartProductRepository.save(dto.toEntity()).getId();
    }

    @Override
    public CartProduct findById(Long id) {
        return cartProductRepository.findById(id).orElseGet(() -> {
            throw new IllegalStateException("없는 장바구니 상품입니다.");
        });
    }

    @Override
    public CartProduct findByCartIdAndProductId(Long cartId,Long productId) {
        return cartProductRepository.findByCartIdAndProductId(cartId,productId).orElseGet(() -> {
            throw new IllegalStateException("없는 장바구니 상품입니다.");
        });
    }

    @Override
    public List<CartProduct> findAll() {
        return cartProductRepository.findAll();
    }

    @Override
    @Transactional
    public void updateCount(CartProductRequestDto dto) {
        cartProductRepository.findByCartIdAndProductId(dto.getCart().getId(), dto.getProduct().getId()).ifPresent(
                cartProduct -> {
                    cartProduct.setProduct(dto.getProduct());
                    cartProduct.setCart(dto.getCart());
                    cartProduct.setCount(dto.getCount());
                    cartProductRepository.save(cartProduct);
                }
        );
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        cartProductRepository.findById(id).ifPresent(
                product -> cartProductRepository.deleteById(id)
        );
    }

    void duplicateCartProductValidation(CartProductRequestDto dto) {
        cartProductRepository.findByCartIdAndProductId(dto.getCart().getId(),dto.getProduct().getId()).ifPresent(
                product -> {
                    throw new IllegalStateException("이미 존재하는 상품입니다");
                }
        );
    }
}
