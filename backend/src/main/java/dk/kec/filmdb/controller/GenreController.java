package dk.kec.filmdb.controller;

import dk.kec.filmdb.entity.Genre;
import dk.kec.filmdb.service.GenreService;
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
@RequestMapping("/genre")
public class GenreController {

    private final GenreService service;

    public GenreController(GenreService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Genre>> getGenres() {
        log.info("Rest call to get genres");
        List<Genre> genres = service.getGenres();
        if (genres.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(genres, HttpStatus.OK);
    }

    @GetMapping("/{genreId}")
    public ResponseEntity<Genre> getGenre(@PathVariable Long genreId) {
        log.info("Rest call to get genre");

        Genre genre = service.getGenre(genreId);
        if (genre == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(genre, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
        log.info("Rest call to create genre");
        Genre genre1 = service.createGenre(genre);
        if (genre1 != null) {
            return new ResponseEntity<>(genre1, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<Genre> updateGenre(@RequestBody Genre genre) {
        log.info("Rest call to update genre");
        Genre genre1 = service.updateGenre(genre);
        if (genre1 != null) {
            return new ResponseEntity<>(genre1, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{genreId}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long genreId) {
        log.info("Rest call to delete genre");
        service.deleteGenre(genreId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}