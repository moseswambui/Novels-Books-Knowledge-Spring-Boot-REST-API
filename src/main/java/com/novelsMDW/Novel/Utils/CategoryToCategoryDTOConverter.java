/*
package com.novelsMDW.Novel.Utils;


import com.novelsMDW.Novel.DTOs.CategoryDTO;
import com.novelsMDW.Novel.Entities.Category;
import org.springframework.cglib.core.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryDTOConverter implements Converter<Category, CategoryDTO> {

    @Override
    public CategoryDTO convert(CategoryDTO category){
        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setCategoryId(category.getCategoryId());
        categoryDTO.setName(category.getName());

        return categoryDTO;
    }
}
*/