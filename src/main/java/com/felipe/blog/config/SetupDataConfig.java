package com.felipe.blog.config;

import com.felipe.blog.domain.model.Author;
import com.felipe.blog.domain.model.Post;
import com.felipe.blog.domain.model.User;
import com.felipe.blog.service.AuthorService;
import com.felipe.blog.service.CommentService;
import com.felipe.blog.service.ArticleService;
import com.felipe.blog.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SetupDataConfig{
    private final AuthorService authorService;
    private final ArticleService articleService;
    private final CommentService commentService;
    private final UserService userService;

    public SetupDataConfig(AuthorService authorService, ArticleService articleService,
                           CommentService commentService, UserService userService){
        this.authorService = authorService;
        this.articleService = articleService;
        this.commentService = commentService;
        this.userService = userService;
    }

    @Bean
   CommandLineRunner commandLineRunner() {
       return args -> {
           Author author = new Author();
           author.setName("Felipe Silva");
           author.setEmail("felipe_silva@mail.com");
           author.setUsername("felipe3446");
           author.setPassword("password");
           author.setIs_admin(false);

           Post post = new Post();
           post.setTitle("Lorem ipsum");
           post.setAuthor(author);
           post.setContent("Lorem ipsum dolor amet doloar asat");

           User user = new User();
           user.setUsername("johndoe");
           user.setName("John doe");
           user.setPassword("secret");
           user.setEmail("johndoe@mail.com");

//           authorService.saveAuthor(author);
//           postService.savePost(post);
//           userService.saveUser(user);
       };
   }
}
