package biograf.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int rows;
    private int seatsPerRow;


    //TODO this does not make sense and does not work...
    @OneToMany(mappedBy = "theater") //cascade = CascadeType.ALL, orphanRemoval = true
    private List<SeatTemplate> seatTemplateList;

    public Theater (String name, int rows, int seatsPerRow){
        this.name = name;
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
    }

    public Theater() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public void setSeatsPerRow(int seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }

    public List<SeatTemplate> getSeatTemplateList() {
        return seatTemplateList;
    }

    public void setSeatTemplateList(List<SeatTemplate> seatTemplateList) {
        this.seatTemplateList = seatTemplateList;
    }

}
