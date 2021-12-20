package com.felipe.blog.controller;

import com.felipe.blog.BlogApplication;
import com.felipe.blog.domain.model.User;
import com.felipe.blog.service.UserService;
import net.minidev.json.writer.JsonReader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(UserController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerAssertionTest {

    private static final String url = "http://localhost:8080/api/v1/users/";

    @Autowired
    private MockMvc mvc;


    @Test
    @DisplayName("Add new user successfully [GET]")
    public void addNewUserTest() throws Exception{
        User user = new User();
        user.setName("John");
        user.setEmail("johndoe@gmail.com");
        user.setUsername("john3446");
        user.setPassword("1234");

        JSONObject object = new JSONObject();
        object.put("name", user.getName());
        object.put("username", user.getUsername());
        object.put("email", user.getEmail());
        object.put("password", user.getPassword());

        mvc.perform(
                MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(object.toString()))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
