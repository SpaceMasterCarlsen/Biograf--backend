package biograf.model;


import jakarta.persistence.*;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatID;


    @ManyToOne
    @JoinColumn(name = "showTimeFKID", referencedColumnName = "showTimeID")
    private ShowTime showTime;

    private String seatNameID;
    private boolean isBooked;

    public Seat( String seatNameID) { //ShowTime showTimeID
        //this.showTimeID = showTimeID;
        this.seatNameID = seatNameID;
        this.isBooked = false;
    }


    public Seat(){}

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public void setShowTime(ShowTime showTime) {
        this.showTime = showTime;
    }

    public String getSeatNameID() {
        return seatNameID;
    }

    public void setSeatNameID(String seatNameID) {
        this.seatNameID = seatNameID;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

}
