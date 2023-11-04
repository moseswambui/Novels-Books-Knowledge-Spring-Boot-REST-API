package com.novelsMDW.Novel.Repositories;

import com.novelsMDW.Novel.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
