package biograf.service;


import biograf.model.Seat;
import biograf.repositories.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    private SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Optional<Seat> getSeatById(int id) {
        return seatRepository.findById(id);
    }

    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public void deleteSeat(int id) {
        seatRepository.deleteById(id);
    }

    public List<Seat> getAvailableSeatsForShowTime(int showTimeID) {
        return seatRepository.findByShowTime_ShowTimeIDAndIsBookedFalse(showTimeID);
    }

    public List<Seat> getBookedSeatsForShowTime(int showTimeID) {
        return seatRepository.findByShowTime_ShowTimeIDAndIsBookedTrue(showTimeID);
    }
    public List<Seat> getAllSeatsForShowTime(int showTimeID) {
        return seatRepository.findByShowTime_ShowTimeID(showTimeID);
    }
}
