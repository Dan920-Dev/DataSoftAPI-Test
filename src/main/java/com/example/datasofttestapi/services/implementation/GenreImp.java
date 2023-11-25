package com.example.datasofttestapi.services.implementation;

import com.example.datasofttestapi.models.entities.Genre;
import com.example.datasofttestapi.repositories.GenreRepository;
import com.example.datasofttestapi.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreImp implements GenreService {
    @Autowired
    GenreRepository genreRp;
    @Override
    public List<Genre> findAll() {
        return genreRp.findAll();
    }

}
