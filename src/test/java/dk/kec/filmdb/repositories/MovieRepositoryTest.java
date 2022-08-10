package dk.kec.filmdb.repositories;

import dk.kec.filmdb.entities.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Alternative 1: Use pure Spring
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {PersistenceApplication.class})

// Alternative 2: Use SpringBootTest
@SpringBootTest
@ContextConfiguration(name = "default")

// Alternative 3: Use Slice
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MovieRepositoryTest {

    @Autowired
    EntityManager em;
    @Autowired
    MovieRepository movieRepository;

    @BeforeEach
    void init() {
        movieRepository.deleteAll();
        movieRepository.flush();
        em.clear();
    }

    private List<Movie> createThreeMovies() {
        Movie terminator2 = Movie.builder().title("Terminator 2").subtitle("Judgment Day")
                .country("usa")
                .imgUrl("https://m.media-amazon.com/images/M/MV5BMGU2NzRmZjUtOGUxYS00ZjdjLWEwZWItY2NlM2JhNjkxNTFmXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_.jpg")
                .externalId("https://www.imdb.com/title/tt0103064/").build();
        Movie grease = Movie.builder().title("Grease")
                .country("usa")
                .imgUrl("https://m.media-amazon.com/images/M/MV5BZmUyMDEyOTgtZmUwOS00NTdkLThlNzctNTM1ODQ4M2VhMjdhXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1.jpg")
                .externalId("https://www.imdb.com/title/tt0077631/").build();
        Movie cars = Movie.builder().title("Cars")
                .country("usa")
                .imgUrl("https://m.media-amazon.com/images/M/MV5BMTg5NzY0MzA2MV5BMl5BanBnXkFtZTYwNDc3NTc2._V1.jpg")
                .externalId("https://www.imdb.com/title/tt0317219/").build();

        List<Movie> movies = List.of(terminator2, grease, cars);

        movieRepository.saveAll(movies);
        movieRepository.flush();
        em.clear();

        return movies;
    }

    @Test
    void checkEmptyMovieTable() {
        List<Movie> all = movieRepository.findAll();
        assertTrue(all.isEmpty());
    }

    @Test
    void findOneMovies() {
        List<Movie> threeMovies = createThreeMovies();
        Movie oneMovie = threeMovies.get(0);

        Optional<Movie> one = movieRepository.findById(oneMovie.getId());
        assertTrue(one.isPresent());
        assertNotNull(one.get());
        assertEquals(oneMovie.getId(), one.get().getId());
    }

    @Test
    void findAllMovies() {
        createThreeMovies();

        List<Movie> all = movieRepository.findAll();
        assertEquals(3, all.size());
    }

    @Test
    void deleteAMovie() {
        createThreeMovies();

        List<Movie> all = movieRepository.findAll();
        assertEquals(3, all.size());

        movieRepository.delete(all.get(0));
        movieRepository.flush();
        em.clear();

        List<Movie> remaning = movieRepository.findAll();
        assertEquals(2, remaning.size());
    }

    @Test
    void deleteAMovieThatDoesNotExist() {
        Movie movie = Movie.builder().title("ImNotHere").build();

        movieRepository.delete(movie);
        movieRepository.flush();
        em.clear();

        List<Movie> remaning = movieRepository.findAll();
        assertEquals(0, remaning.size());
    }

    @Test
    void findAllMoviesPaginatedAndSorted() {
        createThreeMovies();

        Pageable page = PageRequest.of(0, 1, Sort.sort(Movie.class).by(Movie::getTitle).ascending());
        Page<Movie> all = movieRepository.findAll(page);

        assertEquals(3, all.getTotalElements());
        assertEquals(3, all.getTotalPages());
        assertEquals("Cars", all.getContent().get(0).getTitle());
    }

    @Test
    void findMovieById() {
        Movie janeDoe = Movie.builder().title("Jane Doe").country("usa").build();

        movieRepository.save(janeDoe);
        movieRepository.flush();
        em.clear();

        Long id = janeDoe.getId();
        Optional<Movie> movie = movieRepository.findById(id);
        assertTrue(movie.isPresent());
        assertEquals(janeDoe.getId(), movie.get().getId());
        assertEquals(janeDoe.getTitle(), movie.get().getTitle());
    }

}
