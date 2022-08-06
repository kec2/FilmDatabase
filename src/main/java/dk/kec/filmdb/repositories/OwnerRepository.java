package dk.kec.filmdb.repositories;

import dk.kec.filmdb.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {}
