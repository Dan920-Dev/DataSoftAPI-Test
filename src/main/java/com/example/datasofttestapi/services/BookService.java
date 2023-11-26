package com.example.datasofttestapi.services;

import com.example.datasofttestapi.models.entities.Book;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {
    List<Book> getAllBooksByGenre(Long id);

    Book findById(Long id);

    void save(Book book);

    List<Book> getAll();


    List<Book> getAllByRange(Long min, Long max);
}
