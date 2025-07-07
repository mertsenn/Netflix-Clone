package com.example.clone.clonedemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.clone.clonedemo.response.MovieResponse;
import com.example.clone.clonedemo.service.MovieApiService;

@RestController
@RequestMapping("api/movie")
@CrossOrigin(origins = "http://localhost:3003") // Önyüz portunu burada belirtin

public class MovieController {

    private final MovieApiService movieApiService;

    public MovieController(MovieApiService movieApiService) {
        this.movieApiService = movieApiService;
    }

    @GetMapping("/popular")
    public List<String> getMovieNames() {
        return movieApiService.gelAllMovieNames();
    }

    @GetMapping("/genres")
    public String getGenres() {
        return movieApiService.getMoviesWithGenres().toString();
    }

    @GetMapping("/poster")
    public List<String> getMoviePoster() {
        return movieApiService.getMoviePoster();
    }

    @GetMapping("/all-popular-movies")
    public MovieResponse getMethodName() {
        return movieApiService.getAllPopularMovie();
    }

    @GetMapping("/all-top-rated-movies")
    public MovieResponse getAllTopRatedMovies() {
        return movieApiService.getAllTopRatedMovies();
    }

    @GetMapping("/all-horror-movies")
    public MovieResponse getAllHorrorMovieResponse() {
        return movieApiService.getAllHorrorMovies();
    }

    @GetMapping("/all-romance-movies")
    public MovieResponse getAllRomanceMovieResponse() {
        return movieApiService.getAllRomanceMovies();
    }

    @GetMapping("/all-crime-movies")
    public MovieResponse getAllCrimeMovieResponse() {
        return movieApiService.getAllCrimeMovies();
    }

    @GetMapping("/all-documentary-movies")
    public MovieResponse getAllDocumentaryMovieResponse() {
        return movieApiService.getAllDocumentaryMovies();
    }

    @GetMapping("/all-drama-movies")
    public MovieResponse getAllDramaMovieResponse() {
        return movieApiService.getAllDramaMovies();
    }

    @GetMapping("/all-action-movies")
    public MovieResponse getAllActionMovieResponse() {
        return movieApiService.getAllActionMovies();
    }

    @GetMapping("/all-animation-movies")
    public MovieResponse getAllAnimationMovieResponse() {
        return movieApiService.getAllAnimationMovies();
    }

    @GetMapping("/all-comedy-movies")
    public MovieResponse getAllComedyMovieResponse() {
        return movieApiService.getAllComedyMovies();
    }

    @GetMapping("/all-netflix-originals")
    public MovieResponse getAllNetflixOriginals() {
        return movieApiService.getAllNetflixOriginals();
    }

    @GetMapping("/videos")
    public String getMovieVideos(
            @RequestParam("movie-id") int movieId) {
        return movieApiService.getMovieVideos(movieId);
    }

    // @PostMapping("/rate-movie")
    // public void rateMovie(
    //         @RequestParam("movie-id") int movieId,
    //         @RequestParam("rating") int rating) {

    //     movieApiService.rateProduction(movieId, rating);

    // }

    @GetMapping("/get-movie-genres")
    public List<String> getMovieGenreNames(@RequestParam("movie-id") int movieId) {
        return movieApiService.getMovieGenreNames(movieId);
    }

}
