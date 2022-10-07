package com.coupang.clone.repository;

import com.coupang.clone.Repository.CartRepository;
import com.coupang.clone.Repository.MemberRepository;
import com.coupang.clone.domain.Cart;
import com.coupang.clone.domain.Member;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
class CartRepositoryTest {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void 장바구니_생성() {
        List<Member> members = memberRepository.findAll();
        for (Member member : members) {
            Cart cart = Cart.builder()
                    .member(member)
                    .build();
            if(cartRepository.findByMemberId(member.getId()).isEmpty())
                cartRepository.save(cart);
        }
    }

    @Test
    void findById() {
        Member member = memberRepository.findById(1L).get();
        Cart cart = cartRepository.findByMemberId(member.getId()).get();
        assertThat(cart.getId()).isEqualTo(3L);
    }

    @Test
    @Transactional
    void findAll() {
        List<Cart> carts = cartRepository.findAll();
        Cart cart = carts.stream().findAny().get();
        assertThat(carts).contains(cart);
        for (Cart cart1 : carts) {
            System.out.println("cart1 = " + cart1);
        }
    }

    @Test
    void deleteById() {
        cartRepository.deleteById(1L);
        assertThrows(NoSuchElementException.class,()->cartRepository.findById(1L).get());
    }
}