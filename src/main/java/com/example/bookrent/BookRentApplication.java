package com.example.bookrent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BookRentApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookRentApplication.class, args);
    }

}
