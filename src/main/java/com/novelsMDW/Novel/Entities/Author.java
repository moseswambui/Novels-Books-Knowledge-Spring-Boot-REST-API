package com.novelsMDW.Novel.Entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;
    private String name;
    private String email;
    private String biography;
    private Date birthDate;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

}
