package com.example.clone.clonedemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.clone.clonedemo.entity.UserRating;
import com.example.clone.clonedemo.repository.MovieRatingRepository;

@Service
public class MovieRatingService {

    final MovieRatingRepository movieRatingRepository;
    public MovieRatingService(MovieRatingRepository movieRatingRepository) {
        this.movieRatingRepository = movieRatingRepository;
    }

    public List<UserRating> getAllRatings() {
        return movieRatingRepository.findAll();
    }

}
