package com.coupang.clone.Repository;

import com.coupang.clone.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCommentRepository  extends JpaRepository<Comment,Long>,CommentRepository{
}
