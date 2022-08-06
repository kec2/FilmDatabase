package dk.kec.filmdb.repositories;

import dk.kec.filmdb.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {}
