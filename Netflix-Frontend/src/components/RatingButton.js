import { useState, useRef, useEffect } from "react";
import axios from "axios";
import "../styles/RatingButton.css";
import LikeButtonWhite from "../assets/images/like-button-white.png";

const RatingButton = ({ movieId, updateRating }) => {
  const rateNumbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
  const containerRef = useRef(null);
  const [showRating, setShowRating] = useState(false);
  const [rate, setRate] = useState(null);

  const rateMovie = (rateNumber) => {
    axios
      .post(
        `http://localhost:8080/api/post/rate-movie?movie-id=${movieId}&rating=${rateNumber}`
      )
      .then((response) => {
        console.log("Rating response:", response.data);
        setShowRating(false);
        updateRating();
      })
      .catch((error) => {
        console.error("Error rating movie:", error);
      });
  };

  useEffect(() => {
    const handleClickOutside = (event) => {
      if (
        containerRef.current &&
        !containerRef.current.contains(event.target)
      ) {
        setShowRating(false);
      }
    };
    document.addEventListener("mousedown", handleClickOutside);
    return () => {
      document.removeEventListener("mousedown", handleClickOutside);
    };
  });

  return (
    <div className="rating-button-container" ref={containerRef}>
      <button
        className="rating-button"
        onClick={() => setShowRating((prev) => !prev)}
      >
        <img src={LikeButtonWhite} alt="RatingButton" />
      </button>
      {showRating && (
        <div className="rating-options">
          {rateNumbers.map((rateNumber) => (
            <div
              key={rateNumber}
              className="rating-numbers"
              onClick={() => rateMovie(rateNumber)}
            >
              {rateNumber}
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default RatingButton;
