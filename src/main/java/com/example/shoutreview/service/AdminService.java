package com.example.shoutreview.service;

import com.example.shoutreview.domain.Movie;
import com.example.shoutreview.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private MovieRepository movieRepository;

    public AdminService(MovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }
    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

}
