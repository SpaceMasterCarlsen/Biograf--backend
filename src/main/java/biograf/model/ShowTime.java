package biograf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Entity
public class ShowTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showTimeID;

    @ManyToOne
    @JoinColumn(name = "movieFKID", referencedColumnName = "movieID")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theaterFKID", referencedColumnName = "theaterID")
    private Theater theater;

    private LocalDate date;
    private LocalTime startTime;

    @OneToMany(mappedBy = "showTime", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Seat> seats = new ArrayList<>();


    public ShowTime(Movie movie, Theater theater, LocalDate date, LocalTime startTime){
        this.movie = movie;
        this.theater = theater;
        this.date = date;
        this.startTime = startTime;
        seats = populateSeatsList();
    }

    public ShowTime() {}

    public int getShowTimeID() {
        return showTimeID;
    }

    public void setShowTimeID(int showTimeID) {
        this.showTimeID = showTimeID;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    //keeping this here if needing to refactor later
    public List<Seat> populateSeatsList() {
        List<Seat> results = new ArrayList<>();

        if (theater == null) {
            return results;
        }

        int rows = theater.getRows();
        Character[] array = theater.getSeatsPerRow();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < array.length; j++) {
                String seatName = i + "" + array[j];
                Seat obj = new Seat(seatName);
                obj.setShowTime(this); // Associate seat with this ShowTime
                results.add(obj);
            }
        }

        return results;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
