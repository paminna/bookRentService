package com.example.securitytest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
//
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody User user) {
//        // проверяем, что пользователь существует и пароль верный
//        User existingUser = userService.findByUsername(user.getUsername());
//        if (existingUser == null || !BCrypt.checkpw(user.getPassword(), existingUser.getPassword())) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//
//        // создаем JWT токен
//        String token = Jwts.builder()
//                .setSubject(existingUser.getUsername())
//                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // токен действителен 1 час
//                .signWith(SignatureAlgorithm.HS512, "secretkey")
//                .compact();
//
//        // возвращаем токен в ответе
//        Map<String, String> response = new HashMap<>();
//        response.put("token", token);
//        return ResponseEntity.ok(response);
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody User user) {
//        try {
//            User registeredUser = userService.register(user);
//            // возвращаем созданного пользователя в ответе
//            return ResponseEntity.ok(registeredUser);
//        } catch (Exception e) {
//            // возвращаем ошибку, если пользователь уже существует
//            return ResponseEntity.status(HttpStatus.CONFLICT).build();
//        }
//    }
//}