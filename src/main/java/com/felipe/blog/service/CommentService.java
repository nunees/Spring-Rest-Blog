package com.felipe.blog.service;

import com.felipe.blog.domain.model.Comment;
import com.felipe.blog.domain.model.User;
import com.felipe.blog.repository.CommentRepository;
import com.felipe.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, UserRepository userRepository){
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    public Iterable<Comment> getAllCommentsFromUser(Long user, Long postId){
        return commentRepository.getAllCommentsFromUser(user,postId);
    }

    public Iterable<Comment> getAllCommentsFromPost(Long postId){
        return commentRepository.getAllCommentsFromPost(postId);
    }
}
