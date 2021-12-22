package com.felipe.blog.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 60,name = "name", nullable = false)
    private String name;

    @Column(length = 20, name = "username", nullable = false,unique = true)
    private String username;

    @Column(length = 60,name = "email", nullable = false, unique = true)
    private String email;

    @Column(length = 150, name = "password", nullable = false)
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updated_at;

    public User() {}

    @PrePersist
    private void onCreate(){
        created_at = new Date();
    }

    @PostUpdate
    private void onUpdate() {
        updated_at = new Date();
    }

}
