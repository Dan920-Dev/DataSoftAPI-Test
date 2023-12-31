package com.example.datasofttestapi.services.implementation;

import com.example.datasofttestapi.models.entities.Book;
import com.example.datasofttestapi.repositories.BookRepository;
import com.example.datasofttestapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookImp implements BookService {
    @Autowired
    BookRepository bookRp;

    public List<Book> getAllBooksByGenre(Long id){
        List<Book> books = bookRp.findAllByCategory(id);
        return books;
    }

    @Override
    public Book findById(Long id) {
        Book book = bookRp.findById(id).orElse(null);
        return book;
    }

    @Override
    public void save(Book book) {
        bookRp.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRp.findAll();
    }

    @Override
    public List<Book> getAllByRange(Long min, Long max) {
        return bookRp.findAllByPriceRange(min, max);
    }

}
