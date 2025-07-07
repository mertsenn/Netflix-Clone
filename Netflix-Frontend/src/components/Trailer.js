import React, { useState, useEffect } from "react";
import axios from "axios";
import ReactDOM from "react-dom";
import "../styles/Trailer.css";

const Trailer = ({ movieId, onClose }) => {
  const [loadingTrailer, setLoadingTrailer] = useState(false);
  const [movieTrailer, setMovieTrailer] = useState(null);
  const [errorMessage, setErrorMessage] = useState(null);

  useEffect(() => {
    if (movieId) {
      setLoadingTrailer(true);
      axios
        .get(`http://localhost:8080/api/movie/videos?movie-id=${movieId}`)
        .then((response) => {
          console.log("Trailer response: ", response.data);
          setMovieTrailer(response.data);
        })
        .catch((error) => {
          console.error("Error fetching trailer: ", error);
          setErrorMessage("Trailer Not Found");
        })
        .finally(() => {
          setLoadingTrailer(false);
        });
    }
  }, [movieId]);

  useEffect(() => {
    if (!loadingTrailer && !movieTrailer && errorMessage) {
      alert(errorMessage); // Alert popup gösterilir
      onClose(); // Modal kapar
    }
  }, [loadingTrailer, movieTrailer, errorMessage, onClose]);

  const modalContent = (
    <div className="trailer-modal" onClick={onClose}>
      <div className="modal-content" onClick={(e) => e.stopPropagation()}>
        {loadingTrailer ? (
          <p>Loading trailer...</p>
        ) : movieTrailer ? (
          <iframe
            width="100%"
            height="100%"
            src={
              movieTrailer.includes("watch?v=")
                ? movieTrailer.replace("watch?v=", "embed/")
                : movieTrailer
            }
            title="Trailer"
            frameBorder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            allowFullScreen
          ></iframe>
        ) : null}
      </div>
    </div>
  );

  return ReactDOM.createPortal(modalContent, document.body);
};

export default Trailer;
