package com.novelsMDW.Novel.Entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    private String description;

    private String image;

    private String language;

    private Date publishDate;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author author;

    private int page;
}
