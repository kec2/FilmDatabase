package dk.kec.filmdb.repositories;

import dk.kec.filmdb.entities.MediaType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaTypeRepository extends JpaRepository<MediaType, Long> {}
