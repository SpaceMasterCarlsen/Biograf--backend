package biograf.config;

import biograf.model.Movie;
import biograf.model.ShowTime;
import biograf.model.Theater;
import biograf.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    MovieRepository movie;

    @Autowired
    ShowTimeRepository showtime;

    @Autowired
    SeatRepository seat;

    @Autowired
    TheaterRepository theater;

    @Override
    public void run(String... args) throws Exception {



        //TODO this is generating movies - Test: OK
        Movie obj = new Movie("Ringens Herre", 150, "Epic", 0);
        Movie obj2 = new Movie("Star Wars", 100, "Gat", 15);

        movie.save(obj);
        movie.save(obj2);

        /*
        obj = movie.save(obj);
        obj2 = movie.save(obj2);

         */




        //TODO this is Theater generation - Test: OK
        Theater theater1 = new Theater("FirstTheaterTest", 3);
        Theater theater2 = new Theater("SecondTheaterTest", 1);

        theater1 = theater.save(theater1);
        theater2 = theater.save(theater2);

        //TODO this is to generate some ShowTimes - Test: Depending

        LocalDate date = LocalDate.of(2024,3,3);
        LocalTime time = LocalTime.of(1,44);

        ShowTime forestilling1 = new ShowTime(obj,theater2,date,time);


        ShowTime forestilling2 = new ShowTime(obj,theater1,date,time);


        ShowTime forestilling3 = new ShowTime(obj2,theater2,date,time);

        showtime.save(forestilling1);
        showtime.save(forestilling2);
        showtime.save(forestilling3);




    }
}
