package dk.kec.filmdb.repositories;

import dk.kec.filmdb.entities.MediaType;
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
public class MediaTypeRepositoryTest {

    @Autowired
    EntityManager em;
    @Autowired
    MediaTypeRepository mediaTypeRepository;

    @BeforeEach
    void init() {
        mediaTypeRepository.deleteAll();
        mediaTypeRepository.flush();
        em.clear();
    }

    private List<MediaType> createThreeMediaTypes() {
        MediaType dvd = MediaType.builder().name("Dvd").build();
        MediaType vhs = MediaType.builder().name("VHS").build();
        MediaType bluray = MediaType.builder().name("Blu-ray").build();

        List<MediaType> mediaTypes = List.of(vhs, dvd, bluray);

        mediaTypeRepository.saveAll(mediaTypes);
        mediaTypeRepository.flush();
        em.clear();

        return mediaTypes;
    }

    @Test
    void checkEmptyMediaTypeTable() {
        List<MediaType> all = mediaTypeRepository.findAll();
        assertTrue(all.isEmpty());
    }

    @Test
    void findOneMediaType() {
        List<MediaType> threeMediaTypes = createThreeMediaTypes();
        MediaType oneMediaType = threeMediaTypes.get(0);

        Optional<MediaType> one = mediaTypeRepository.findById(oneMediaType.getId());
        assertTrue(one.isPresent());
        assertNotNull(one.get());
        assertEquals(oneMediaType.getId(), one.get().getId());
    }

    @Test
    void findAllMediaTypes() {
        createThreeMediaTypes();

        List<MediaType> all = mediaTypeRepository.findAll();
        assertEquals(3, all.size());
    }

    @Test
    void createMediaTypeThatAlreadyExists() {
        MediaType action = MediaType.builder().name("dvd").build();
        mediaTypeRepository.save(action);
        mediaTypeRepository.flush();
        em.clear();

        assertThrows(DataIntegrityViolationException.class, () -> {
            MediaType mediaType2 = MediaType.builder().name("dvd").build();
            mediaTypeRepository.save(mediaType2);
        });

        List<MediaType> all = mediaTypeRepository.findAll();
        assertEquals(1, all.size());
    }


    @Test
    void deleteAMediaType() {
        createThreeMediaTypes();

        List<MediaType> all = mediaTypeRepository.findAll();
        assertEquals(3, all.size());

        mediaTypeRepository.delete(all.get(0));
        mediaTypeRepository.flush();
        em.clear();

        List<MediaType> remaning = mediaTypeRepository.findAll();
        assertEquals(2, remaning.size());
    }

    @Test
    void deleteAMediaTypeThatDoesNotExist() {
        MediaType mediaType = MediaType.builder().name("ImNotHere").build();

        mediaTypeRepository.delete(mediaType);
        mediaTypeRepository.flush();
        em.clear();

        List<MediaType> remaning = mediaTypeRepository.findAll();
        assertEquals(0, remaning.size());
    }

    @Test
    void findAllMediaTypesPaginatedAndSorted() {
        createThreeMediaTypes();

        Pageable page = PageRequest.of(0, 1, Sort.sort(MediaType.class).by(MediaType::getName).ascending());
        Page<MediaType> all = mediaTypeRepository.findAll(page);

        assertEquals(3, all.getTotalElements());
        assertEquals(3, all.getTotalPages());
        assertEquals("Blu-ray", all.getContent().get(0).getName());
    }

    @Test
    void findMediaTypeById() {
        MediaType dvd = MediaType.builder().name("Dvd").build();

        mediaTypeRepository.save(dvd);
        mediaTypeRepository.flush();
        em.clear();

        Long id = dvd.getId();
        Optional<MediaType> mediaType = mediaTypeRepository.findById(id);
        assertTrue(mediaType.isPresent());
        assertEquals(dvd.getId(), mediaType.get().getId());
        assertEquals(dvd.getName(), mediaType.get().getName());
    }

}
