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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "username")
    private String username;

    @Column(name = "passwd")
    private String passwd;

    @Column(name = "state")
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
