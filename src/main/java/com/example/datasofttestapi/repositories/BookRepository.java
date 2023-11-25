package com.example.datasofttestapi.repositories;

import com.example.datasofttestapi.models.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
