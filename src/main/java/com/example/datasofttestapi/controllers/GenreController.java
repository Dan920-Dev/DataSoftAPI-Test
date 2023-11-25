package com.example.datasofttestapi.controllers;

import com.example.datasofttestapi.models.dtos.GenreDTO;
import com.example.datasofttestapi.models.entities.Genre;
import com.example.datasofttestapi.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/BOOKSTORE")
public class GenreController {
    @Autowired
    GenreService genreSv;

    @GetMapping("/all/genre")
    public ResponseEntity<?> getAllGenres(){
        try{
            List<Genre> genres = genreSv.findAll();

            List<GenreDTO> response = genres.stream()
                    .map(genre -> new GenreDTO(genre.getId(), genre.getName()))
                    .toList();

            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (Exception e){
            e.printStackTrace();
           return new ResponseEntity("Error Data Processing", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
