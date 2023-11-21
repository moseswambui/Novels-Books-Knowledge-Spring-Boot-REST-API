package com.novelsMDW.Novel.DTOs.NProblem;

import com.novelsMDW.Novel.DTOs.BookDTO;
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
    private List<BookDTO> books; // Updated to contain BookDTOs instead of bookIds
}
