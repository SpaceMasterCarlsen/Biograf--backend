package biograf.service;

import biograf.model.Theater;
import biograf.repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository;

    @Autowired
    public TheaterServiceImpl(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    @Override
    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    @Override
    public Optional<Theater> getTheaterById(int theaterId) {
        return theaterRepository.findById(theaterId);
    }

    @Override
    public Theater saveTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    @Override
    public void deleteTheater(int theaterId) {
        theaterRepository.deleteById(theaterId);
    }
}
