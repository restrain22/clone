package com.coupang.clone.Repository;

import com.coupang.clone.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    Comment save(Comment comment);
    Optional<Comment> findById(Long id);
    List<Comment> findByProductId(Long id);
    List<Comment> findByMemberId(Long id);
    List<Comment> findByRate(Double rate);
    void deleteById(Long id);
}
