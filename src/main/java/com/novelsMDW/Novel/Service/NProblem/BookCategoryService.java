package com.novelsMDW.Novel.Service.NProblem;

import com.novelsMDW.Novel.DTOs.CategoryDTO;
import com.novelsMDW.Novel.DTOs.NProblem.BookWithCategoriesDTO;
import com.novelsMDW.Novel.Entities.Book;
import com.novelsMDW.Novel.Repositories.BookRepository;
import com.novelsMDW.Novel.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookCategoryService {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public BookCategoryService(BookRepository bookRepository, CategoryRepository categoryRepository){
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<BookWithCategoriesDTO> getAllBooksWithCategories(){
        List<Book> books = bookRepository.findAll(); //FETCH ALL THE BOOKS

        List<BookWithCategoriesDTO> bookswithCategories = new ArrayList<>();

        for (Book book : books){
            List<CategoryDTO> categories = categoryRepository.findCategoryByBookId(book.getBookId());

            BookWithCategoriesDTO bookWithCategories = new BookWithCategoriesDTO(
                    book.getBookId(),
                    book.getName(),
                    categories
            );
            bookswithCategories.add(bookWithCategories);
        }
        return bookswithCategories;
    }
}
