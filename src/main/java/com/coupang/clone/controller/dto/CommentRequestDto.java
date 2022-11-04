package com.coupang.clone.controller.dto;

import com.coupang.clone.domain.Comment;
import com.coupang.clone.domain.Member;
import com.coupang.clone.domain.Product;
import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class CommentRequestDto {

    private String reply;
    private double rate;
    private Member member;
    private Product product;

    @Builder
    public CommentRequestDto(String reply, double rate, Member member, Product product) {
        this.reply = reply;
        this.rate = rate;
        this.member = member;
        this.product = product;
    }

    public Comment toEntity(){
        return Comment
                .builder()
                .product(product)
                .member(member)
                .rate(rate)
                .reply(reply)
                .build();
    }
}
