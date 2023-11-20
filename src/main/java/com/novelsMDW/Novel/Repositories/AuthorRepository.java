package com.novelsMDW.Novel.Repositories;

import com.novelsMDW.Novel.Entities.Author;
import com.novelsMDW.Novel.Entities.Book;
import com.novelsMDW.Novel.Repositories.customAuthor.AuthorCustomRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long>, AuthorCustomRepository {
    List <Book> findByAuthorId(Long bookId);

}
