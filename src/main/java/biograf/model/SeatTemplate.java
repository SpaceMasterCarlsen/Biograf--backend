package biograf.model;


import jakarta.persistence.*;

@Entity
public class SeatTemplate {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rowNR;
    private int seatNR;
    @ManyToOne
    @JoinColumn(name = "theater", referencedColumnName = "name")
    private Theater theater;

    public SeatTemplate(int rowNR, int seatNR){
        this.rowNR = rowNR;
        this.seatNR = seatNR;
    }

    public SeatTemplate() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRowNR() {
        return rowNR;
    }

    public void setRowNR(int rowNR) {
        this.rowNR = rowNR;
    }

    public int getSeatNR() {
        return seatNR;
    }

    public void setSeatNR(int seatNR) {
        this.seatNR = seatNR;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

}
