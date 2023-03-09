package com.example.bookrent.repository;

import com.example.bookrent.entity.Role;
import com.example.bookrent.utils.JpaBase;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaBase<Role, Integer> {
}
