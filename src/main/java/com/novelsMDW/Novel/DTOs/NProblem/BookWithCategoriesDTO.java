package com.novelsMDW.Novel.DTOs.NProblem;

import com.novelsMDW.Novel.DTOs.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookWithCategoriesDTO {
    private Long bookId;
    private String name;
    private List<CategoryDTO> categories;
}
