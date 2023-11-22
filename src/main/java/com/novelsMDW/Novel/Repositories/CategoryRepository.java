package com.novelsMDW.Novel.Repositories;

import com.novelsMDW.Novel.DTOs.CategoryDTO;
import com.novelsMDW.Novel.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT c FROM Category c JOIN c.books b WHERE b.bookId = :bookId")
    List<CategoryDTO> findCategoryByBookId(@Param("bookId") Long bookId);
}
