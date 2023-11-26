package com.example.datasofttestapi.repositories;

import com.example.datasofttestapi.models.entities.Book;
import com.example.datasofttestapi.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT u FROM Book u WHERE u.gen_id.id= :genreId")
    List<Book> findAllByCategory(@Param("genreId") Long id);


    @Query("SELECT u FROM Book u WHERE u.price BETWEEN :minPrice AND :maxPrice")
    List<Book> findAllByPriceRange(@Param("minPrice") Long minPrice, @Param("maxPrice") Long maxPrice);



}
