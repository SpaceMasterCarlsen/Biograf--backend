package biograf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Entity
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theaterID;
    private String name;
    private int rows;

    @Transient
    private Character[] seatsPerRow = {'A', 'B', 'C', 'D', 'E'};

    //TODO Oskar comments
    // thanks for below comments makes sense when you write your logic below.
    
    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL, orphanRemoval = true) //need this relation to be able to delete a theater and its showtimes
    @JsonIgnore
    private List<ShowTime> showTimes = new ArrayList<>();

    public Theater (String name, int rows){
        this.name = name;
        this.rows = rows;
    }

    public Theater() {}

    public int getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(int theaterID) {
        this.theaterID = theaterID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public Character[] getSeatsPerRow() {
        return seatsPerRow;
    }

    public void setSeatsPerRow(Character[] seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }


    public List<ShowTime> getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(List<ShowTime> showTimes) {
        this.showTimes = showTimes;
    }
}
