package com.felipe.blog.controller;

import com.felipe.blog.domain.model.Author;
import com.felipe.blog.domain.model.Post;
import com.felipe.blog.service.AuthorService;
import com.felipe.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/posts")
public class ArticleController {
    private final AuthorService authorService;
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService, AuthorService authorService){
        this.articleService = articleService;
        this.authorService = authorService;
    }

    @GetMapping("/all")
    public List<Post> getPosts(){
        return articleService.getPosts();
    }


    @PostMapping("/add/{author_id}")
    Post addAuthorPost(@RequestBody Post post, @PathVariable Long author_id){
        Author author = authorService.getOneAuthor(author_id);
        post.setAuthor(author);
        return articleService.savePost(post);
    }

    @PatchMapping("/edit/{post_id}")
    Post editPost(@PathVariable Long post_id, @RequestBody Post post){
        Post updatedPost = articleService.getOnePost(post_id);
        updatedPost.setTitle(post.getTitle());
        updatedPost.setContent(post.getContent());
        return articleService.savePost(updatedPost);
    }

    @DeleteMapping(value = "delete/{post_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deletePost(@PathVariable Long post_id){
        return articleService.deletePost(post_id);
    }
}
