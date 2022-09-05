package com.api.users.controller;


import com.api.users.domain.model.Users;
import com.api.users.domain.model.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    public List<Users> listUsers(){
        return usersRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        Optional<Users> users = usersRepository.findById(id);
        if (users.isPresent()) {
            return ResponseEntity.ok(users.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
