package com.example.bookrent.dto;

import com.example.bookrent.entity.Book;
import lombok.Data;

import java.util.Set;

@Data
public class UserDto {

    private Integer id;

    private String login;

    private String password;

    private String username;

    private Float rating;

    private String role;

    private Set<Book> book;
}
