package com.novelsMDW.Novel.Service;


import com.novelsMDW.Novel.Entities.Reviews;
import com.novelsMDW.Novel.Repositories.ReviewsRepository;
import com.novelsMDW.Novel.requests.ReviewsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewsService {

    private ReviewsRepository reviewsRepository;

    @Autowired
    public ReviewsService(ReviewsRepository reviewsRepository){
        this.reviewsRepository = reviewsRepository;
    }

    public Reviews addReview(ReviewsRequest reviewsRequest){
        Reviews reviews = new Reviews();

        reviews.setReviewDate(reviewsRequest.getReviewDate());
        reviews.setDescription(reviewsRequest.getDescription());
        reviews.setUserProfile(reviewsRequest.getUserProfile());
        reviews.setBook(reviewsRequest.getBook());

        Reviews savedReviews = reviewsRepository.save(reviews);

        return savedReviews;
    }

    public Reviews getReviewById(Long id){
        Reviews reviews = reviewsRepository.findById(id).get();
        return reviews;
    }
    public void deleteReview(Long id){
        Reviews reviews = reviewsRepository.findById(id).get();
        reviewsRepository.delete(reviews);
    }

    public List<Reviews> getAllReviews(){
        return reviewsRepository.findAll();
    }
}
