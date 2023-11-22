package com.novelsMDW.Novel.DTOs.NProblem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookListDTO {

    private Long bookId;
    private String name;
    private String description;
}
