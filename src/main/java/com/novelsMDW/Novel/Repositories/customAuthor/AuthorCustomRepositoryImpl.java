package com.novelsMDW.Novel.Repositories.customAuthor;

import com.novelsMDW.Novel.Entities.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorCustomRepositoryImpl implements AuthorCustomRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Author> findAuthorsByName(String name){
        String nativeQuery = "SELECT * FROM author WHERE name = :authorName";

        return entityManager
                .createNativeQuery(nativeQuery, Author.class)
                .setParameter("authorName", name)
                .getResultList();
    }
}
