import React, { useEffect, useState } from "react";
import axios from "axios";
import "../styles/SavedMovieLayout.css";
import MovieCard from "./MovieCard";
import Trailer from "./Trailer";

const SavedMovieLayout = ({ title, fetchUrl }) => {
  const [savedMovies, setSavedMovies] = useState(null);
  const [selectedMovieId, setSelectedMovieId] = useState(null);

  const fetchSavedMovies = async () => {
    try {
      const response = await axios.get(fetchUrl);
      setSavedMovies(response.data);
      console.log("Saved Movies:", response.data);
    } catch (e) {
      console.error("Error fetching saved movies:", e);
    }
  };

  // Sayfa yüklendiğinde savedMovies listesini çek
  useEffect(() => {
    fetchSavedMovies();
  }, [fetchUrl]);

  return (
    <div className="saved-movie-container">
      <div className="saved-movie-item">
        {savedMovies?.map((movies) => (
          <div key={movies.id} className="result-movie">
            <MovieCard
              movie={movies}
              movieCardTrailer={setSelectedMovieId} 
              refreshSavedMovies={fetchSavedMovies} 
            
            />
          </div>
        ))}
        <div>
          {selectedMovieId && (
            <Trailer
              movieId={selectedMovieId}
              onClose={() => setSelectedMovieId(null)}
            />
          )}
        </div>
      </div>
    </div>
  );
};

export default SavedMovieLayout;
