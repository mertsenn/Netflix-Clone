
const baseUrl = "http://localhost:8080/api"

const requests= {
    fetchPopularMovies: `${baseUrl}/movie/all-popular-movies`,
    fetchNetflixOriginalsTv:`${baseUrl}/all-netflix-originals`,
    fetchTopRatedMovies:`${baseUrl}/movie/all-top-rated-movies`,
    fetchHorrorMovies:`${baseUrl}/movie/all-horror-movies`,
    fetchRomanceMovies:`${baseUrl}/movie/all-romance-movies`,
    fetchCrimeMovies:`${baseUrl}/movie/all-crime-movies`,
    fetchDocumentariMovies:`${baseUrl}/movie/all-documentary-movies`,
    fetchDramaMovies:`${baseUrl}/movie/all-drama-movies`,
    fetchActionMovies:`${baseUrl}/movie/all-action-movies`,
    fetchComedyMovies:`${baseUrl}/movie/all-comedy-movies`,
    fetchAnimationMovies:`${baseUrl}/movie/all-animation-movies`,
}



export default requests;