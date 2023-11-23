package com.novelsMDW.Novel.DTOs.NProblem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorBookDTO {
    private Long authorId;
    private String name;
    private String email;
    private String biography;
    private List<BookListDTO> books; // Updated to contain BookDTOs instead of bookIds
}
