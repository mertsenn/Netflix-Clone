import React, { useState, useMemo, useRef, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import debounce from "lodash.debounce";
import "../styles/SearchBar.css";

const SearchBar = () => {
  const [searchValue, setSearchValue] = useState("");
  const [hasSearched, setHasSearched] = useState(false);
  const navigate = useNavigate();
  const containerRef = useRef(null);

  // Debounce ile arama sonuçlarına yönlendirme
  const debouncedSearch = useMemo(
    () =>
      debounce((value) => {
        navigate(`/search?q=${encodeURIComponent(value)}`); // search querysine götüren bir navigasyon
      }, 300),
    [navigate]
  );

  const handleChange = (e) => {
    const value = e.target.value;
    setSearchValue(value);
    if (value.trim() !== "") {
      setHasSearched(true);
      debouncedSearch(value);
    }
  };
  

  useEffect(() => {
    const handler = setTimeout(() => {
      if (hasSearched && searchValue.trim() === "") {
        navigate("/");
      }
    }, 500);
    return () => clearTimeout(handler);
  }, [searchValue, hasSearched, navigate]);

  // Arama çubuğu dışına tıklanırsa searchValue'yi temizle
 

  return (
    <div className="search-bar-container" ref={containerRef}>
      <input
        type="text"
        placeholder="Search"
        className="search-input"
        value={searchValue}
        onChange={handleChange}
      />
    </div>
  );
};

export default SearchBar;
