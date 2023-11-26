package com.example.datasofttestapi.repositories;

import com.example.datasofttestapi.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
        User findByUsername(String username);
}
