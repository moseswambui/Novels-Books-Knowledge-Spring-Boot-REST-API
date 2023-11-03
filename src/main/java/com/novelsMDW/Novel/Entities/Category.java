package com.novelsMDW.Novel.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Category;

    private  String name;

    @OneToMany(mappedBy = "category")
    private List<Book> books;
}
