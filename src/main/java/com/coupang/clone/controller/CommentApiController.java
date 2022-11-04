package com.coupang.clone.controller;

import com.coupang.clone.Service.CommentService;
import com.coupang.clone.controller.dto.CommentRequestDto;
import com.coupang.clone.controller.dto.CommentResponseDto;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("comment")
public class CommentApiController {

    private final CommentService commentService;

    @PostMapping("/save")
    public Long save(CommentRequestDto commentRequestDto) {
        return commentService.save(commentRequestDto);
    }

    @GetMapping("/comment/{id}")
    public CommentResponseDto findCommentById(@PathVariable Long id){
        return commentService.findCommentById(id);
    }

    @GetMapping("/product/{id}")
    public List<CommentResponseDto> findCommentsByProductId(@PathVariable Long id){
        return commentService.findCommentsByProductId(id);
    }

    @GetMapping("/member/{id}")
    public List<CommentResponseDto> findCommentsByMemberId(@PathVariable Long id){
        return commentService.findCommentsByMemberId(id);
    }

    @NotNull
    @GetMapping("/rate/{rate}")
    public List<CommentResponseDto> findCommentsByRate(@PathVariable Double rate){
        return commentService.findCommentsByRate(rate);
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        return commentService.deleteById(id);
    }
}
