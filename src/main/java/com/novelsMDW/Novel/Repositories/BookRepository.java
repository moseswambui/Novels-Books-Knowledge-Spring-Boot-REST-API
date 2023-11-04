package com.novelsMDW.Novel.Repositories;

import com.novelsMDW.Novel.Entities.Author;
import com.novelsMDW.Novel.Entities.Book;
import com.novelsMDW.Novel.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByCategory(Category category);
    List<Book> findAllByAuthor(Author author);
}
