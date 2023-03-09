package com.example.bookrent.security;

import com.example.bookrent.dto.UserDto;
import com.example.bookrent.entity.Role;
import com.example.bookrent.entity.User;
import com.example.bookrent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User myUser= userRepository.findByUsername(username).get();
        if (myUser == null) {
            throw new UsernameNotFoundException("Unknown user: " + username);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : myUser.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new org.springframework.security.core.userdetails.User(myUser.getUsername(), myUser.getPassword(), grantedAuthorities);
    }
}
