package com.example.datasofttestapi.services;

import com.example.datasofttestapi.models.entities.User;

public interface UserService {
    User findById(Long idUser);

    User findByUsername(String username);
}
