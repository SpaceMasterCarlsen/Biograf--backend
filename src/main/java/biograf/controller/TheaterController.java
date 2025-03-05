package biograf.controller;

import biograf.model.Theater;
import biograf.service.TheaterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater")
@CrossOrigin("*")
public class TheaterController {

    private TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    //To be tested
    @GetMapping("")
    public ResponseEntity<List<Theater>> getAllTheaters() {
        List<Theater> theaters = theaterService.getAllTheaters();
        return ResponseEntity.ok(theaters);
    }

    //To be tested
    @GetMapping("/{theaterId}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable int theaterId) {
        return theaterService.getTheaterById(theaterId)
                .map(theater -> ResponseEntity.ok().body(theater))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //To be tested
    @PostMapping("/createTheater")
    public ResponseEntity<Theater> saveTheater(@RequestBody Theater theater) {
        Theater savedTheater = theaterService.saveTheater(theater);
        return ResponseEntity.ok(savedTheater);
    }

    //To be tested
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheater(@PathVariable int theaterId) {
        theaterService.deleteTheater(theaterId);
        return ResponseEntity.noContent().build();
    }

}