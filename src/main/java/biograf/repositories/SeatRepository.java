package biograf.repositories;

import biograf.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {

    List<Seat> findByShowTime_ShowTimeID(int showTimeID);

    List<Seat> findByShowTime_ShowTimeIDAndIsBookedTrue(int showTimeID);

    List<Seat> findByShowTime_ShowTimeIDAndIsBookedFalse(int showTimeID);
}
