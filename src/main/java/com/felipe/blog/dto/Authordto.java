package com.felipe.blog.dto;

import com.felipe.blog.domain.model.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authordto {
    private String name;
    private String username;
    private String email;
    private boolean isAdmin;
    private Date created_at;
    private Date updated_at;

    public Authordto(Author author) {
        this.name = author.getName();
        this.username = author.getUsername();
        this.email = author.getEmail();
        this.isAdmin = author.is_admin();
        this.created_at = author.getCreated_at();
        this.updated_at = author.getUpdated_at();
    }

    public static List<Authordto> convert(List<Author> author){
        return author.stream().map(Authordto::new).collect(Collectors.toList());
    }
}
