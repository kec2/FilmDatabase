package dk.kec.filmdb.repository;

import dk.kec.filmdb.entity.MediaType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaTypeRepository extends JpaRepository<MediaType, Long> {}
