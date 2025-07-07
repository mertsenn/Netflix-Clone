package com.example.clone.clonedemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.clone.clonedemo.config.AppConfiguration;
import com.example.clone.clonedemo.config.MovieAppEndPoints;
import com.example.clone.clonedemo.entity.Movie;
import com.example.clone.clonedemo.entity.MovieDetail;
import com.example.clone.clonedemo.entity.MovieVideoResults;
import com.example.clone.clonedemo.response.MovieResponse;
import com.example.clone.clonedemo.response.VideosResponse;

@Service
public class MovieApiService {

    
    private final RestTemplate restTemplate = new RestTemplate();
    private final GenreService genreService;
    private final MovieAppEndPoints movieAppEndPoints;
    private final AppConfiguration appConfiguration;
   

    public MovieApiService(GenreService genreService, MovieAppEndPoints movieAppEndPoints, AppConfiguration appConfiguration) {
        this.genreService = genreService;
        this.movieAppEndPoints = movieAppEndPoints;
        this.appConfiguration = appConfiguration;

    }

    public List<String> gelAllMovieNames() {
        MovieResponse movieResponse = restTemplate.getForObject(movieAppEndPoints.getPopularMoviesUrl(), MovieResponse.class);
        if ((movieResponse == null) || movieResponse.getMovies() == null) {
            return new ArrayList<>();
        }
        return movieResponse.getMovies().stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
    }

    public List<String> getMoviesWithGenres() {
        MovieResponse movieResponse = restTemplate.getForObject(movieAppEndPoints.getPopularMoviesUrl(), MovieResponse.class);

        if (movieResponse == null || movieResponse.getMovies() == null) {
            return List.of();
        }

        // Filmleri ve türlerini birleştirerek tek bir liste döndür
        return movieResponse.getMovies().stream()
                .map(movie -> {
                    List<String> genreNames = genreService.getMovieGenres(movie.getGenreIds());
                    return movie.getTitle() + " - Genres: " + String.join(", ", genreNames);
                })
                .collect(Collectors.toList());
    }

    public List<String> getMoviePoster() {
        String posterUrl;
        List<String> posterUrls = new ArrayList<>();

        MovieResponse movieResponse = restTemplate.getForObject(movieAppEndPoints.getPopularMoviesUrl(), MovieResponse.class);
        if (movieResponse != null && movieResponse.getMovies() != null) {
            List<String> moviePaths = movieResponse.getMovies().stream()
                    .map(Movie::getPosterPath)
                    .collect(Collectors.toList());
            for (String path : moviePaths) {
                posterUrl = appConfiguration.getImageUrl() + path;
                posterUrls.add(posterUrl);
            }
            return posterUrls;
        }
        return List.of();
    }

    public MovieResponse getAllPopularMovie() {

        MovieResponse allPopularMovies = restTemplate.getForObject(movieAppEndPoints.getPopularMoviesUrl(), MovieResponse.class);
        if (allPopularMovies != null && allPopularMovies.getMovies() != null) {
            return allPopularMovies;
        }
        return null;
    }

    public MovieResponse getAllTopRatedMovies() {
        MovieResponse allTopRatedMovies = restTemplate.getForObject(movieAppEndPoints.getTopRatedMoviesUrl(), MovieResponse.class);

        if (allTopRatedMovies != null && allTopRatedMovies.getMovies() != null) {
            return allTopRatedMovies;
        }
        return null;
    }

    public MovieResponse getAllHorrorMovies() {
        MovieResponse horrorMovieResponse = restTemplate.getForObject(movieAppEndPoints.getHorrorMoviesUrl(), MovieResponse.class);

        if (horrorMovieResponse != null && horrorMovieResponse.getMovies() != null) {
            return horrorMovieResponse;
        }
        return null;
    }

    public MovieResponse getAllRomanceMovies() {
        MovieResponse romanceMovieResponse = restTemplate.getForObject(movieAppEndPoints.getRomanceMoviesUrl(), MovieResponse.class);

        if (romanceMovieResponse != null && romanceMovieResponse.getMovies() != null) {
            return romanceMovieResponse;
        }
        return null;
    }

