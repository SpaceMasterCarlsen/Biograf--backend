package biograf.repositories;

import biograf.model.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShowTimeRepository extends JpaRepository<ShowTime, Integer> {

    List<ShowTime> findByDate(LocalDate date);
}
