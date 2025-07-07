import { useState, useEffect } from "react";
import axios from "axios";
import "../styles/MovieGenre.css";

const MovieGenre = ({ movieId }) => {
  const [movieGenres, setMovieGenres] = useState([]);

  useEffect(() => {
    axios
      .get(
        `http://localhost:8080/api/movie/get-movie-genres?movie-id=${movieId}`
      )
      .then((genreResponse) => {
        console.log("genre response:", genreResponse.data);
        setMovieGenres(genreResponse.data);
      })
      .catch((error) => {
        console.error("Error fetching genres:", error);
      });
  }, [movieId]);

  return (
    <div className="movie-genres">
      {movieGenres.length > 0 ? (
        <ul className="genre-list">
          {movieGenres.slice(0, 3).map((genre) => (
            <li key={genre.id}>{genre}</li>
          ))}
        </ul>
      ) : (
        "No genres found"
      )}
    </div>
  );
};

export default MovieGenre;
