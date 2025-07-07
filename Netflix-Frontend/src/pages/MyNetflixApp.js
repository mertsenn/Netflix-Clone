import React from "react";
import MovieList from "../components/MovieList";
import requests from "../Requests";
import "../styles/PageLayout.css";
import Banner from "../components/Banner";
import tvRequests from "../TvRequests";

const MyNetflixApp = () => {
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
          title="Top Rated Tv Series"
          fetchUrl={tvRequests.fetchTopRatedTvSeries}
        />
        <MovieList
          title="Romance Movies"
          fetchUrl={requests.fetchRomanceMovies}
        />
        <MovieList
          title="Animation TV Series"
          fetchUrl={tvRequests.fetchAnimationTvSeries}
        />
        <MovieList
          title="Documentary TV Series"
          fetchUrl={tvRequests.fetchDocumentariTvSeries}
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

export default MyNetflixApp;
