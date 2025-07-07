import React, { useState, useEffect, useRef } from "react";
import axios from "axios";
import "../styles/Banner.css";
import Trailer from "./Trailer";

const baseImageUrl = "https://image.tmdb.org/t/p/original/";

const Banner = ({ fetchUrl }) => {
  const [movie, setMovie] = useState(null);
  const [selectedMovieId, setSelectedMovieId] = useState(null);
  const isFetched = useRef(false);
  const [showOverview, setShowOverview] = useState(false);

  useEffect(() => {
    async function fetchMoviePoster() {

      try {
        const getMoviePoster = await axios.get(fetchUrl);
        if(!isFetched.current){
        const randomMovie =
          getMoviePoster.data.results[
            Math.floor(Math.random() * getMoviePoster.data.results.length)
          ];
        console.log("Fetched movie:", randomMovie);
        setMovie(randomMovie);
        isFetched.current = true;
        }
      } catch (error) {
        console.error("Error fetching movie poster:", error);
      }
    }
    fetchMoviePoster();
  }, [fetchUrl]);

  if (!movie || !movie.backdrop_path) {
    return <div>Loading...</div>;
  }

  function handlePlayClick() {
    setSelectedMovieId(movie.id);
  }

  function handleOptionClick() {
    console.log("More options clicked");
    setShowOverview(true);
    
  }
  return (
    <header
      className="banner-backdrop-container"
      style={{
        backgroundSize: "cover",
        backgroundImage: `url(
        "${baseImageUrl}${movie?.backdrop_path}"
        )`,
      }}
    >
      <div className="banner-info">
        <h1 className="banner-name">
          {movie?.name || movie?.original_name || movie?.title}
        </h1>
        <div className="banner-description">{movie?.overview}</div>
        <div className="banner-buttons">
          <button
            className="banner-button-play"
            onClick={() => handlePlayClick()}
          >
            Play
          </button>
          <button
            className="banner-button-my-list"
            onClick={() => handleOptionClick()}
          >
            More Options
          </button>
        </div>
      </div>
      <div className="banner-fade-bottom" />
      {selectedMovieId && (
        <Trailer movieId={movie.id} onClose={() => setSelectedMovieId(null)} />
      )}
      {showOverview && (
        <div 
          className="overview-modal" 
          onClick={() => setShowOverview(false)} // Modal dışına tıklandığında kapat
        >
          <div 
            className="modal-content" 
          >
            <h2>Overview</h2>
            <p>{movie.overview}</p>
            <p>Point: {movie.vote_average} / 10</p>
          </div>
        </div>
      )}
    </header>
  );
};

export default Banner;
