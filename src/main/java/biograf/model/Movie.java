package biograf.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieID;
    private String title;
    private int duration;
    private String genre;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ShowTime> showTimes;

    public Movie(String title, int duration, String genre, int ageLimited){
        this.title = title;
        this.duration = duration;
        this.genre = genre;
    }

    public Movie() {}

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int id) {
        this.movieID = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public List<ShowTime> getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(List<ShowTime> showTimes) {
        this.showTimes = showTimes;
    }
}
