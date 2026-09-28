package com.glicocontrol.backend.controllers;

import com.glicocontrol.backend.models.User;
import com.glicocontrol.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/users")
    @CrossOrigin(origins = "*") // Permite que o front-end acesse essa API
    public class UserController {

        @Autowired
        private UserRepository userRepository;

        // Rota POST para cadastrar um novo usuário
        @PostMapping
        public ResponseEntity<User> createUser(@RequestBody User user) {
            User savedUser = userRepository.save(user);
            return ResponseEntity.status(201).body(savedUser);
        }

        // Rota GET para listar todos os usuários cadastrados
        @GetMapping
        public ResponseEntity<List<User>> getAllUsers() {
            List<User> users = userRepository.findAll();
            return ResponseEntity.ok(users);
        }
    }

