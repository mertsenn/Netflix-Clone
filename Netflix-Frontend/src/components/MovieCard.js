import RatingButton from "./RatingButton";
import MovieGenre from "./MovieGenre";
import { useState, useEffect } from "react";
import axios from "axios";
import AddButtonWhite from "../assets/images/add-button-white.png";
import PlayButtonWhite from "../assets/images/play-button-white.png";
import CheckButtonWhite from "../assets/images/check-button-white.png";
import SavedMovieRequests from "../SavedMovieRequests";
import RatedMoviesOrTvSeriesRequests from "../RatedMoviesOrTvSeriesRequests";
import SavedMovie from "../entity/SavedMovie";

const baseImageUrl = "https://image.tmdb.org/t/p/original/";

const MovieCard = ({ movie, movieCardTrailer, refreshSavedMovies }) => {
  const [savedMovies, setSavedMovies] = useState([]);
  const [ratedMovies, setRatedMovies] = useState([]);

  const uptadeRating = () => {
    fetchSavedMovies();
    fetchRatedMovies();
  };

  // Kaydedilmiş filmleri çek
  const fetchSavedMovies = () => {
    axios
      .get(`${SavedMovieRequests.fetchSavedMovies}?timestamp=${Date.now()}`)
      .then((response) => setSavedMovies(response.data))
      .catch((error) => console.error("Error fetching saved movies:", error));
  };

  // Oylanmış filmleri çek
  const fetchRatedMovies = () => {
    axios
      .get(
        `${
          RatedMoviesOrTvSeriesRequests.fetchRatedMoviesOrTvSeries
        }?timestamp=${Date.now()}`
      )
      .then((response) => setRatedMovies(response.data))
      .catch((error) => console.error("Error fetching rated movies:", error));
  };

  useEffect(() => {
    fetchSavedMovies();
    fetchRatedMovies();
  }, []); // Bileşen yüklendiğinde her iki veriyi de çekiyoruz

  // Filmin kaydedilip kaydedilmediğini kontrol et
  const isMovieSaved = (movie) => {
    return savedMovies.some((savedMovie) => savedMovie.id === movie.id);
  };

  const getUserRating = (movie) => {
    // kaydedilmiş ve oylanmış kayıtlar
    const savedMovie = savedMovies.find((sm) => sm.id === movie.id);
    const ratedMovie = ratedMovies.find((rm) => rm.movieId === movie.id);

    // Eğer film kaydedilmemişse, sadece ratedMovies'teki değeri döndür.
    if (!savedMovie) {
      return ratedMovie ? ratedMovie.userRating : null;
    } else {
      // Film kaydedilmişse:
      // Eğer kaydedilmiş kayıtta user_rate değeri varsa, onu döndür.
      if (savedMovie.user_rate !== 0) {
        return savedMovie.user_rate;
      }
      // Eğer kaydedilmiş ama user_rate değeri 0 ise (yani oylanmamışsa),
      // ilk oylama yapılmışsa ratedMovies'teki değeri döndür.
      return ratedMovie ? ratedMovie.userRating : null;
    }
  };

  const converToOneDecimal = (number) => {
    return number.toFixed(1);
  };

  const removeWatchList = (movie) => {
    const savedMovieEntity = new SavedMovie(
      movie.id,
      movie.title,
      movie.isAdult,
      movie.backdrop_path,
      movie.overview,
      movie.video,
      movie.vote_average,
      movie.user_rating
    );

    axios
      .delete("http://localhost:8080/api/post/delete-movie", {
        data: savedMovieEntity,
      })
      .then((response) => {
        console.log("Deleted successfully:", response.data);
        fetchSavedMovies(); // Listeleri güncelle
        refreshSavedMovies();
      })
      .catch((error) => {
        console.error("Error deleting movie:", error);
      });
  };

  const addWatchList = (movie) => {
    const savedMovieEntity = new SavedMovie(
      movie.id,
      movie.title,
      movie.isAdult,
      movie.backdrop_path,
      movie.overview,
      movie.video,
      movie.vote_average,
      movie.user_rating
    );

    axios
      .post("http://localhost:8080/api/post/save-movie", savedMovieEntity)
      .then((response) => {
        console.log("Saved successfully:", response.data);
        fetchSavedMovies(); // Listeleri güncelle
      })
      .catch((error) => {
        console.error("Error saving movie:", error);
      });
  };

  const handleShowTrailer = (movieId) => {
    movieCardTrailer(movieId);
  };

  return (
    <div className="movie-card">
      <img
        src={`${baseImageUrl}${movie.backdrop_path}`}
        alt={movie.title}
        className="movie-poster"
      />
      <div className="movie-info">
        <div className="movie-info-elements">
          <div className="movie-info-icons">
            <button onClick={() => handleShowTrailer(movie.id)}>
              <img src={PlayButtonWhite} alt="Play" />
            </button>

            {isMovieSaved(movie) ? (
              <button
                className="watch-list-button"
                onClick={() => {
                  removeWatchList(movie);
                }}
              >
                <img src={CheckButtonWhite} alt="Already Added - Remove" />
              </button>
            ) : (
              <button
                className="watch-list-button"
                onClick={() => {
                  addWatchList(movie);
                }}
              >
                <img src={AddButtonWhite} alt="Add to Watchlist" />
              </button>
            )}
            <RatingButton movieId={movie.id} updateRating={uptadeRating} />
          </div>
          <MovieGenre movieId={movie.id} />
          <p>Vote: {converToOneDecimal(movie.vote_average)}</p>
          {getUserRating(movie) !== null &&
            getUserRating(movie) !== undefined && (
              <p>Your Rating: {getUserRating(movie)}</p>
            )}
        </div>
      </div>
    </div>
  );
};

export default MovieCard;
