package com.novelsMDW.Novel.Repositories;

import com.novelsMDW.Novel.Entities.Author;
import com.novelsMDW.Novel.Entities.Book;
import com.novelsMDW.Novel.Entities.Category;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b JOIN b.categories c WHERE c = :category")
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByAuthor(Author author);

    List<Book> findByName(String name);

    /*
    This query retrieves all Books along with their associated Reviews
    using LEFT JOIN FETCH, ensuring that the Reviews are loaded eagerly
    with the Books.
     */
    @Query("SELECT DISTINCT b FROM Book b LEFT JOIN FETCH b.reviews")
    List<Book> findAllWithReviews();

    @EntityGraph(attributePaths = {"reviews","reviews.userProfile"})
    List<Book> findAll();

}
