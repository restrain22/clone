package com.coupang.clone.Service;

import com.coupang.clone.Repository.CartProductRepository;
import com.coupang.clone.Repository.MemberRepository;
import com.coupang.clone.Repository.ProductRepository;
import com.coupang.clone.controller.dto.CartRequestDto;
import com.coupang.clone.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class CartServiceTest {

    @Autowired
    CartService cartService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    CartProductRepository cartProductRepository;



    @Test
    void save() {
        Member member = memberRepository.findById(1L).get();
        CartRequestDto cartRequestDto = CartRequestDto.builder()
                .member(member)
                .build();

        assertThrows(IllegalStateException.class, () -> {
            cartService.save(cartRequestDto);
        });
    }

    @Test
    void findCartById() {
        assertThat(cartService.findCartById(2L).getMember().getId()).isEqualTo(2L);
    }

    @Test
    void findCartByMemberId() {
        assertThat(cartService.findCartByMemberId(2L).getId()).isEqualTo(2L);
    }

    @Test
    @Transactional
    void findAll() {
        assertThat(cartService.findAll().get(0).getId()).isIn(2L,3L);
    }

    @Test
    void deleteCartByLoginId() {
        Member member = memberRepository.findById(3L).get();
        cartService.deleteCartByMemberId(member.getId());
        assertThrows(IllegalStateException.class,() -> {
            cartService.findCartByMemberId(member.getId());
        } );
    }
}