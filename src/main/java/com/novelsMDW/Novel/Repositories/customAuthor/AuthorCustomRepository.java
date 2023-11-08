package com.novelsMDW.Novel.Repositories.customAuthor;

import com.novelsMDW.Novel.Entities.Author;

import java.util.List;

public interface AuthorCustomRepository {

    List<Author> findAuthorsByName(String name);
}
