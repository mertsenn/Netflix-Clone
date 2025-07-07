class SavedMovie {
    constructor(id,title,adult,backdrop_path, overview, video, vote_average, user_rating) {
    this.id = id;
    this.title=title;
    this.adult=adult;
    this.backdrop_path=backdrop_path;
    this.overview=overview;
    this.video = video;  
    this.vote_average = vote_average;
    this.user_rating = user_rating;
    }
  }
  
  export default SavedMovie;
  