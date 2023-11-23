package com.novelsMDW.Novel.Controllers.NProblem;

import com.novelsMDW.Novel.DTOs.NProblem.BookWithCategoriesDTO;
import com.novelsMDW.Novel.Service.NProblem.BookCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookCategoryController {

    private final BookCategoryService bookCategoryService;

    public BookCategoryController(BookCategoryService bookCategoryService) {
        this.bookCategoryService = bookCategoryService;
    }

    @GetMapping("/with-categories")
    public ResponseEntity<List<BookWithCategoriesDTO>> getBooksWithCategories() {
        List<BookWithCategoriesDTO> booksWithCategories = bookCategoryService.getAllBooksWithCategories();
        return ResponseEntity.ok(booksWithCategories);
    }
}
