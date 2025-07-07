import React from "react";
import TitleNavigation from "./TitleNavigation";
import { BrowserRouter as Router,Routes, Route } from "react-router-dom";
import TvSeriesPage from "./pages/TvSeriesPage";
import MoviesPage from "./pages/MoviesPage";
import MyListPage from "./pages/MyListPage";
import MyNetflixApp from "./pages/MyNetflixApp";
import SearchPage from "./pages/SearchPage";
import "./styles/App.css";
import ScrollTop from "./components/ScroolTop";


const App = () => {
  return (
    <div>
      <Router>
      <ScrollTop/>
        <TitleNavigation/>
        <Routes>
          <Route path="/" element={<MyNetflixApp/>} />
          <Route path="/tv-series" element={<TvSeriesPage/>} />
          <Route path="/movies" element={<MoviesPage/>} />
          <Route path="/my-lists" element={<MyListPage/>} />
          <Route path="/search" element={<SearchPage/>} />
        </Routes>
      </Router>
    </div>
  );
};

export default App;
