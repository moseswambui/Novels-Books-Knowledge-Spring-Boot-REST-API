package com.novelsMDW.Novel.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
