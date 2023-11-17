package com.novelsMDW.Novel.Service.CustomBook;

import com.novelsMDW.Novel.Entities.Author;
import com.novelsMDW.Novel.Entities.Book;
import com.novelsMDW.Novel.Entities.Category;

import java.util.List;

public interface BookService {
    List<Book> findBooksByAuthorAndCategory(Author author, Category category);
}
