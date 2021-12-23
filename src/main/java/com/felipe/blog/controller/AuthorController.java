package com.felipe.blog.controller;

import com.felipe.blog.domain.model.Author;
import com.felipe.blog.dto.Authordto;
import com.felipe.blog.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/author")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @GetMapping
    public List<Authordto> getAuthors(){
        return authorService.getAuthors();
    }

    @GetMapping("/{author_id")
    public List<Authordto> getAuthor(@PathVariable Long author_id){
        Author author = authorService.getOneAuthor(author_id);
        if( author != null){
            return Authordto.convert(List.of(author));
        }
        return null;
    }

//    @PostMapping
//    public Author addAuthor(@RequestBody Author author){
//        return authorService.save(author);
//    }
}
