package com.novelsMDW.Novel.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long bookId;
    private String name;
    private Set<Long> categoryIds;
    private String description;
    private String image;
    private String language;
    private Date publishDate;
    private Long authorId;
    private int page;
    private Set<String> libraries;
    private List<Long> reviewIds;
    private int bookAge;

    public BookDTO(Long bookId, String name) {
    }
}
