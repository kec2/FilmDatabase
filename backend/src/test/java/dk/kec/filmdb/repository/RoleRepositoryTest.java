package dk.kec.filmdb.repository;

import dk.kec.filmdb.entity.Actor;
import dk.kec.filmdb.entity.Movie;
import dk.kec.filmdb.entity.Role;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ContextConfiguration(name = "default")
@ActiveProfiles("test")
public class RoleRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ActorRepository actorRepository;

    @BeforeEach
    void init() {
        roleRepository.deleteAll();
        roleRepository.flush();

        movieRepository.deleteAll();
        movieRepository.flush();

        actorRepository.deleteAll();
        actorRepository.flush();

        em.clear();
    }

    private List<Movie> createMovies() {
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
        Movie hercules = Movie.builder().title("Hercules in New York")
                .country("usa")
                .imgUrl("https://m.media-amazon.com/images/M/MV5BMTg5NzY0MzA2MV5BMl5BanBnXkFtZTYwNDc3NTc2._V1.jpg")
                .externalId("https://www.imdb.com/title/tt0065832/").build();

        List<Movie> movies = List.of(terminator2, grease, cars, hercules);

        movieRepository.saveAll(movies);
        movieRepository.flush();
        em.clear();

        return movies;
    }

    private List<Actor> createActors() {
        Actor arnold = Actor.builder().name("Arnold Schwarzenegger").imgUrl("https://bla.com/img.jpg").externalId("https://imdb.com/name/nm11111111").build();
        Actor linda = Actor.builder().name("Linda Hamilton").imgUrl("https://bla.com/img.jpg").externalId("https://imdb.com/name/nm22222222").build();
        Actor dany = Actor.builder().name("Danni Davito").imgUrl("https://bla.com/img3.jpg").externalId("https://imdb.com/name/nm33333333").build();
        Actor olivia = Actor.builder().name("Olivia Newton John").imgUrl("https://bla.com/imgsd.jpg").externalId("https://imdb.com/name/nm44444444").build();

        List<Actor> actors = List.of(dany, arnold, linda, olivia);

        actorRepository.saveAll(actors);
        actorRepository.flush();
        em.clear();

        return actors;
    }

    private List<Role> createRoles(List<Movie> movies, List<Actor> actors) {
        Role t800 = Role.builder().title("actor").movie(movies.get(0)).actor(actors.get(1)).name("T-800").build();
        Role sarah = Role.builder().title("actor").movie(movies.get(0)).actor(actors.get(2)).name("Sarah Connor").build();
        Role penguin = Role.builder().title("actor").movie(movies.get(1)).actor(actors.get(0)).name("penguin").build();

        Role hercules = Role.builder().title("actor").movie(movies.get(3)).actor(actors.get(1)).name("Hercules").build();

        List<Role> roles = List.of(t800, sarah, penguin, hercules);

        roleRepository.saveAll(roles);
        roleRepository.flush();
        em.clear();

        return roles;
    }

    @Test
    void checkEmptyRoleTable() {
        List<Role> all = roleRepository.findAll();
        assertTrue(all.isEmpty());
    }

    @Test
    void findOneRole() {
        List<Movie> movies = createMovies();
        List<Actor> actors = createActors();


        List<Role> roles = createRoles(movies, actors);
        Role role = roles.get(0);

        Optional<Role> one = roleRepository.findById(role.getId());
        assertTrue(one.isPresent());
        assertNotNull(one.get());
        assertEquals(role.getId(), one.get().getId());
    }

    @Test
    void findRolesByActorId() {
        List<Movie> movies = createMovies();
        List<Actor> actors = createActors();
        List<Role> roles = createRoles(movies, actors);

        Role role = roles.get(3);
        assertEquals("Hercules in New York", role.getMovie().getTitle());

        List<Role> byActorId = roleRepository.findByActor_Id(role.getActor().getId());
        assertNotNull(byActorId);
        assertFalse(byActorId.isEmpty());
        assertEquals(2, byActorId.size());
        assertEquals("Terminator 2", byActorId.get(0).getMovie().getTitle());
        assertEquals("Hercules in New York", byActorId.get(1).getMovie().getTitle());

        assertEquals("Arnold Schwarzenegger", byActorId.get(0).getActor().getName());
        assertEquals(byActorId.get(0).getActor(), byActorId.get(1).getActor());
    }

    @Test
    void findRolesByMovieId() {
        List<Movie> movies = createMovies();
        List<Actor> actors = createActors();
        List<Role> roles = createRoles(movies, actors);

        Role role = roles.get(0);
        assertEquals("Terminator 2", role.getMovie().getTitle());

        List<Role> byMovieId = roleRepository.findByMovie_Id(role.getMovie().getId());
        assertNotNull(byMovieId);
        assertFalse(byMovieId.isEmpty());
        assertEquals(2, byMovieId.size());
        assertEquals("Terminator 2", byMovieId.get(0).getMovie().getTitle());
        assertEquals("Arnold Schwarzenegger", byMovieId.get(0).getActor().getName());

        assertEquals("Terminator 2", byMovieId.get(1).getMovie().getTitle());
        assertEquals("Linda Hamilton", byMovieId.get(1).getActor().getName());
    }

    @Test
    void findAllRoles() {
        List<Movie> movies = createMovies();
        List<Actor> actors = createActors();
        createRoles(movies, actors);

        List<Role> all = roleRepository.findAll();
        assertEquals(4, all.size());
    }

    @Test
    void deleteARole() {
        List<Movie> movies = createMovies();
        List<Actor> actors = createActors();
        createRoles(movies, actors);

        List<Role> all = roleRepository.findAll();
        assertEquals(4, all.size());

        roleRepository.delete(all.get(0));
        roleRepository.flush();
        em.clear();

        List<Role> remaining = roleRepository.findAll();
        assertEquals(3, remaining.size());
    }

    @Test
    void deleteAMovieThatDoesNotExist() {
        Role role = Role.builder().title("ImNotHere").build();

        roleRepository.delete(role);
        roleRepository.flush();
        em.clear();

        List<Role> remaining = roleRepository.findAll();
        assertTrue(remaining.isEmpty());
    }

    @Test
    void findAllRolesPaginatedAndSorted() {
        List<Movie> movies = createMovies();
        List<Actor> actors = createActors();
        createRoles(movies, actors);

        Pageable page = PageRequest.of(0, 1, Sort.sort(Role.class).by(Role::getName).ascending());
        Page<Role> all = roleRepository.findAll(page);

        assertEquals(4, all.getTotalElements());
        assertEquals(4, all.getTotalPages());
        assertEquals("Hercules", all.getContent().get(0).getName());
    }
}
