package com.felipe.blog.service;

import com.felipe.blog.domain.model.Article;
import com.felipe.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    public List<Article> getArticles(){
        return articleRepository.findAll();
    }

    public Article saveArticle(Article article){ return articleRepository.save(article);}

    public Article getOneArticle(Long post_id) {
        if(articleRepository.findById(post_id).isPresent())
            return articleRepository.findById(post_id).get();
        return null;
    }

    public ResponseEntity deleteArticle(Long post_id){
        if(articleRepository.findById(post_id).isPresent()) {
            articleRepository.deleteById(post_id);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }

}

