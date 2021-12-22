package com.felipe.blog.dto;

import com.felipe.blog.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Userdto {
    private Long id;
    private String name;
    private String username;
    private String email;
    private Date created_at;
    private Date updated_at;

    public Userdto(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.created_at  = user.getCreated_at();
        this.updated_at = user.getUpdated_at();
    }

    public static List<Userdto> convert(List<User> user){
        return user.stream().map(Userdto::new).collect(Collectors.toList());
    }
}
