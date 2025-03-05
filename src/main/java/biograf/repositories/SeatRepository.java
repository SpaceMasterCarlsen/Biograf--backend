package biograf.repositories;

import biograf.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    List<Seat> findByShowTime_ShowTimeIDAndIsBookedTrue(int showTimeID);
}
