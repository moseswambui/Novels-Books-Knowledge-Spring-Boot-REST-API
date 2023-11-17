package com.novelsMDW.Novel.Repositories;

import com.novelsMDW.Novel.Entities.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Long> {
}
