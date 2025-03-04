package biograf.repositories;

import biograf.model.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowTimeRepository extends JpaRepository<ShowTime, Integer> {
}
