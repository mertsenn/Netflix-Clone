package com.example.clone.clonedemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfiguration {

    @Value("${api.key}")
    private String apiKey;

    @Value("${api.base.url}")
    private String baseUrl;

    @Value("${api.guest.session}")
    private String guestSession;

    @Value("${api.image.url}")
    private String imageUrl;

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getGuestSession() {
        return guestSession;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }
}
