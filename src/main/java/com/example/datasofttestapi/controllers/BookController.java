package com.example.datasofttestapi.controllers;


import com.example.datasofttestapi.models.dtos.BookDTO;
import com.example.datasofttestapi.models.dtos.BookUpdateDTO;
import com.example.datasofttestapi.models.entities.Book;
import com.example.datasofttestapi.models.entities.User;
import com.example.datasofttestapi.repositories.BookRepository;
import com.example.datasofttestapi.services.BookService;
import com.example.datasofttestapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/BOOKSTORE/")
public class BookController {

    @Autowired
    BookService bookSv;
    @Autowired
    BookRepository bookRp;

    @Autowired
    UserService userSv;

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

    @PutMapping("book/update/{id}")
    public ResponseEntity<?> updateBook(@PathVariable("id") Long id, @RequestBody BookUpdateDTO bookUpdateDTO){


        try {

                User user = userSv.findById(bookUpdateDTO.getUserId());
                Book book = bookSv.findById(id);


                System.out.println(book.getState());
                if(book.getState().equals("DIS")) {
                    book.setState("ALQ");
                    book.setUser_id(user);
                }else{
                    book.setUser_id(null);
                    book.setState("DIS");
                }
                bookSv.save(book);
                return new ResponseEntity<>("Book  Updated Successful", HttpStatus.ACCEPTED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error Data Processing", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
