package dk.kec.filmdb.repository;

import dk.kec.filmdb.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {}
