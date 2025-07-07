import React from "react";
import MovieList from "../components/MovieList";
import requests from "../Requests";
import Banner from "../components/Banner";
import "../styles/PageLayout.css";

const MoviesPage = () => {
  return (
    <div className="page-container">
      <div className="banner-container">
        <Banner fetchUrl={requests.fetchPopularMovies} />
      </div>
      <div className="tv-series-movie-list-container">
        <MovieList
          title="Popular Movies"
          fetchUrl={requests.fetchPopularMovies}
        />
        <MovieList
          title="Top Rated Movies"
          fetchUrl={requests.fetchTopRatedMovies}
        />
        <MovieList
          title="Comedy Movies"
          fetchUrl={requests.fetchComedyMovies}
        />
        <MovieList
          title="Romance Movies"
          fetchUrl={requests.fetchRomanceMovies}
        />
        <MovieList
          title="Horror Movies"
          fetchUrl={requests.fetchHorrorMovies}
        />
        <MovieList title="Crime Movies" fetchUrl={requests.fetchCrimeMovies} />
        <MovieList
          title="Documentaries"
          fetchUrl={requests.fetchDocumentariMovies}
        />
        <MovieList title="Drama Movies" fetchUrl={requests.fetchDramaMovies} />
        <MovieList
          title="Action Movies"
          fetchUrl={requests.fetchActionMovies}
        />
        <MovieList
          title="Animation Movies"
          fetchUrl={requests.fetchAnimationMovies}
        />
      </div>
    </div>
  );
};
export default MoviesPage;
