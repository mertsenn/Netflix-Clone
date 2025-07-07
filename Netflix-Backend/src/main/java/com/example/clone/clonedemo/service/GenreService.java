package com.example.clone.clonedemo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.clone.clonedemo.entity.Genres;
import com.example.clone.clonedemo.response.GenreResponse;

@Service
public class GenreService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiKey = "d9f6e8a449b87a71597b6c44ce1e501f";

    /*
     * doğru end pointe git,
     * ordan genre listini al
     * diğer tarafdan gelen id ye göre genre listesinden genre adını al
     */
    public List<String> getMovieGenres(List<Integer> genreIds) {
        String movieGenreUrl = "https://api.themoviedb.org/3/genre/movie/list?api_key=" + apiKey;
        GenreResponse genreResponse = restTemplate.getForObject(movieGenreUrl, GenreResponse.class);
    
        if (genreResponse != null && genreResponse.getGenres() != null) {
            return genreResponse.getGenres().stream()
                    .filter(genre -> genreIds.contains(genre.getId())) // ID'lere göre filtrele
                    .map(Genres::getName) // Tür ismini al
                    .collect(Collectors.toList());
        }
        return List.of(); // Eğer tür bulunmazsa boş liste döndür
    }
    

}
