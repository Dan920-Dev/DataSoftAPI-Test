package com.example.datasofttestapi.repositories;

import com.example.datasofttestapi.models.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GenreRepository extends JpaRepository<Genre, Long> {

}
