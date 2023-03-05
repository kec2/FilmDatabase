package dk.kec.filmdb.repository;

import dk.kec.filmdb.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {}
