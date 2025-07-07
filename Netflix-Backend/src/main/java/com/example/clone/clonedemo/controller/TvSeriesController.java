package com.example.clone.clonedemo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clone.clonedemo.response.TvSeriesResponse;
import com.example.clone.clonedemo.service.TvSeriesService;


@RestController
@RequestMapping("api/tv-series")
@CrossOrigin(origins = "http://localhost:3003") // Önyüz portunu burada belirtin

public class TvSeriesController {

    private final TvSeriesService tvSeriesService;

    public TvSeriesController(TvSeriesService tvSeriesService) {
        this.tvSeriesService = tvSeriesService;
    }

    @GetMapping("/all-popular-tv-series")
    public TvSeriesResponse getAllPopularTvSeries() {
        return tvSeriesService.getPopularTvSeries();
    }

    @GetMapping("/all-top-rated-tv-series")
    public TvSeriesResponse getAllTopRatedTvSeries() {
        return tvSeriesService.getTopRatedTvSeries();
    }

    @GetMapping("/all-horror-tv-series")
    public TvSeriesResponse getAllHorrorTvSeries() {
        return tvSeriesService.getHorrorTvSeries();
    }

    @GetMapping("/all-romance-tv-series")
    public TvSeriesResponse getAllRomanceTvSeries() {
        return tvSeriesService.getRomanceTvSeries();
    }

    @GetMapping("/all-crime-tv-series")
    public TvSeriesResponse getAllCrimeTvSeries() {
        return tvSeriesService.getCrimeTvSeries();
    }

    @GetMapping("/all-documentary-tv-series")
    public TvSeriesResponse getAllDocumentaryTvSeries() {
        return tvSeriesService.getDocumentaryTvSeries();
    }

    @GetMapping("/all-drama-tv-series")
    public TvSeriesResponse getAllDramaTvSeries() {
        return tvSeriesService.getDramaTvSeries();
    }

    @GetMapping("/all-animation-tv-series")
    public TvSeriesResponse getAllAnimationTvSeries() {
        return tvSeriesService.getAnimationTvSeries();
    }

    @GetMapping("/all-action-tv-series")
    public TvSeriesResponse getAllActionTvSeries() {
        return tvSeriesService.getActionTvSeries();
    }

    @GetMapping("/all-comedy-tv-series")
    public TvSeriesResponse getAllComedyTvSeries() {
        return tvSeriesService.getComedyTvSeries();
    }

    @GetMapping("/all-netflix-tv-series")
    public TvSeriesResponse getAllNetflixTvSeries() {
        return tvSeriesService.getNetflixTvSeries();
    }


}
