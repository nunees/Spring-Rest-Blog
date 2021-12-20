package com.felipe.blog.controller;

import com.felipe.blog.domain.model.Author;
import com.felipe.blog.domain.model.Article;
import com.felipe.blog.service.AuthorService;
import com.felipe.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/articles")
public class ArticleController {
    private final AuthorService authorService;
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService, AuthorService authorService){
        this.articleService = articleService;
        this.authorService = authorService;
    }

    @GetMapping("/all")
    public List<Article> getArticles(){
        return articleService.getArticles();
    }


    @PostMapping("/add/{author_id}")
    Article addAuthorPost(@RequestBody Article post, @PathVariable Long author_id){
        Author author = authorService.getOneAuthor(author_id);
        post.setAuthor(author);
        return articleService.saveArticle(post);
    }

    @PatchMapping("/edit/{article_id}")
    Article editPost(@PathVariable Long article_id, @RequestBody Article article){
        Article updatedPost = articleService.getOneArticle(article_id);
        updatedPost.setTitle(article.getTitle());
        updatedPost.setContent(article.getContent());
        return articleService.saveArticle(updatedPost);
    }

    @DeleteMapping(value = "delete/{article_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deletePost(@PathVariable Long article_id){
        return articleService.deleteArticle(article_id);
    }
}
