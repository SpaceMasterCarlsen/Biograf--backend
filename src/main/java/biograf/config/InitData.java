package biograf.config;

import biograf.model.Movie;
import biograf.model.Screening;
import biograf.model.SeatTemplate;
import biograf.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    MovieRepository movie;

    @Autowired
    ScreeningRepository Screening;

    @Autowired
    SeatRepository seat;

    @Autowired
    SeatTemplateRepository seatTemplateRepository;

    @Autowired
    TheaterRepository theater;

    @Override
    public void run(String... args) throws Exception {

        Movie obj = new Movie("Ringens Herre", 150, "Epic", 0);


    }
}
