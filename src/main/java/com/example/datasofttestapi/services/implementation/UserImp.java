package com.example.datasofttestapi.services.implementation;

import com.example.datasofttestapi.models.entities.User;
import com.example.datasofttestapi.repositories.UserRepository;
import com.example.datasofttestapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImp implements UserService {

    @Autowired
    UserRepository userRp;
    @Override
    public User findById(Long idUser) {
        return userRp.findById(idUser).orElse(null);
    }
}
