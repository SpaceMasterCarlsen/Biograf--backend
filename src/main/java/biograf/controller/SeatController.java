package biograf.controller;

import biograf.model.Movie;
import biograf.model.Seat;
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

    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable int id) {
        return seatService.getSeatById(id)
                .map(seat -> ResponseEntity.ok().body(seat))
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/available-seats/{showTimeID}")
    public ResponseEntity<List<Seat>> getAvailableSeats(@PathVariable int showTimeID) {
        List<Seat> availableSeats = seatService.getAvailableSeatsForShowTime(showTimeID);
        return ResponseEntity.ok(availableSeats);
    }

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
