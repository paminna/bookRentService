package com.example.bookrent.repository;

import com.example.bookrent.entity.Book;
import com.example.bookrent.utils.JpaBase;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository  extends JpaBase<Book, Integer> {
}
