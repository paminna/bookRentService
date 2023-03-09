package com.example.bookrent.repository;

import com.example.bookrent.entity.User;
import com.example.bookrent.utils.JpaBase;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaBase<User, Integer> {
    Optional<User> findByUsername(String username);
}
