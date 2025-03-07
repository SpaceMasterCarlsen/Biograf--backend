package biograf.service;

import biograf.model.Seat;
import biograf.model.ShowTime;
import biograf.repositories.SeatRepository;
import biograf.repositories.ShowTimeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;


    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    @Override
    public Optional<Seat> getSeatById(int id) {
        return seatRepository.findById(id);
    }

    @Override
    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public void deleteSeat(int id) {
        seatRepository.deleteById(id);
    }

    @Override
    public void bookSeat(int seatID) {
        Optional<Seat> seat = seatRepository.findById(seatID);
        seat.ifPresent(s -> {
            s.setBooked(true);
            seatRepository.save(s);
        });
    }

    @Override
    public List<Seat> getBookedSeatsForShowTime(int showTimeID) {
        return seatRepository.findAll().stream()
                .filter(seat -> seat.getShowTime().getShowTimeID() == showTimeID && seat.isBooked())
                .toList();
    }

    @Override
    public List<Seat> getAllSeatsForShowTime(int showTimeID) {
        return seatRepository.findByShowTime_ShowTimeID(showTimeID);
    }
}

