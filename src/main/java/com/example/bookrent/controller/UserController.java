package com.example.bookrent.controller;

import com.example.bookrent.dto.UserDto;
import com.example.bookrent.entity.User;
import com.example.bookrent.service.UserServiceImp;
import com.example.bookrent.specification.Filter;
import com.example.bookrent.specification.FilterToSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user/")
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;

    @GetMapping("admin/all")
    public List<UserDto> test(){
       List<UserDto> users =  userServiceImp.findUsers();
       return users;
    }

    @GetMapping("profile")
    public UserDto getUserProfile(){
        List<UserDto> userDtos = userServiceImp.findUsers();
        return userDtos.get(0);
    }

    @GetMapping("spec")
    public void spec(){
        Filter filter = new Filter();
        filter.setName("admin");
        filter.setLogin("admin");
        List<User> person = userServiceImp.findAllByFilter(FilterToSpec.getUser(filter));
    }
}
