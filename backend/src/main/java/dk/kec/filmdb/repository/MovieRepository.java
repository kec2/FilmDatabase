package dk.kec.filmdb.repository;

import dk.kec.filmdb.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {}
