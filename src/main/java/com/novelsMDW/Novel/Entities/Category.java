package com.novelsMDW.Novel.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "category")
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private  String name;

    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Book> books;
}
