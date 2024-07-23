package com.example.shoutreview.service;

import com.example.shoutreview.domain.Movie;
import com.example.shoutreview.domain.Review;
import com.example.shoutreview.repository.MovieRepository;
import com.example.shoutreview.repository.ReviewRepository;
import com.example.shoutreview.service.response.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    public void addReview(Review review){
        Movie movie=movieRepository.findById((long) review.getMovie().getId()).orElse(null);
        reviewRepository.save(review);
        //this is heavy operation so need to optimised
        if(movie!=null){
            Double average= reviewRepository.getReviewAverage((long) movie.getId());
            movie.setRating(average);
            movieRepository.save(movie);
        }

    }

    public ReviewResponse getReviewById(Long reviewId){
        Optional<Review> review= reviewRepository.findById(reviewId);
        if(review.isPresent())
            return Review.toReviewResponse(review.get());
        else
            return null;
    }
}
