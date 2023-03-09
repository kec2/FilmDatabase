package dk.kec.filmdb.repository;

import dk.kec.filmdb.entity.Actor;
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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Alternative 1: Use pure Spring
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {PersistenceApplication.class})

// Alternative 2: Use SpringBootTest
@SpringBootTest
@ContextConfiguration(name = "default")
@ActiveProfiles("test")

// Alternative 3: Use Slice
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ActorRepositoryTest {

    @Autowired
    EntityManager em;
    @Autowired
    ActorRepository actorRepository;

    @BeforeEach
    void init() {
        actorRepository.deleteAll();
        actorRepository.flush();
        em.clear();
    }

    private List<Actor> createThreeActors() {
        Actor arnold = Actor.builder().name("Arnold Schwarzenegger").imgUrl("https://bla.com/img.jpg").externalId("http://imdb.com/name/nm12345678").build();
        Actor dany = Actor.builder().name("Danni Davito").imgUrl("https://bla.com/img3.jpg").externalId("http://imdb.com/name/nm01234567").build();
        Actor olivia = Actor.builder().name("Olivia Newton John").imgUrl("https://bla.com/imgsd.jpg").externalId("http://imdb.com/name/nm78787878").build();

        List<Actor> actors = List.of(dany, arnold, olivia);

        actorRepository.saveAll(actors);
        actorRepository.flush();
        em.clear();

        return actors;
    }

    @Test
    void checkEmptyActorTable() {
        List<Actor> all = actorRepository.findAll();
        assertTrue(all.isEmpty());
    }

    @Test
    void findOneActors() {
        List<Actor> threeActors = createThreeActors();
        Actor oneActor = threeActors.get(0);

        Optional<Actor> one = actorRepository.findById(oneActor.getId());
        assertTrue(one.isPresent());
        assertNotNull(one.get());
        assertEquals(oneActor.getId(), one.get().getId());
    }

    @Test
    void findAllActors() {
        createThreeActors();

        List<Actor> all = actorRepository.findAll();
        assertEquals(3, all.size());
    }

    @Test
    void deleteAnActor() {
        createThreeActors();

        List<Actor> all = actorRepository.findAll();
        assertEquals(3, all.size());

        actorRepository.delete(all.get(0));
        actorRepository.flush();
        em.clear();

        List<Actor> remaining = actorRepository.findAll();
        assertEquals(2, remaining.size());
    }

    @Test
    void deleteAnActorThatDoesNotExist() {
        Actor actor = Actor.builder().name("ImNotHere").build();

        actorRepository.delete(actor);
        actorRepository.flush();
        em.clear();

        List<Actor> remaining = actorRepository.findAll();
        assertEquals(0, remaining.size());
    }

    @Test
    void findAllActorsPaginatedAndSorted() {
        createThreeActors();

        Pageable page = PageRequest.of(0, 1, Sort.sort(Actor.class).by(Actor::getName).ascending());
        Page<Actor> all = actorRepository.findAll(page);

        assertEquals(3, all.getTotalElements());
        assertEquals(3, all.getTotalPages());
        assertEquals("Arnold Schwarzenegger", all.getContent().get(0).getName());
    }

    @Test
    void findActorById() {
        Actor action = Actor.builder().name("John Doe").build();

        actorRepository.save(action);
        actorRepository.flush();
        em.clear();

        Long id = action.getId();
        Optional<Actor> actor = actorRepository.findById(id);
        assertTrue(actor.isPresent());
        assertEquals(action.getId(), actor.get().getId());
        assertEquals(action.getName(), actor.get().getName());
    }

}
