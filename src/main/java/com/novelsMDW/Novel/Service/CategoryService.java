package com.novelsMDW.Novel.Service;

import com.novelsMDW.Novel.Entities.Category;
import com.novelsMDW.Novel.Repositories.CategoryRepository;
import com.novelsMDW.Novel.requests.CategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category addCategory(CategoryRequest categoryRequest){
        Category category = new Category();
        category.setName(categoryRequest.getName());
        category.setDescription(categoryRequest.getDescription());

        Category savedCategory = categoryRepository.save(category);
        return  savedCategory;
    }

    public Category getCategoryById(Long id){
        Category category = categoryRepository.findById(id).get();
        return category;
    }

    public void deleteCategory(Long id){
        Category category = new Category();
        categoryRepository.delete(category);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
}
