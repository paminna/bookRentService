package com.example.bookrent.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity(name = "book")
public class Book {

    @Id
    private Integer id;

    private String name;

    private String author;

    private String rating;

    private Integer timeToRent;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
