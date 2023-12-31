package com.example.datasofttestapi.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;

    private String name;

    private String summary;

    private Double price;

    private String state;

    private String image;

    private String gen_name;

    private String user_name;
}
