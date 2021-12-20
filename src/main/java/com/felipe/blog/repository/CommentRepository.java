package com.felipe.blog.repository;

import com.felipe.blog.domain.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c.user.username, c.comment_text, c.created_at FROM Comment c, Post p WHERE c.user.id = ?1 AND p.id = ?2")
    Iterable<Comment> getAllCommentsFromUser(Long userId, Long postId);

    @Query("SELECT c.user.username, c.comment_text, c.created_at FROM Comment c WHERE c.post.id = ?1")
    Iterable<Comment> getAllCommentsFromPost(Long postId);

}