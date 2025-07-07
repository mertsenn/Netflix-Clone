package com.example.clone.clonedemo.config;

import org.springframework.stereotype.Component;

@Component
public class MovieAppEndPoints {

    private final AppConfiguration appConfiguration;

    public MovieAppEndPoints(AppConfiguration appConfiguration) {
        this.appConfiguration = appConfiguration;
    }
    public String getPopularMoviesUrl() {
        return appConfiguration.getBaseUrl() + "/movie/popular?api_key=" + appConfiguration.getApiKey();
    }
    public String getTopRatedMoviesUrl() {
        return appConfiguration.getBaseUrl() + "/movie/top_rated?api_key=" + appConfiguration.getApiKey();
    }
    public String getHorrorMoviesUrl() {
        return appConfiguration.getBaseUrl() + "/discover/movie?api_key=" + appConfiguration.getApiKey() + "&with_genres=27" + "&language=en-US";
    }
    public String getRomanceMoviesUrl() {
        return appConfiguration.getBaseUrl() + "/discover/movie?api_key=" + appConfiguration.getApiKey() + "&with_genres=10749" + "&language=en-US";
    }
    public String getCrimeMoviesUrl() {
        return appConfiguration.getBaseUrl() + "/discover/movie?api_key=" + appConfiguration.getApiKey() + "&with_genres=80"+ "&language=en-US";
    }
    public String getDocumentaryMoviesUrl() {
        return appConfiguration.getBaseUrl() + "/discover/movie?api_key=" + appConfiguration.getApiKey() + "&with_genres=99"+ "&language=en-US";
    }
    public String getDramaMoviesUrl() {
        return appConfiguration.getBaseUrl() + "/discover/movie?api_key=" + appConfiguration.getApiKey() + "&with_genres=18"+ "&language=en-US";
    }
    public String getAnimationMoviesUrl() {
        return appConfiguration.getBaseUrl() + "/discover/movie?api_key=" + appConfiguration.getApiKey() + "&with_genres=16"+ "&language=en-US";
    }
    public String getActionMoviesUrl() {
        return appConfiguration.getBaseUrl() + "/discover/movie?api_key=" + appConfiguration.getApiKey() + "&with_genres=28"+ "&language=en-US";
    }
    public String getComedyMoviesUrl() {
        return appConfiguration.getBaseUrl() + "/discover/movie?api_key=" + appConfiguration.getApiKey() + "&with_genres=35"+ "&language=en-US";
    }
    public String getNetflixMoviesUrl() {
        return appConfiguration.getBaseUrl() + "/discover/movie?api_key=" + appConfiguration.getApiKey() + "&with_networks=213&language=en-US";
    }
    public String getPopularTvSeriesUrl() {
        return appConfiguration.getBaseUrl() + "/tv/popular?api_key=" + appConfiguration.getApiKey();
    }
    public String getTopRatedTvSeriesUrl() {
        return appConfiguration.getBaseUrl() + "/tv/top_rated?api_key=" + appConfiguration.getApiKey();
    }
    public String getHorrorTvSeriesUrl() {
        return appConfiguration.getBaseUrl() + "/discover/tv?api_key=" + appConfiguration.getApiKey() + "&with_genres=27" + "&language=en-US";
    }
    public String getRomanceTvSeriesUrl() {
        return appConfiguration.getBaseUrl() + "/discover/tv?api_key=" + appConfiguration.getApiKey() + "&with_genres=10749" + "&language=en-US";
    }
    public String getCrimeTvSeriesUrl() {
        return appConfiguration.getBaseUrl() + "/discover/tv?api_key=" + appConfiguration.getApiKey() + "&with_genres=80"+ "&language=en-US";
    }
    public String getDocumentaryTvSeriesUrl() {
        return appConfiguration.getBaseUrl() + "/discover/tv?api_key=" + appConfiguration.getApiKey() + "&with_genres=99"+ "&language=en-US";
    }
    public String getDramaTvSeriesUrl() {
        return appConfiguration.getBaseUrl() + "/discover/tv?api_key=" + appConfiguration.getApiKey() + "&with_genres=18"+ "&language=en-US";
    }
    public String getAnimationTvSeriesUrl() {
        return appConfiguration.getBaseUrl() + "/discover/tv?api_key=" + appConfiguration.getApiKey() + "&with_genres=16"+ "&language=en-US";
    }
    public String getActionTvSeriesUrl() {
        return appConfiguration.getBaseUrl() + "/discover/tv?api_key=" + appConfiguration.getApiKey() + "&with_genres=28"+ "&language=en-US";
    }
    public String getComedyTvSeriesUrl() {
        return appConfiguration.getBaseUrl() + "/discover/tv?api_key=" + appConfiguration.getApiKey() + "&with_genres=35"+ "&language=en-US";
    }
    public String getNetflixTvSeriesUrl() {
        return appConfiguration.getBaseUrl() + "/discover/tv?api_key=" + appConfiguration.getApiKey() + "&with_networks=213&language=en-US";
    }
    

}
