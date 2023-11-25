package com.example.datasofttestapi.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 500)
    private String summary;

    @Column(precision = 6, scale = 2)
    private Double price;

    @Column(length = 3)
    private String state;

    @Column(length = 500)
    private String image;

    @ManyToOne
    @JoinColumn(name = "gen_id", referencedColumnName = "id")
    private Genre gen_id;

    @ManyToOne
    @JoinColumn(name = "usr_id", referencedColumnName = "id")
    private User user_id;

    public Book(Long id, String name, String summary, Double price, String state, String image, Genre gen_id, User user_id) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.price = price;
        this.state = state;
        this.image = image;
        this.gen_id = gen_id;
        this.user_id = user_id;
    }
}
