package com.coupang.clone.Service;

import com.coupang.clone.Repository.CartRepository;
import com.coupang.clone.controller.dto.CartReponseDto;
import com.coupang.clone.controller.dto.CartRequestDto;
import com.coupang.clone.domain.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Long save(CartRequestDto cartRequestDto) {
        duplicateCartValidation(cartRequestDto.getMember().getId());
        return cartRepository.save(cartRequestDto.toEntity()).getId();
    }

    @Override
    public Cart findCartById(Long id) {
        return cartRepository.findById(id).orElseThrow(() -> {
            throw new IllegalStateException("해당하는 사용자 장바구니가 없습니다.");});
    }

    @Override
    public Cart findCartByMemberId(Long id) {
        return cartRepository.findByMemberId(id).orElseThrow(() -> {
            throw new IllegalStateException("해당하는 사용자 장바구니가 없습니다.");});
    }
/**
    return 값 dto로 수정

    @Override
    public CartReponseDto findCartById(Long id) {
        return cartRepository.findById(id).orElseThrow(() -> {
            throw new IllegalStateException("해당하는 사용자 장바구니가 없습니다.");});
    }


    @Override
    public CartReponseDto findCartByMemberId(Long id) {
        return cartRepository.findByMemberId(id).ifPresentOrElse(cart -> {
                    return CartReponseDto
                }
                ,() -> {

                }
        );
    }
 */

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public void deleteCartByMemberId(Long id) {
        cartRepository.findByMemberId(id).ifPresent(cart -> {
            cartRepository.deleteById(id);
        });
    }

    private void duplicateCartValidation(Long id){
        cartRepository.findByMemberId(id).ifPresent(cart -> {
            throw new IllegalStateException("해당하는 사용자의 장바구니가 이미 존재합니다.");});
    }
}
