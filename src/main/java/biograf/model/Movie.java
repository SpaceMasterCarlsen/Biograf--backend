package biograf.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int duration;
    private String genre;
    private int ageLimited;


    public Movie(String title, int duration, String genre, int ageLimited){
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.ageLimited = ageLimited;
    }

    public Movie() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAgeLimited() {
        return ageLimited;
    }

    public void setAgeLimited(int ageLimited) {
        this.ageLimited = ageLimited;
    }



}
