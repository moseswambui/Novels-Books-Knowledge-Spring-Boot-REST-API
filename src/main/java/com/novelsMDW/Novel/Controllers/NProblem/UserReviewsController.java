package com.novelsMDW.Novel.Controllers.NProblem;

import com.novelsMDW.Novel.DTOs.NProblem.UserReviewsDTO;
import com.novelsMDW.Novel.Service.NProblem.UserReviewService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController

@RequestMapping("/api/user-reviews")
public class UserReviewsController {

    private final UserReviewService userReviewService;

    public UserReviewsController(UserReviewService userReviewService){
        this.userReviewService = userReviewService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserReviewsDTO> getUserReviews(@PathVariable Long userId){
        UserReviewsDTO userReviewsDTO = userReviewService.getUserReviews(userId);
        return ResponseEntity.ok(userReviewsDTO);
    }









    /*
    private final ReviewsRepository reviewsRepository;
    private final UserProfileService userProfileService;

    public UserReviewsController(ReviewsRepository reviewsRepository, UserProfileRepository userProfileRepository){
        this.reviewsRepository = reviewsRepository;
        this.userProfileService = new UserProfileService();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserReviewsDTO>> getReviewsByUserProfile(@PathVariable Long userId){
        UserProfile userProfile = userProfileService.getUserProfileById(userId);

        if (userProfile == null){
            return ResponseEntity.notFound().build();
        }

        List<Reviews> reviews = reviewsRepository.findAllByUserProfile(userProfile);

        List<UserReviewsDTO> reviewsDTOList = reviews.stream()
                .map(this::convertToReviewsDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(reviewsDTOList);
    }

    private UserReviewsDTO convertToReviewsDTO(Reviews reviews){
        UserReviewsDTO userReviewsDTO = new UserReviewsDTO();

        userReviewsDTO.setReviewId(reviews.getReviewId());
        userReviewsDTO.setReviewDate(reviews.getReviewDate());
        userReviewsDTO.setDescription(reviews.getDescription());
        userReviewsDTO.setUserProfileId(reviews.getUserProfile().getProfileId());
        userReviewsDTO.setBookId(reviews.getBook().getBookId());

        return userReviewsDTO;
    }
    */

}
