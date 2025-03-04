package biograf.model;

import jakarta.persistence.*;
import org.springframework.jmx.export.annotation.ManagedAttribute;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Entity
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "movie", referencedColumnName = "title")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "theater", referencedColumnName = "id")
    private Theater theater;
    private LocalDate date;
    private LocalTime startTime;

    //TODO there is some logic regarding a list that is not working.

    @OneToMany(mappedBy = "screening", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seat> seatList;

    public Screening(Movie movie, Theater theater, LocalDate date, LocalTime startTime){
        this.movie = movie;
        this.theater = theater;
        this.date = date;
        this.startTime = startTime;
    }

    public Screening() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }


}
