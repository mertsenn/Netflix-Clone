import React, { useState, useEffect } from "react";
import { useSearchParams } from "react-router-dom";
import axios from "axios";
import "../styles/SearchPage.css";
import MovieCard from "../components/MovieCard";
import Trailer from "../components/Trailer";

const SearchPage = () => {
  const [searchParams] = useSearchParams();
  const query = searchParams.get("q") || ""; // searchbardan gelen ?q parametresinin getirdiği değeri yakalar
  const [results, setResults] = useState([]);
  const [selectedMovieId, setSelectedMovieId] = useState(null);

  const handleTrailer = (movieId) => {
    setSelectedMovieId(movieId);
  }

  useEffect(() => {
    if (query.trim()) {
      axios
        .get(`http://localhost:8080/api/search/multi?name=${encodeURIComponent(query)}`)
        .then((response) => {
          const movieWithBacdropPath = response.data.filter((movie) => movie.backdrop_path !== null);
          setResults(movieWithBacdropPath);
        })
        .catch((error) => {
          console.error("Error fetching search results:", error);
        });
    } else {
      setResults([]);
    }
  }, [query]);

  return (
    <div className="search-page-container">
      <div className="results-list">
        {results.map((movie) => (
          <div key={movie.id} className="result-movie">
          <MovieCard movie={movie} movieCardTrailer={handleTrailer} />    
          </div>
        ))}
      </div>
      {selectedMovieId && (
        <Trailer movieId={selectedMovieId} onClose={() => setSelectedMovieId(null)}/>
      )}
      
    </div>
  );
};

export default SearchPage;
