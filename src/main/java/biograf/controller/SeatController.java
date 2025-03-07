package biograf.controller;

import biograf.model.Seat;
import biograf.model.ShowTime;
import biograf.service.SeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seat")
@CrossOrigin("*")
public class SeatController {

    private SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("")
    public ResponseEntity<List<Seat>> getAllSeats() {
        List<Seat> seats = seatService.getAllSeats();
        return ResponseEntity.ok(seats);
    }

    @GetMapping("/{seatID}")
    public ResponseEntity<Seat> getSeatById(@PathVariable int seatID) {
        return seatService.getSeatById(seatID)
                .map(seat -> ResponseEntity.ok().body(seat))
                .orElse(ResponseEntity.notFound().build());
    }



    //TO be tested
    @PostMapping("/bookseat/{seatID}")
    public ResponseEntity<Void> bookSeat(@PathVariable int seatID) {
        seatService.bookSeat(seatID);
        return ResponseEntity.ok().build();
    }

    //TO be tested
    @GetMapping("/bookedseats/{showTimeID}")
    public ResponseEntity<List<Seat>> getBookedSeats(@PathVariable int showTimeID) {
        List<Seat> bookedSeats = seatService.getBookedSeatsForShowTime(showTimeID);
        return ResponseEntity.ok(bookedSeats);
    }
    @GetMapping("/allSeats/{showTimeID}")
    public ResponseEntity<List<Seat>> getAllSeats(@PathVariable int showTimeID) {
        List<Seat> allSeats = seatService.getAllSeatsForShowTime(showTimeID);
        return ResponseEntity.ok(allSeats);
    }

}
