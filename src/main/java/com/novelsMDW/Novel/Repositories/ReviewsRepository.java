package com.novelsMDW.Novel.Repositories;

import com.novelsMDW.Novel.Entities.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Long> {

    /*
    This query retrieves all Books along with their associated Reviews using
    LEFT JOIN FETCH, ensuring that the Reviews are loaded eagerly with the Books.
     */
    @Query("SELECT r FROM Reviews r JOIN FETCH r.userProfile JOIN FETCH r.book")
    List<Reviews> findAllWithUserProfileAndBook();
}
