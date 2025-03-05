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
    private final ShowTimeRepository showTimeRepository;

    public SeatServiceImpl(SeatRepository seatRepository, ShowTimeRepository showTimeRepository) {
        this.seatRepository = seatRepository;
        this.showTimeRepository = showTimeRepository;
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
    public List<Seat> generateSeatsForShowTime(ShowTime showTime) {
        // Check if seats already exist in the database for this ShowTime
        List<Seat> existingSeats = seatRepository.findByShowTime_ShowTimeIDAndIsBookedTrue(showTime.getShowTimeID());

        if (!existingSeats.isEmpty()) {
            return existingSeats; // Return existing seats if found
        }

        // Row and colum structur
        char[] rows = {'A', 'B', 'C', 'D', 'E'}; // 5 Rows (can also be changed to be infite scaleable)
        int cols = 10; // Can be change to suit needs or be made scalable

        List<Seat> newSeats = new ArrayList<>();

        for (char row : rows) {
            for (int col = 1; col <= cols; col++) {
                String seatName = row + String.valueOf(col); // Example: "A1", "B2"
                Seat seat = new Seat(seatName);
                seat.setShowTime(showTime);
                seat.setBooked(false);
                newSeats.add(seat);
            }
        }

        return seatRepository.saveAll(newSeats); // Persist new seats in DB
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

