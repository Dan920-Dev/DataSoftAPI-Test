package com.example.datasofttestapi.controllers;


import com.example.datasofttestapi.models.dtos.BookDTO;
import com.example.datasofttestapi.models.entities.Book;
import com.example.datasofttestapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/BOOKSTORE/")
public class BookController {

    @Autowired
    BookService bookSv;

    @GetMapping("book/byGenre/{id}")
    public ResponseEntity<?> getBooksByGenre(@PathVariable Long id){
        try{
            List<Book> products = bookSv.getAllBooksByGenre(id);

            List<BookDTO> response = products.stream()
                    .map(book -> {

                        String userName = (book.getUser_id() != null) ? book.getUser_id().getUsername() : "N/A";

                        return new BookDTO(
                                book.getId(),
                                book.getName(),
                                book.getSummary(),
                                book.getPrice(),
                                book.getState(),
                                book.getImage(),
                                book.getGen_id().getName(),
                                userName);
                    })
                    .toList();

            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error Data Processing", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("book/detail/{id}")
    public ResponseEntity<?> getBookDetail(@PathVariable Long id){
        try{
            Book book = bookSv.findById(id);

            String userName = (book.getUser_id() != null) ? book.getUser_id().getUsername() : "N/A";

            BookDTO response = new BookDTO(
                    book.getId(),
                    book.getName(),
                    book.getSummary(),
                    book.getPrice(),
                    book.getState(),
                    book.getImage(),
                    book.getGen_id().getName(),
                    userName);

            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (Exception e){

            e.printStackTrace();
            return new ResponseEntity<>("Error processing product data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
