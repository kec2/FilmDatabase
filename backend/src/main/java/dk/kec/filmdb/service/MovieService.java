package dk.kec.filmdb.service;

import dk.kec.filmdb.entity.Movie;
import dk.kec.filmdb.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class MovieService {

    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }


    public List<Movie> getMovies() {
        return repository.findAll();
    }

    public Movie getMovie(Long movieId) {
        return repository.findById(movieId).orElse(null);
    }

    public Movie createMovie(Movie movie) {
        if (movie.getId() == null) {
            return repository.saveAndFlush(movie);
        }
        log.error("Don't set id when creating a movie");
        return null;
    }

    public Movie updateMovie(Movie movie) {
        if (repository.existsById(movie.getId())) {
            return repository.saveAndFlush(movie);
        }
        log.error("Can't update an movie that does not exist");
        return null;
    }

    public void deleteMovie(Long movieId) {
        repository.deleteById(movieId);
    }

    public List<Movie> getMoviesDirectedBy(Long movieId) {
        return repository.findByIdAndRoles_Title(movieId, "director");
    }

    public List<Movie> getMoviesByTitle(String title) {
        return Collections.EMPTY_LIST;
    }
}
