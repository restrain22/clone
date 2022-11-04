package com.coupang.clone.controller.dto;

import com.coupang.clone.domain.Comment;
import com.coupang.clone.domain.Member;
import com.coupang.clone.domain.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponseDto {
    private Long id;
    private String reply;
    private double rate;
    private MemberOnlyDto memberOnlyDto;
    private ProductOnlyDto productOnlyDto;

    @Builder
    public CommentResponseDto(Long id, String reply, double rate, MemberOnlyDto memberOnlyDto, ProductOnlyDto productOnlyDto) {
        this.id = id;
        this.reply = reply;
        this.rate = rate;
        this.memberOnlyDto = memberOnlyDto;
        this.productOnlyDto = productOnlyDto;
    }

    public CommentResponseDto toDto(Comment comment) {
        return CommentResponseDto.builder()
                .id(comment.getId())
                .memberOnlyDto(new MemberOnlyDto().toDto(comment.getMember()))
                .productOnlyDto(new ProductOnlyDto().toDto(comment.getProduct()))
                .reply(comment.getReply())
                .rate(comment.getRate())
                .build();
    }

}
