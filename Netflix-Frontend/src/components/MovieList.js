import React, { useEffect, useState } from "react";
import "../styles/MovieList.css";
import axios from "axios";
import RigthButtonWhite from "../assets/images/right-button-white.png";
import LeftButtonWhite from "../assets/images/left-button-white.png";
import Trailer from "./Trailer";
import MovieCard from "./MovieCard";

const MovieList = ({ title, fetchUrl }) => {
  const [posters, setPosters] = useState([]);
  const [movieIndex, setMovieIndex] = useState(0); // İlk 5 filmi göstermek için başlangıç aralığı
  const [selectedMovieId, setSelectedMovieId] = useState(null);

  useEffect(() => {
    async function fetchPosters() {
      try {
        const moviesData = await axios.get(fetchUrl);
        setPosters(moviesData.data.results || []); // API sonuçlarına göre güncelleyin
      } catch (error) {
        console.error("Error fetching posters:", error);
        setPosters([]);
      }
    }

    fetchPosters();
  }, [fetchUrl]);

  const cardWidth = 263;
  const cardGap = 15;
  const step = cardWidth + cardGap;
  const visibleCards = 5;

  const scrollRightMovie = () => {
    setMovieIndex((prevIndex) =>
      Math.min(prevIndex + 5, posters.length - visibleCards)
    );
  };

  const scrollLeftMovie = () => {
    setMovieIndex((prevIndex) => Math.max(prevIndex - 5, 0));
  };

  const handleShowTrailer = (movieId) => {
    setSelectedMovieId(movieId);
  };

  return (
    <div className="movie-container">
      <h2 className="movie-container-title">{title}</h2>
      <div
        className="movie-list-container"
        onWheel={(e) => e.preventDefault()}
        onTouchMove={(e) => e.preventDefault()}
      >
        <div className="slider">
          <button
            className="movie-button-left"
            onClick={scrollLeftMovie}
            disabled={movieIndex === 0} // **COMMENT: Sol düğme baştayken devre dışı bırakılır.**
          >
            <img src={LeftButtonWhite} alt="LeftButton" />
          </button>
          <ul
            className="movie-list"
            style={{
              transform: `translateX(-${movieIndex * step}px)`,
              transition: "transform 0.5s ease-in-out",
            }}
          >
            {posters
              .filter((movie) => movie.backdrop_path)
              .map((movie) => (
                <li key={movie.id} className="movie-list-item">
                  {
                    <MovieCard
                      movie={movie}
                      movieCardTrailer={handleShowTrailer}
                    />
                  }
                </li>
              ))}
          </ul>
          <button
            className="movie-button-right"
            onClick={scrollRightMovie}
            disabled={movieIndex >= posters.length - 5} // **COMMENT: Sağ düğme sona ulaştığında devre dışı bırakılır.**
          >
            <img src={RigthButtonWhite} alt="RightButton" />
          </button>
        </div>
      </div>
      {selectedMovieId && (
        <Trailer
          movieId={selectedMovieId}
          onClose={() => setSelectedMovieId(null)}
        />
      )}
    </div>
  );
};

export default MovieList;
