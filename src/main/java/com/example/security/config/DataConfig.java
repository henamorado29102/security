package com.example.security.config;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.security.model.Role;
import com.example.security.model.User;
import com.example.security.repository.RoleRepository;
import com.example.security.service.UserService;

@Component
public class DataConfig implements CommandLineRunner {
    private final UserService userService;
    private final RoleRepository roleRepository;
  
    public DataConfig(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        roleRepository.save(new Role("ROLE_ADMIN"));
        roleRepository.save(new Role("ROLE_OPERATOR"));
        Role role = roleRepository.findByName("ROLE_ADMIN");
        userService.saveUser(new User("henrry", "henamorado", "password", List.of(role)));

        role = roleRepository.findByName("ROLE_OPERATOR");

        userService.saveUser(new User("henrry1", "henamorado1", "password", List.of(role)));
        
    }
    
}
