package dk.kec.filmdb.repository;

import dk.kec.filmdb.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByTitle(String roleTitle);

    List<Movie> findByIdAndRoles_Title(Long movieId, String rolesTitle);

}
