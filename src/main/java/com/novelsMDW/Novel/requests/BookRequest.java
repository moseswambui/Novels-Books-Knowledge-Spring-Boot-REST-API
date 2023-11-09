package com.novelsMDW.Novel.requests;

import com.novelsMDW.Novel.Entities.Author;
import com.novelsMDW.Novel.Entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
public class BookRequest {

    private String name;
    private String description;
    //private String image;
    private String language;
    private Date publishDate;
    private int page;
    private Author author;
    private Category category;
    private String library;
}
