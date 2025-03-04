package biograf.model;


import jakarta.persistence.*;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "screening", referencedColumnName = "id")
    private Screening screening;
    @ManyToOne
    @JoinColumn(name = "seatTemplate", referencedColumnName = "id")
    private SeatTemplate seatTemplate;
    private boolean isBooked;

    public Seat(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public SeatTemplate getSeatTemplate() {
        return seatTemplate;
    }

    public void setSeatTemplate(SeatTemplate seatTemplate) {
        this.seatTemplate = seatTemplate;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

}
