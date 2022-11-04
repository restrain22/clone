package com.coupang.clone.Service;

import com.coupang.clone.Config;
import com.coupang.clone.Repository.CommentRepository;
import com.coupang.clone.controller.dto.CommentRequestDto;
import com.coupang.clone.controller.dto.CommentResponseDto;
import com.coupang.clone.controller.dto.ProductResponseDto;
import com.coupang.clone.domain.Comment;
import com.coupang.clone.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ProductService productService;
    private final MemberService memberService;


    @Transactional
    @Override
    public Long save(CommentRequestDto commentRequestDto) {
        validateCommentRequest(commentRequestDto);
        Member memberById = memberService.findMemberById(commentRequestDto.getMember().getId());
        ProductResponseDto byId = productService.findById(commentRequestDto.getProduct().getId());
        return commentRepository.save(commentRequestDto.toEntity()).getId();
    }

    @Override
    public CommentResponseDto findCommentById(Long id) {
        return new CommentResponseDto().toDto(commentRepository.findById(id).orElseGet(() -> {
            throw new IllegalStateException("해당 댓글이 존재하지 않습니다.");
        }));
    }

    @Override
    public List<CommentResponseDto> findCommentsByProductId(Long id) {
        return commentRepository.findByProductId(id).stream().map(comment -> new CommentResponseDto().toDto(comment)).collect(Collectors.toList());
    }

    @Override
    public List<CommentResponseDto> findCommentsByMemberId(Long id) {
        return commentRepository.findByMemberId(id).stream().map(comment -> new CommentResponseDto().toDto(comment)).collect(Collectors.toList());
    }

    @Override
    public List<CommentResponseDto> findCommentsByRate(Double rate) {
        return commentRepository.findByRate(rate).stream().map(comment -> new CommentResponseDto().toDto(comment)).collect(Collectors.toList());
    }

    @Override
    public String deleteById(Long id) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if (commentOptional.isPresent()) {
            commentRepository.deleteById(id);
            return "Success";
        } else {
            throw new IllegalStateException("삭제할 댓글이 존재하지 않습니다.");
        }
    }

    private void validateCommentRequest(CommentRequestDto commentRequestDto) {
        if(commentRequestDto.getMember()==null){
            throw new IllegalStateException("해당 사용자가 없습니다.");
        }else if(commentRequestDto.getProduct()==null){
            throw new IllegalStateException("해당되는 상품이 없습니다.");
        }else if (commentRequestDto.getRate() > Config.MaxRate)
            throw new IllegalStateException(Config.MaxRate + "이상의 점수는 입력 불가합니다.");
        else if (commentRequestDto.getRate() < Config.MinRate)
            throw new IllegalStateException(Config.MinRate + "이하의 점수는 입력 불가합니다.");
        else;
    }
}
