package com.novelsMDW.Novel.Service;


import com.novelsMDW.Novel.Entities.Reviews;
import com.novelsMDW.Novel.Repositories.BookRepository;
import com.novelsMDW.Novel.Repositories.ReviewsRepository;
import com.novelsMDW.Novel.Repositories.UserProfileRepository;
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
    private UserProfileRepository userProfileRepository;

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    public ReviewsService(ReviewsRepository reviewsRepository){
        this.reviewsRepository = reviewsRepository;
    }

    public Reviews addReview(ReviewsRequest reviewsRequest){
        Reviews reviews = new Reviews();

        reviews.setReviewDate(reviewsRequest.getReviewDate());
        reviews.setDescription(reviewsRequest.getDescription());
        reviews.setUserProfile(userProfileRepository.findById(reviewsRequest.getProfileId()).orElseThrow(() ->
                new RuntimeException("User Profile Not Found")));
        reviews.setBook(bookRepository.findById(reviewsRequest.getBookId()).orElseThrow(() ->
                new RuntimeException("Book Not Found")));

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

    public List<Reviews> getAllReviewsWithUserProfileAndBook() {
        return reviewsRepository.findAllWithUserProfileAndBook();
    }
}
