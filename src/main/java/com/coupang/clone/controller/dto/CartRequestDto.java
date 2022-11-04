package com.coupang.clone.controller.dto;

import com.coupang.clone.domain.Cart;
import com.coupang.clone.domain.CartProduct;
import com.coupang.clone.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class CartRequestDto {
    private Long id;
    private Member member;

    @Builder
    public CartRequestDto(Member member) {
        this.member = member;
    }

    public Cart toEntity(){
        return Cart.builder()
                .member(member)
                .build();
    }
}