const baseUrl = "http://localhost:8080/api"


const tvRequests = {
    fetchPopularTvSeries: `${baseUrl}/tv-series/all-popular-tv-series`,
    fetchNetflixOriginalsTv: `${baseUrl}/tv-series/all-netflix-tv-series`,
    fetchTopRatedTvSeries: `${baseUrl}/tv-series/all-top-rated-tv-series`,
    fetchHorrorTvSeries: `${baseUrl}/tv-series/all-horror-tv-series`, //çalışmıyor
    fetchRomanceTvSeries: `${baseUrl}/tv-series/all-romance-tv-series`, 
    fetchCrimeTvSeries: `${baseUrl}/tv-series/all-crime-tv-series`, 
    fetchDocumentariTvSeries: `${baseUrl}/tv-series/all-documentary-tv-series`,
     fetchDramaTvSeries: `${baseUrl}/tv-series/all-drama-tv-series`,
     fetchActionTvSeries: `${baseUrl}/tv-series/all-action-tv-series`, // çalışmıyor
    fetchComedyTvSeries: `${baseUrl}/tv-series/all-comedy-tv-series`,
    fetchAnimationTvSeries: `${baseUrl}/tv-series/all-animation-tv-series`,
}

export default tvRequests;