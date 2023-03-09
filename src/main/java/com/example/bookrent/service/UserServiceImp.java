package com.example.bookrent.service;

import com.example.bookrent.dto.UserDto;
import com.example.bookrent.entity.Role;
import com.example.bookrent.entity.User;
import com.example.bookrent.repository.RoleRepository;
import com.example.bookrent.repository.UserRepository;
import com.example.bookrent.utils.JpaBaseImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImp extends JpaBaseImp<User, Integer, UserRepository, UserDto> implements UserService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImp() {
        super(UserRepository.class, User.class, UserDto.class);
    }

    public List<UserDto> findUsers() {
        return getDao().findAll().stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<User> findAllByFilter(Specification specification){
        return getDao().findAll(specification);
    }

    public UserDto findUserByLogin(String username){
        Optional<User> user =  getDao().findByUsername(username);
        if (user.isPresent()){
            return user.map(this::entityToDto).get();
        }
        return null;
    }


    public void saveUser(User user) {
        User findUser = getDao().findByUsername(user.getUsername()).get();
        if (findUser == null){
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.getOne(1));
            user.setRoles(roles);
            this.save(user);
        }
    }
}
