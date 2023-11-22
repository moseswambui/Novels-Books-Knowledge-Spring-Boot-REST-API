package com.novelsMDW.Novel.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

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
    private Long authorId;
    private List<Long> categories;
    private String library;
}
