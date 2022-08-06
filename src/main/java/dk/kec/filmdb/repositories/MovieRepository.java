package dk.kec.filmdb.repositories;

import dk.kec.filmdb.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {}
