import React from 'react';
import '../styles/MovieList.css';
import SavedMovieRequests from '../SavedMovieRequests';
import SavedMovieLayout from '../components/SavedMovieLayout';

const MyListPage = () => {
    return (
      <SavedMovieLayout title="My Watchlist" fetchUrl={SavedMovieRequests.fetchSavedMovies}/>
      
    )
}
export default MyListPage;