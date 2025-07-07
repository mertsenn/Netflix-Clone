package com.example.clone.clonedemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.clone.clonedemo.entity.SavedMoviesAndTv;
import com.example.clone.clonedemo.service.SaveMovieAndTvService;

@RestController
@RequestMapping("/api/post")

public class SavedMovieandTvSeriesController {

    private final SaveMovieAndTvService saveMovieService;

    public SavedMovieandTvSeriesController(SaveMovieAndTvService saveMovieService) {
        this.saveMovieService = saveMovieService;
    }

    @PostMapping("/save-movie")
    public SavedMoviesAndTv saveMovie(@RequestBody SavedMoviesAndTv savedMovies) {
        return saveMovieService.saveMovie(savedMovies);
    }

    @GetMapping("/all-saved-movies")
    public List<SavedMoviesAndTv> getSavedMovies() {
        return saveMovieService.getSavedMovies();
    }

    @DeleteMapping("/delete-movie")
    public void deleteMovie(@RequestBody SavedMoviesAndTv savedMovies) {
        saveMovieService.deleteMovie(savedMovies);
    }

    @PostMapping("rate-movie")
    public void postMethodName(@RequestParam("movie-id") int movieId,
            @RequestParam("rating") int userRating) {
        saveMovieService.rateMovieOrTvSeries(movieId, userRating);

    }

}
