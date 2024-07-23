package com.example.shoutreview.service.request;

import com.example.shoutreview.domain.Movie;
import com.example.shoutreview.domain.Review;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {
    private String movieReview;
    private double rating;
    private long movieId;

    public Review toReview(){
        return Review.builder()
                .movieReview(movieReview)
                .rating(rating)
                .movie(Movie.builder()
                        .id((int) movieId)
                        .build())
                .build();
    }

}
