package dk.kec.filmdb.repositories;

import dk.kec.filmdb.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {}
