import React from "react";
import tvRequests from "../TvRequests";
import MovieList from "../components/MovieList";
import "../styles/PageLayout.css";
import Banner from "../components/Banner";

const TvSeriesPage = () => {
  return (
    <div className="page-container">
      <div className="banner-container">
        <Banner fetchUrl={tvRequests.fetchNetflixOriginalsTv} />
      </div>
      <div className="tv-series-movie-list-container">
        <MovieList
          title="Popular TV Series"
          fetchUrl={tvRequests.fetchPopularTvSeries}
        />
        <MovieList
          title="Netflix Originals"
          fetchUrl={tvRequests.fetchNetflixOriginalsTv}
        />
        <MovieList
          title="Top Rated TV Series"
          fetchUrl={tvRequests.fetchTopRatedTvSeries}
        />
        <MovieList
          title="Romance TV Series"
          fetchUrl={tvRequests.fetchRomanceTvSeries}
        />
        <MovieList
          title="Crime TV Series"
          fetchUrl={tvRequests.fetchCrimeTvSeries}
        />
        <MovieList
          title="Documentary TV Series"
          fetchUrl={tvRequests.fetchDocumentariTvSeries}
        />
        <MovieList
          title="Drama TV Series"
          fetchUrl={tvRequests.fetchDramaTvSeries}
        />
        <MovieList
          title="Comedy TV Series"
          fetchUrl={tvRequests.fetchComedyTvSeries}
        />
        <MovieList
          title="Animation TV Series"
          fetchUrl={tvRequests.fetchAnimationTvSeries}
        />
      </div>
    </div>
  );
};
export default TvSeriesPage;
