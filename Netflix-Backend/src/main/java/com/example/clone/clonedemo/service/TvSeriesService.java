package com.example.clone.clonedemo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.clone.clonedemo.config.MovieAppEndPoints;
import com.example.clone.clonedemo.response.TvSeriesResponse;

@Service
public class TvSeriesService {
 
    private final RestTemplate restTemplate = new RestTemplate();
    private final MovieAppEndPoints movieAppEndPoints;

    public TvSeriesService(MovieAppEndPoints movieAppEndPoints) {
        this.movieAppEndPoints = movieAppEndPoints;
    }

    public TvSeriesResponse getPopularTvSeries(){
        TvSeriesResponse tvResponse = restTemplate.getForObject(movieAppEndPoints.getPopularTvSeriesUrl(), TvSeriesResponse.class);
        if(tvResponse != null && tvResponse.getTvSeries() !=null){
            return tvResponse;
        }
        return null;
    }

    public TvSeriesResponse getTopRatedTvSeries(){
        TvSeriesResponse tvSeries = restTemplate.getForObject(movieAppEndPoints.getTopRatedTvSeriesUrl(),TvSeriesResponse.class );
        if(tvSeries != null && tvSeries.getTvSeries() !=null){
            return tvSeries;
        }
        return null;
    }

    public TvSeriesResponse getHorrorTvSeries(){
        TvSeriesResponse tvSeries = restTemplate.getForObject(movieAppEndPoints.getHorrorTvSeriesUrl(),TvSeriesResponse.class );
        if(tvSeries != null && tvSeries.getTvSeries() !=null){
            return tvSeries;
        }
        return null;
    }

    public TvSeriesResponse getRomanceTvSeries(){
        TvSeriesResponse tvSeries = restTemplate.getForObject(movieAppEndPoints.getRomanceTvSeriesUrl(),TvSeriesResponse.class );
        if(tvSeries != null && tvSeries.getTvSeries() !=null){
            return tvSeries;
        }
        return null;
    }

    public TvSeriesResponse getCrimeTvSeries(){
        TvSeriesResponse tvSeries = restTemplate.getForObject(movieAppEndPoints.getCrimeTvSeriesUrl(),TvSeriesResponse.class );
        if(tvSeries != null && tvSeries.getTvSeries() !=null){
            return tvSeries;
        }
        return null;
    }

    public TvSeriesResponse getDocumentaryTvSeries(){
        TvSeriesResponse tvSeries = restTemplate.getForObject(movieAppEndPoints.getDocumentaryTvSeriesUrl(),TvSeriesResponse.class );
        if(tvSeries != null && tvSeries.getTvSeries() !=null){
            return tvSeries;
        }
        return null;
    }

    public TvSeriesResponse getDramaTvSeries(){
        TvSeriesResponse tvSeries = restTemplate.getForObject(movieAppEndPoints.getDramaTvSeriesUrl(),TvSeriesResponse.class );
        if(tvSeries != null && tvSeries.getTvSeries() !=null){
            return tvSeries;
        }
        return null;
    }

    public TvSeriesResponse getAnimationTvSeries(){
        TvSeriesResponse tvSeries = restTemplate.getForObject(movieAppEndPoints.getAnimationTvSeriesUrl(),TvSeriesResponse.class );
        if(tvSeries != null && tvSeries.getTvSeries() !=null){
            return tvSeries;
        }
        return null;
    }

    public TvSeriesResponse getActionTvSeries(){
        TvSeriesResponse tvSeries = restTemplate.getForObject(movieAppEndPoints.getActionTvSeriesUrl(),TvSeriesResponse.class );
        if(tvSeries != null && tvSeries.getTvSeries() !=null){
            return tvSeries;
        }
        return null;
    }

    public TvSeriesResponse getComedyTvSeries(){
        TvSeriesResponse tvSeries = restTemplate.getForObject(movieAppEndPoints.getComedyTvSeriesUrl(),TvSeriesResponse.class );
        if(tvSeries != null && tvSeries.getTvSeries() !=null){
            return tvSeries;
        }
        return null;
    }

    public TvSeriesResponse getNetflixTvSeries(){
        TvSeriesResponse tvSeries = restTemplate.getForObject(movieAppEndPoints.getNetflixTvSeriesUrl(),TvSeriesResponse.class );
        if(tvSeries != null && tvSeries.getTvSeries() !=null){
            return tvSeries;
        }
        return null;
    }

    



}
