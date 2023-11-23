package com.novelsMDW.Novel.Service.NProblem;

import com.novelsMDW.Novel.DTOs.NProblem.UserReviewsDTO;
import com.novelsMDW.Novel.DTOs.ReviewsDTO;
import com.novelsMDW.Novel.Entities.Reviews;
import com.novelsMDW.Novel.Entities.UserProfile;
import com.novelsMDW.Novel.Repositories.ReviewsRepository;
import com.novelsMDW.Novel.Repositories.UserProfileRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserReviewService {
    private final UserProfileRepository userProfileRepository;
    private final ReviewsRepository reviewsRepository;

    public UserReviewsDTO getUserReviews(Long userId){
        UserProfile userProfile = userProfileRepository.findById(userId)
                .orElseThrow(()->
                        new EntityNotFoundException("User not found"));

        List<Reviews> userReviews = reviewsRepository.findAllByUserProfile(userProfile);
        List<ReviewsDTO> reviewsDTOList = userReviews.stream()
                .map(reviews -> new ReviewsDTO(
                        reviews.getReviewId(),
                        reviews.getReviewDate(),
                        reviews.getDescription(),
                        reviews.getUserProfile().getProfileId(),
                        reviews.getBook().getBookId()
                ))
                .collect(Collectors.toList());
        return new UserReviewsDTO(userProfile.getProfileId(), userProfile.getFirstName(),reviewsDTOList);
    }
}
