package com.example.bookrent.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Role implements GrantedAuthority {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToMany
    private Set<User> users;

    private String role;

    public Role(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    public Role() {
    }

    @Override
    public String getAuthority() {
        return getRole();
    }
}
