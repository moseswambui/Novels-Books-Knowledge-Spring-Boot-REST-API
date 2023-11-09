package com.novelsMDW.Novel.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    @JsonBackReference
    private Category category;

    private String description;

    private String image;

    private String language;

    private Date publishDate;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "authorId")
    @JsonBackReference // Use this annotation to indicate that this is the non-owning side of the relationship
    private Author author;

    private int page;

    @ElementCollection
    @CollectionTable(name = "libraries", joinColumns = @JoinColumn(name = "author_id"))
    @Column(name = "libraries")
    private Set<String> libraries = new HashSet<>();

    @Transient
    private int bookAge;
}
