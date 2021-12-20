package com.felipe.blog.controller;

import com.felipe.blog.domain.model.Comment;
import com.felipe.blog.service.CommentService;
import com.felipe.blog.service.ArticleService;
import com.felipe.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/comments")
public class CommentController {
    private final UserService userService;
    private final CommentService commentService;
    private final ArticleService articleService;

    @Autowired
    public CommentController(UserService userService,CommentService commentService, ArticleService articleService){
        this.userService = userService;
        this.commentService = commentService;
        this.articleService = articleService;
    }

    @GetMapping("{user_id}/{article_id}/all")
    public Iterable<Comment> getUserCommentsFromPost(@PathVariable Long user_id, @PathVariable Long article_id){
        return commentService.getAllCommentsFromUser(user_id,article_id);
    }

    @GetMapping("{article_id}/all")
    public Iterable<Comment> getCommentFromArticle(@PathVariable Long article_id){
        return commentService.getAllCommentsFromArticle(article_id);
    }
}
