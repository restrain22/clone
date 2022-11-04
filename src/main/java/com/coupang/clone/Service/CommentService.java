package com.coupang.clone.Service;

import com.coupang.clone.controller.dto.CommentRequestDto;
import com.coupang.clone.controller.dto.CommentResponseDto;
import com.coupang.clone.domain.Comment;

import java.util.List;

public interface CommentService {
    Long save(CommentRequestDto commentRequestDto);
    CommentResponseDto findCommentById(Long id);
    List<CommentResponseDto> findCommentsByProductId(Long id);
    List<CommentResponseDto> findCommentsByMemberId(Long id);
    List<CommentResponseDto> findCommentsByRate(Double rate);
    String deleteById(Long id);
}
