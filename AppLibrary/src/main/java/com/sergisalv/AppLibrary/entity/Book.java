package com.sergisalv.AppLibrary.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="tbl-books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;
    private String author;
    private String description;
    private String isbn;
}
