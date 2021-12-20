package com.felipe.blog.service;

import com.felipe.blog.domain.model.Comment;
import com.felipe.blog.domain.model.User;
import com.felipe.blog.repository.CommentRepository;
import com.felipe.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, UserRepository userRepository){
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    public Iterable<Comment> getAllCommentsFromUser(Long user, Long article_id){
        return commentRepository.getAllCommentsFromUser(user,article_id);
    }

    public Iterable<Comment> getAllCommentsFromArticle(Long article_id){
        return commentRepository.getAllCommentsFromArticle(article_id);
    }
}
