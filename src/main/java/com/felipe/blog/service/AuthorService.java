package com.felipe.blog.service;

import com.felipe.blog.domain.model.Author;
import com.felipe.blog.dto.Authordto;
import com.felipe.blog.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public List<Authordto> getAuthors(){
        return Authordto.convert(authorRepository.findAll());
    }

    public Author getOneAuthor(Long authorId){
        if(authorRepository.findById(authorId).isPresent()){
            return authorRepository.findById(authorId).get();
        }
        return null;
    }

    public Author saveAuthor(Author author){ return authorRepository.save(author);}

}
