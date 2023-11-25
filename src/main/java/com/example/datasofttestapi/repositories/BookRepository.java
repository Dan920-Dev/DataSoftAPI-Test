package com.example.datasofttestapi.repositories;

import com.example.datasofttestapi.models.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT u FROM Book u WHERE u.gen_id.id= :genreId")
    List<Book> findAllByCategory(@Param("genreId") Long id);
}
