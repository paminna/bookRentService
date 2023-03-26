package com.example.securitytest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//
//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//    public User register(User user) {
//        // проверяем, что пользователь с таким именем пользователя и адресом электронной почты не существует
//        if (findByUsername(user.getUsername()) != null) {
//            throw new RuntimeException("User already exists");
//        }
//
//        // хэшируем пароль
//        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
//        user.setPassword(hashedPassword);
//
//        // сохраняем пользователя
//        return userRepository.save(user);
//    }
//}