package com.example.datasofttestapi.services;

import com.example.datasofttestapi.models.entities.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> findAll();
}
