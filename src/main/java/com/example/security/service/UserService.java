package com.example.security.service;

import java.util.List;

import com.example.security.model.Role;
import com.example.security.model.User;


public interface UserService {
    User saveUser(User user);
    Role sveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String uername);
    List<User> getUsers();
}
