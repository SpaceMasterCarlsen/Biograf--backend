package biograf.controller;

import biograf.model.ShowTime;
import biograf.service.ShowTimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
