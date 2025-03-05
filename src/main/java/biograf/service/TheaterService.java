package biograf.service;

import biograf.model.Theater;
import java.util.List;
import java.util.Optional;

public interface TheaterService {
    List<Theater> getAllTheaters();
    Optional<Theater> getTheaterById(int theaterId);
    Theater saveTheater(Theater theater);
    void deleteTheater(int theaterId);

}
