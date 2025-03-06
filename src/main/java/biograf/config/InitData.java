package biograf.config;

import biograf.model.Movie;
import biograf.model.Seat;
import biograf.model.ShowTime;
import biograf.model.Theater;
import biograf.repositories.*;
import biograf.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    MovieRepository movie;

    @Autowired
    ShowTimeRepository showtime;

    @Autowired
    SeatRepository seat;

    @Autowired
    SeatService seatService;

    @Autowired
    TheaterRepository theater;

    @Override
    public void run(String... args) throws Exception {

        // Generating movies
        Movie obj = new Movie("Ringens Herre", 150, "Epic", 0);
        Movie obj2 = new Movie("Star Wars", 100, "Sci-Fi", 15);

        movie.save(obj);
        movie.save(obj2);

        // Generating theaters
        Theater theater1 = new Theater("FirstTheaterTest", 3);
        Theater theater2 = new Theater("SecondTheaterTest", 1);

        theater1 = theater.save(theater1);
        theater2 = theater.save(theater2);

        // Generating showtimes
        LocalDate date = LocalDate.of(2024, 3, 3);
        LocalTime time = LocalTime.of(1, 44);

        ShowTime forestilling1 = new ShowTime(obj, theater2, date, time);
        ShowTime forestilling2 = new ShowTime(obj, theater1, date, time);
        ShowTime forestilling3 = new ShowTime(obj2, theater2, date, time);

        showtime.save(forestilling1);
        showtime.save(forestilling2);
        showtime.save(forestilling3);

        //TODO Oskar comments below 
        // Whyt the hell is there test in our initData ? this should be under unit test ?
        // Is this because it is how you now generate data in out database. Because it have to go throught controller class / service layer.

        // Generating test seats to see if the logic works as intended
        seatService.generateSeatsForShowTime(forestilling1);
        seatService.generateSeatsForShowTime(forestilling2);
        seatService.generateSeatsForShowTime(forestilling3);

        seatService.bookSeat(1);
        seatService.bookSeat(2);
        seatService.bookSeat(3);

        seatService.getBookedSeatsForShowTime(1);
        seatService.getBookedSeatsForShowTime(2);
        seatService.getBookedSeatsForShowTime(3);


    }
}
