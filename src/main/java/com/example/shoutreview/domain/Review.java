package com.example.shoutreview.domain;

import com.example.shoutreview.service.response.ReviewResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="review_system")
@ToString
public class Review {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String movieReview;

    private double rating;      //rating dedicated to each review

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    @JsonIgnore
    private Movie movie;    //it will add foreign key in mysql table with <TABLE_NAME>_<ID_NAME> -->> //movie_movie_id

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updateDate;

    public static ReviewResponse toReviewResponse(Review review){
        return ReviewResponse.builder().review(review.movieReview).rating(review.rating).build();
    }

    public static List<ReviewResponse> toReviewResponse(List<Review> reviewList){
        if(Objects.isNull(reviewList))
            return new ArrayList<>();
        else
            return reviewList.stream().map(Review::toReviewResponse).collect(Collectors.toList());
    }
}
