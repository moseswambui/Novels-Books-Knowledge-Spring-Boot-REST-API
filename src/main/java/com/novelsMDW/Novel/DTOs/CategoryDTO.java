package com.novelsMDW.Novel.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Long categoryId;
    private String name;
    //private String description;
    //private List<Long> bookIds;
}
