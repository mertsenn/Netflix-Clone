package com.example.clone.clonedemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.clone.clonedemo.entity.SavedMoviesAndTv;
import com.example.clone.clonedemo.entity.UserRating;
import com.example.clone.clonedemo.repository.MovieRatingRepository;
import com.example.clone.clonedemo.repository.SaveMovieAndTvRepository;

@Service
public class SaveMovieAndTvService {

    private final SaveMovieAndTvRepository savedMovieRepository;
    private final MovieRatingRepository movieRatingRepository;

    public SaveMovieAndTvService(SaveMovieAndTvRepository savedMovieRepository,
            MovieRatingRepository movieRatingRepository) {
        this.savedMovieRepository = savedMovieRepository;
        this.movieRatingRepository = movieRatingRepository;
    }

    public SavedMoviesAndTv saveMovie(SavedMoviesAndTv savedMovies) {
        return savedMovieRepository.save(savedMovies);
    }

    public SavedMoviesAndTv findSavedMovieById(int id) {
        return savedMovieRepository.findById(id).orElse(null);
    }

    public List<SavedMoviesAndTv> getSavedMovies() {
        return savedMovieRepository.findAll();
    }

    public void deleteMovie(SavedMoviesAndTv savedMovies) {
        savedMovieRepository.delete(savedMovies);
    }

    public void updateMovieRate(int movieId, int userRating) {
        SavedMoviesAndTv savedMovie = findSavedMovieById(movieId);
        savedMovie.setUserRate(userRating);
        savedMovieRepository.save(savedMovie);
    }

    public void rateMovieOrTvSeries(int movieId, int ratingValue) {
        SavedMoviesAndTv savedMoviesAndTv = savedMovieRepository.findById(movieId).orElse(null);
        if (savedMoviesAndTv == null) {
            UserRating userRating = new UserRating();
            userRating.setUserRating(ratingValue);
            userRating.setMovieId(movieId);
            movieRatingRepository.save(userRating);
        } else {
            UserRating userRating = new UserRating();
            userRating.setUserRating(ratingValue);
            userRating.setMovieId(movieId);
            movieRatingRepository.save(userRating);

            SavedMoviesAndTv savedMovie = findSavedMovieById(movieId);
            savedMovie.setUserRate(ratingValue);
            savedMovieRepository.save(savedMovie);

            

            // String rateUrl = configuration.getBaseUrl() + "/movie/" + movieId + "/rating?api_key="
            //         + configuration.getApiKey() + "&guest_session_id="
            //         + configuration.getGuestSession();

            // // userin verdiği puanı kaydediyoruz ve filmi güncelliyoruz

            // Map<String, Integer> rateMap = new HashMap<>();
            // rateMap.put("value", ratingValue);
            // HttpHeaders headers = new HttpHeaders();

            // headers.setContentType(MediaType.APPLICATION_JSON);

            // HttpEntity<Map<String, Integer>> requestEntity = new HttpEntity<>(rateMap, headers);

            // RestTemplate restTemplate = new RestTemplate();
            // String response = restTemplate.postForObject(rateUrl, requestEntity, String.class);
            // System.out.println("TMDB Rating Response: " + response);
        }

    }

}
