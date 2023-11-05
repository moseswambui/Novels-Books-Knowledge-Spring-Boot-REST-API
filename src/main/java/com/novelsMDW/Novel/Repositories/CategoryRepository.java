package com.novelsMDW.Novel.Repositories;

import com.novelsMDW.Novel.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
