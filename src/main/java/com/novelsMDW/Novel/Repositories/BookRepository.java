package com.novelsMDW.Novel.Repositories;

import com.novelsMDW.Novel.Entities.Author;
import com.novelsMDW.Novel.Entities.Book;
import com.novelsMDW.Novel.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b JOIN b.categories c WHERE c = :category")
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByAuthor(Author author);

    @Query(value = "SELECT * FROM book WHERE name LIKE ?1", nativeQuery = true)
    List<Book> findBooksByName(String name);
}
