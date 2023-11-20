package com.novelsMDW.Novel.Repositories;

import com.novelsMDW.Novel.Entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    /*
    This query retrieves all UserProfiles along with their associated Reviews.
    Using LEFT JOIN FETCH ensures that the Reviews are eagerly loaded with the
    UserProfiles, avoiding the N+1 problem.
    */
    @Query("SELECT DISTINCT u FROM UserProfile u LEFT JOIN FETCH u.reviews")
    List<UserProfile> findAllUserProfilesWithReviews();
}
