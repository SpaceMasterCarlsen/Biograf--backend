package biograf.repositories;

import biograf.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TheaterRepository extends JpaRepository<Theater, Integer> {
}
