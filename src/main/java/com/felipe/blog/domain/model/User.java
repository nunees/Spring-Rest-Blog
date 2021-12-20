package com.felipe.blog.domain.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @Column(length = 40, name = "password", nullable = false)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
