package com.example.datasofttestapi.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", length = 30, nullable = false)
    private String full_name;

    @Column(length = 20, nullable = false)
    private String username;

    @Column(length = 20, nullable = false)
    private String passwd;

    @Column(length = 3)
    private String state;

    public User(Long id, String full_name, String username, String passwd, String state) {
        super();
        this.id = id;
        this.full_name = full_name;
        this.username = username;
        this.passwd = passwd;
        this.state = state;
    }
}
