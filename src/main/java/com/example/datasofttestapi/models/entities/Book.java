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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "summary")
    private String summary;

    @Column(name = "price")
    private Double price;

    @Column(name = "state")
    private String state;

    @Column(name = "image")
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
