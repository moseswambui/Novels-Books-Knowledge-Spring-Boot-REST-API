package com.novelsMDW.Novel.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;
    private String name;
    private String email;
    private String biography;
    private Date birthDate;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonManagedReference  // Use this annotation to indicate that this is the owning side of the relationship
    private List<Book> books = new ArrayList<>();

}
