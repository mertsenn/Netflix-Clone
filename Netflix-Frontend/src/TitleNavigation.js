import React, { useState } from "react";
import "./styles/TitleNavigation.css";
import { Link } from "react-router-dom";
import netflixLogo from "./assets/images/transparant-netflix-logo.png";
import netflixAvatar from "./assets/images/netflix-avatar.png";
import SearchBar from "./components/SearchBar";
import SearchButtonWhite from "./assets/images/search-button-white.png";

const TitleNavigation = () => {
  const [isSearchBarActive, setIsSearchBarActive] = useState(false);

  const handleSearchBar = () => {
    setIsSearchBarActive(!isSearchBarActive);
  };

  return (
    <nav className="nav-container">
      <div className="nav-left-container">
        <img src={netflixLogo} className="netflix-logo" alt="Netflix Logo" />
        <ul className="nav-links">
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/tv-series"> Tv Series</Link>
          </li>
          <li>
            <Link to="movies"> Movies</Link>
          </li>
          <li>
            <Link to="my-lists">My Lists</Link>
          </li>
        </ul>
      </div>
      <div
        className={`nav-right-container${isSearchBarActive ? "-active" : ""}`}
      >
        <div className="search-bar-container">
          <SearchBar />
        </div>
        <img
          src={SearchButtonWhite}
          alt="white search button"
          onClick={handleSearchBar}
          className="search-button-white"
        />
        <img src={netflixAvatar} alt="Avatar" className="netflix-avatar" />
      </div>
    </nav>
  );
};

export default TitleNavigation;
