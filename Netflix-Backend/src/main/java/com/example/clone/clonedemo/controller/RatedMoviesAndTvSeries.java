package com.example.clone.clonedemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clone.clonedemo.entity.UserRating;
import com.example.clone.clonedemo.service.MovieRatingService;

@RestController
@RequestMapping("/api/rated")
public class RatedMoviesAndTvSeries {

    private final MovieRatingService movieRatingService;

    public RatedMoviesAndTvSeries(MovieRatingService movieRatingService) {
        this.movieRatingService = movieRatingService;
    }

    @GetMapping("/get-all-movies-and-tv-series")
    public List<UserRating> getAllMoviesOrTvSeries() {
        List<UserRating> userRatings = movieRatingService.getAllRatings();
        return userRatings;
    }

}
