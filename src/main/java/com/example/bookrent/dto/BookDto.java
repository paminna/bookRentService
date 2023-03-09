package com.example.bookrent.dto;

import com.example.bookrent.entity.User;
import lombok.Data;

@Data
public class BookDto {

    private Integer id;

    private String name;

    private String author;

    private String rating;

    private Integer timeToRent;

    private User user;
}
