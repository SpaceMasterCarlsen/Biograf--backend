package biograf.controller;

import biograf.model.Seat;
import biograf.model.ShowTime;
import biograf.service.MovieService;
import biograf.service.SeatService;
import biograf.service.ShowTimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/showtime")
@CrossOrigin("*")
public class ShowTimeController {

    private ShowTimeService showTimeService;


    public ShowTimeController(ShowTimeService showTimeService) {
        this.showTimeService = showTimeService;

    }

    @GetMapping("")
    public ResponseEntity<List<ShowTime>> getAllShowTimes() {
        List<ShowTime> showTimes = showTimeService.getAllShowTime();
        return ResponseEntity.ok(showTimes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowTime> getShowTimeById(@PathVariable int id) {
        return showTimeService.getShowTimeById(id)
                .map(showTime -> ResponseEntity.ok().body(showTime))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<ShowTime>> getShowTimesByDate(@PathVariable LocalDate date) {
        List<ShowTime> showTimes = showTimeService.findByDate(date);
        return ResponseEntity.ok(showTimes);
    }



    @PostMapping("/create")
    public ResponseEntity<ShowTime> createShowTime(@RequestBody ShowTime showTime) {
        ShowTime savedShowTime = showTimeService.saveShowTime(showTime);
        return ResponseEntity.ok(savedShowTime);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteShowTime(@PathVariable int id) {
        return showTimeService.getShowTimeById(id)
                .map(showTime -> {
                    showTimeService.deleteShowTime(id);
                    return ResponseEntity.ok().body(Map.of("message", "Showtime on date: " + showTime.getDate().toString() + " deleted"));
                })
                .orElseGet(()-> ResponseEntity.status(404).body(Map.of("error", "Showtime not found")));
    }




}
