package biograf.controller;

import biograf.model.Movie;
import biograf.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("")
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id){
        return movieService.getMovieById(id)
                .map(movie -> ResponseEntity.ok().body(movie)) //this is http 200 OK
                .orElseGet(()-> ResponseEntity.notFound().build()); //this is http 404 Not Found - might be better to  return a json error message for frontend

    }

    @PostMapping("/create")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        Movie movieToSave = movieService.addMovie(movie);
        return ResponseEntity.ok().body(movieToSave);
    }

    //it is important to find the movie first. if we don't, the responseEntity will return http status 200 ok even if it deleted nothing
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteMovie(@PathVariable int id){
        return movieService.getMovieById(id)
                .map(movie -> {
                    movieService.deleteMovie(id);
                    return ResponseEntity.ok().body(Map.of("message", movie.getTitle() + " was deleted")); //
                })
                .orElseGet(()->ResponseEntity.status(404).body(Map.of("error", "Movie not found!")));
    }
}
