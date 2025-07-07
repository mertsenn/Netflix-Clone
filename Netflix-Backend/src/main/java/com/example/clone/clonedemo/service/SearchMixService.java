package com.example.clone.clonedemo.service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.clone.clonedemo.config.AppConfiguration;
import com.example.clone.clonedemo.entity.Search;
import com.example.clone.clonedemo.entity.SearchMixObject;

@Service
public class SearchMixService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final AppConfiguration configuration;

    public SearchMixService(AppConfiguration configuration) {
        this.configuration = configuration;
    }

    public List<SearchMixObject> getSearchResults(String name) {
        String searchUrl = configuration.getBaseUrl() + "/search/multi?api_key=" + configuration.getApiKey()
                + "&query=";
        try {
            String encodedName = URLEncoder.encode(name, StandardCharsets.UTF_8.toString());
            Search search = restTemplate.getForObject(searchUrl + encodedName, Search.class);
            if (search != null && search.getResults() != null) {
                List<SearchMixObject> result = new ArrayList<>();
                for (SearchMixObject searchMixObject : search.getResults()) {
                    if (searchMixObject.getMediaType().equalsIgnoreCase("movie")
                            || searchMixObject.getMediaType().equalsIgnoreCase("tv")) {
                        result.add(searchMixObject);
                    }
                }
                return result;
            }
        } catch (final Exception e) {
            System.out.println("Error occurred while fetching search results: " + e.getMessage());
        }
        return List.of();
    }

}
