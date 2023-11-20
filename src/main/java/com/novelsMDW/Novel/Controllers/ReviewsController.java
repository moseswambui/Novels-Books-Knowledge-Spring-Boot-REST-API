package com.novelsMDW.Novel.Controllers;

import com.novelsMDW.Novel.Entities.Reviews;
import com.novelsMDW.Novel.Service.ReviewsService;
import com.novelsMDW.Novel.requests.ReviewsRequest;
import com.novelsMDW.Novel.requests.UserProfileRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewsController {

    @Autowired
    private ReviewsService reviewsService;

    @PostMapping("/add")
    public Reviews addReview(@RequestBody ReviewsRequest reviewsRequest){
        return reviewsService.addReview(reviewsRequest);
    }

    @GetMapping("/{id}")
    public Reviews getReview(@PathVariable Long id){
        return reviewsService.getReviewById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id){
        reviewsService.deleteReview(id);
    }

    @GetMapping("/all")
    public List<Reviews> getAllReviews(){
        return reviewsService.getAllReviews();
    }
    @GetMapping("/with-user-profile-and-book")
    public List<Reviews> getAllReviewsWithUserProfileAndBook() {
        return reviewsService.getAllReviewsWithUserProfileAndBook();
    }
}
