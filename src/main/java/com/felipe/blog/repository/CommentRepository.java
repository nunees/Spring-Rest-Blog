package com.felipe.blog.repository;

import com.felipe.blog.domain.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c.user.username, c.comment_text, c.created_at FROM Comment c, Article a WHERE c.user.id = ?1 AND a.id = ?2")
    Iterable<Comment> getAllCommentsFromUser(Long user_id, Long article_id);

    @Query("SELECT c.user.username, c.comment_text, c.created_at FROM Comment c WHERE c.article.id = ?1")
    Iterable<Comment> getAllCommentsFromArticle(Long post_id);

}