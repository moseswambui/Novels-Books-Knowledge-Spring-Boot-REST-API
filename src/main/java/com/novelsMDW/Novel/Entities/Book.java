package com.novelsMDW.Novel.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "authorId")
    private Author author;

    private int page;

    @ElementCollection
    @CollectionTable(name = "libraries", joinColumns = @JoinColumn(name = "author_id"))
    @Column(name = "libraries")
    private Set<String> libraries = new HashSet<>();

    @Transient
    private int bookAge;
}
