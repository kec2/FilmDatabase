package dk.kec.filmdb.repositories;

import dk.kec.filmdb.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {}
