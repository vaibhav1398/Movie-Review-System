package com.example.shoutreview.domain;

import com.example.shoutreview.service.MovieService;
import com.example.shoutreview.service.response.MovieResponse;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "movie_table")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movie implements Serializable {

    @Autowired
    MovieService movieService;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private double rating;  //a single entity which is average rating of all reviews for a movie

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;

    public MovieResponse toMovieResponse(){
        return MovieResponse.builder().genre(genre).title(this.title).rating(this.rating).reviews(Review.toReviewResponse(this.reviews)).build();
    }
}
