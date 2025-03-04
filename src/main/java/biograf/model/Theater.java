package biograf.model;

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


    public Theater (String name, int rows){
        this.name = name;
        this.rows = rows;
    }

    public Theater() {}

    public int getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(int id) {
        this.theaterID = id;
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



}
