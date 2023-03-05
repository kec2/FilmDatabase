package dk.kec.filmdb.repository;

import dk.kec.filmdb.entity.Genre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;

import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
public class GenreRepositoryTest {

    @Autowired
    EntityManager em;
    @Autowired
    GenreRepository genreRepository;

    @BeforeEach
    void init() {
        genreRepository.deleteAll();
        genreRepository.flush();
        em.clear();
    }

    private List<Genre> createThreeGenres() {
        Genre action = Genre.builder().name("Action").build();
        Genre drama = Genre.builder().name("Drama").build();
        Genre horror = Genre.builder().name("Horror").build();

        List<Genre> genres = List.of(drama, action, horror);

        genreRepository.saveAll(genres);
        genreRepository.flush();
        em.clear();

        return genres;
    }

    @Test
    void checkEmptyGenreTable() {
        List<Genre> all = genreRepository.findAll();
        assertTrue(all.isEmpty());
    }

    @Test
    void findOneGenres() {
        List<Genre> threeGenres = createThreeGenres();
        Genre oneGenre = threeGenres.get(0);

        Optional<Genre> one = genreRepository.findById(oneGenre.getId());
        assertTrue(one.isPresent());
        assertNotNull(one.get());
        assertEquals(oneGenre.getId(), one.get().getId());
    }

    @Test
    void findAllGenres() {
        createThreeGenres();

        List<Genre> all = genreRepository.findAll();
        assertEquals(3, all.size());
    }

    @Test
    void createGenreThatAlreadyExists() {
        Genre action = Genre.builder().name("Action").build();
        genreRepository.save(action);
        genreRepository.flush();
        em.clear();

        assertThrows(DataIntegrityViolationException.class, () -> {
            Genre action2 = Genre.builder().name("Action").build();
            genreRepository.save(action2);
        });

        List<Genre> all = genreRepository.findAll();
        assertEquals(1, all.size());
    }


    @Test
    void deleteAGenre() {
        createThreeGenres();

        List<Genre> all = genreRepository.findAll();
        assertEquals(3, all.size());

        genreRepository.delete(all.get(0));
        genreRepository.flush();
        em.clear();

        List<Genre> remaning = genreRepository.findAll();
        assertEquals(2, remaning.size());
    }

    @Test
    void deleteAGenreThatDoesNotExist() {
        Genre genre = Genre.builder().name("ImNotHere").build();

        genreRepository.delete(genre);
        genreRepository.flush();
        em.clear();

        List<Genre> remaning = genreRepository.findAll();
        assertEquals(0, remaning.size());
    }

    @Test
    void findAllGenresPaginatedAndSorted() {
        createThreeGenres();

        Pageable page = PageRequest.of(0, 1, Sort.sort(Genre.class).by(Genre::getName).ascending());
        Page<Genre> all = genreRepository.findAll(page);

        assertEquals(3, all.getTotalElements());
        assertEquals(3, all.getTotalPages());
        assertEquals("Action", all.getContent().get(0).getName());
    }

    @Test
    void findGenreById() {
        Genre action = Genre.builder().name("Action").build();

        genreRepository.save(action);
        genreRepository.flush();
        em.clear();

        Long id = action.getId();
        Optional<Genre> genre = genreRepository.findById(id);
        assertTrue(genre.isPresent());
        assertEquals(action.getId(), genre.get().getId());
        assertEquals(action.getName(), genre.get().getName());
    }

}
