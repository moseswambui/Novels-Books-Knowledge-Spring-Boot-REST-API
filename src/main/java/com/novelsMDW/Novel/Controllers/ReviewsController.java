package com.novelsMDW.Novel.Controllers;

import com.novelsMDW.Novel.Entities.Reviews;
import com.novelsMDW.Novel.Service.ReviewsService;
import com.novelsMDW.Novel.requests.ReviewsRequest;
import com.novelsMDW.Novel.requests.UserProfileRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
