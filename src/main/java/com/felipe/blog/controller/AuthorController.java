package com.felipe.blog.controller;

import com.felipe.blog.domain.model.Author;
import com.felipe.blog.repository.AuthorRepository;
import com.felipe.blog.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/author")
public class AuthorController {
    private final AuthorRepository authorRepository;
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService, AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @PostMapping
    public Author addAuthor(@RequestBody Author author){
        return authorRepository.save(author);
    }
}
