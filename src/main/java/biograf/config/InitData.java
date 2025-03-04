package biograf.config;

import biograf.model.Movie;
import biograf.model.Screening;
import biograf.model.SeatTemplate;
import biograf.model.Theater;
import biograf.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.service.invoker.HttpExchangeAdapter;

import java.lang.reflect.Array;
import java.util.Arrays;

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

        //TODO this is generating movies - Test: OK
        Movie obj = new Movie("Ringens Herre", 150, "Epic", 0);
        Movie obj2 = new Movie("Star Wars", 100, "Gat", 15);

        movie.saveAll(Arrays.asList(obj,obj2));

        //TODO this is seatTemplate - Test: OK - No theater!
        SeatTemplate seatOBJ = new SeatTemplate(3,5);



        //TODO this is Theater generation - Test: Depending
        Theater theater1 = new Theater("FirstTheaterTest", 3,5);
        //theater1.setSeatTemplateList(Arrays.asList(seatOBJ));

        //seatOBJ.setTheater(theater1);
        seatTemplateRepository.save(seatOBJ);
        theater.save(theater1);








    }
}
