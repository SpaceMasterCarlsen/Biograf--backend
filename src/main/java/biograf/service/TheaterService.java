package biograf.service;

import biograf.model.Theater;
import biograf.repositories.TheaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {

    private TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    public Optional<Theater> getTheaterById(int theaterId) {
        return theaterRepository.findById(theaterId);
    }

    public Theater saveTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    public void deleteTheater(int theaterId) {
        theaterRepository.deleteById(theaterId);
    }
}