    public MovieResponse getAllCrimeMovies() {
        MovieResponse crimeMovieResponse = restTemplate.getForObject(movieAppEndPoints.getCrimeMoviesUrl(), MovieResponse.class);
        if (crimeMovieResponse != null && crimeMovieResponse.getMovies() != null) {
            return crimeMovieResponse;
        }
        return null;
    }

    public MovieResponse getAllDocumentaryMovies() {
        MovieResponse documentaryMovieResponse = restTemplate.getForObject(movieAppEndPoints.getDocumentaryMoviesUrl(), MovieResponse.class);
        if (documentaryMovieResponse != null && documentaryMovieResponse.getMovies() != null) {
            return documentaryMovieResponse;
        }
        return null;
    }

    public MovieResponse getAllDramaMovies() {
        MovieResponse dramaMovieResponse = restTemplate.getForObject(movieAppEndPoints.getDramaMoviesUrl(), MovieResponse.class);
        if (dramaMovieResponse != null && dramaMovieResponse.getMovies() != null) {
            return dramaMovieResponse;
        }
        return null;
    }

    public MovieResponse getAllAnimationMovies() {
        MovieResponse animationMovieResponse = restTemplate.getForObject(movieAppEndPoints.getAnimationMoviesUrl(), MovieResponse.class);
        if (animationMovieResponse != null && animationMovieResponse.getMovies() != null) {
            return animationMovieResponse;
        }
        return null;
    }

    public MovieResponse getAllActionMovies() {
        MovieResponse actionMovieResponse = restTemplate.getForObject(movieAppEndPoints.getActionMoviesUrl(), MovieResponse.class);
        if (actionMovieResponse != null && actionMovieResponse.getMovies() != null) {
            return actionMovieResponse;
        }
        return null;
    }

    public MovieResponse getAllComedyMovies() {
        MovieResponse comedyMovieResponse = restTemplate.getForObject(movieAppEndPoints.getComedyMoviesUrl(), MovieResponse.class);
        if (comedyMovieResponse != null && comedyMovieResponse.getMovies() != null) {
            return comedyMovieResponse;
        }
        return null;
    }

    public MovieResponse getAllNetflixOriginals() {
        MovieResponse netflixOriginalsResponse = restTemplate.getForObject(movieAppEndPoints.getNetflixMoviesUrl(), MovieResponse.class);
        if (netflixOriginalsResponse != null && netflixOriginalsResponse.getMovies() != null) {
            return netflixOriginalsResponse;
        }
        return null;
    }

    public String getMovieVideos(int movieId) {
        String videoUrl = appConfiguration.getBaseUrl() + "/movie/" + movieId + "/videos?api_key=" + appConfiguration.getApiKey();
        VideosResponse videosResponse = restTemplate.getForObject(videoUrl, VideosResponse.class);
        if (videosResponse != null && videosResponse.getResults() != null) {
            for (MovieVideoResults video : videosResponse.getResults()) {
                if ("Trailer".equalsIgnoreCase(video.getType()) && "YouTube".equalsIgnoreCase(video.getSite())) {
                    return "https://www.youtube.com/watch?v=" + video.getKey();
                }
            }
            // Eğer trailer bulunamadıysa, ilk sonucu döner kebab
            MovieVideoResults firstResult = videosResponse.getResults().get(0);
            return "https://www.youtube.com/watch?v=" + firstResult.getKey();
        }
        return null;
    }

    public List<String> getMovieGenreNames(int movieId) {
        String genreUrl = appConfiguration.getBaseUrl() + "/movie/" + movieId + "?api_key=" + appConfiguration.getApiKey() + "&language=en-US";
        MovieDetail movieDetail = restTemplate.getForObject(genreUrl, MovieDetail.class);
        if (movieDetail != null && movieDetail.getGenres() != null) {
            return movieDetail.getGenres().stream().map(movie -> movie.getName()).toList();
        }
        return List.of();
    }

}
