package com.felipe.blog.service;

import com.felipe.blog.domain.model.Post;
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

    public List<Post> getPosts(){
        return articleRepository.findAll();
    }

    public Post savePost(Post post){ return articleRepository.save(post);}

    public Post getOnePost(Long post_id) { return articleRepository.findById(post_id).get(); }

    public ResponseEntity deletePost(Long post_id){
        if(articleRepository.findById(post_id).isPresent()) {
            articleRepository.deleteById(post_id);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }

}

