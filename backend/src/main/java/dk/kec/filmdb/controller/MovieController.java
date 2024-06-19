package dk.kec.filmdb.controller;

import dk.kec.filmdb.entity.Movie;
import dk.kec.filmdb.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        log.info("Rest call to get movies");
        List<Movie> movies = service.getMovies();
        if (movies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long movieId) {
        log.info("Rest call to get movie");

        Movie movie = service.getMovie(movieId);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        log.info("Rest call to create movie");
        Movie movie1 = service.createMovie(movie);
        if (movie1 != null) {
            return new ResponseEntity<>(movie1, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
        log.info("Rest call to update movie");
        Movie movie1 = service.updateMovie(movie);
        if (movie1 != null) {
            return new ResponseEntity<>(movie1, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long movieId) {
        log.info("Rest call to delete movie");
        service.deleteMovie(movieId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{movieTitle}")
    public ResponseEntity<List<Movie>> getMoviesByTitle(@PathVariable String movieTitle) {
        log.info("Rest call to get movies");
        List<Movie> movies = service.getMoviesByTitle(movieTitle);
        if (movies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
}
