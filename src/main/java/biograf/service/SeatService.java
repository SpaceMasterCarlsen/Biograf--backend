package biograf.service;

import biograf.model.Seat;
import biograf.model.ShowTime;

import java.util.List;
import java.util.Optional;

public interface SeatService {
    List<Seat> getAllSeats();
    Optional<Seat> getSeatById(int id);
    Seat saveSeat(Seat seat);
    void deleteSeat(int id);


    void bookSeat(int seatID);
    void unBookSeat(int seatID);
    List<Seat> getBookedSeatsForShowTime(int showTimeID);
    List<Seat> getAllSeatsForShowTime(int showTimeID);

}