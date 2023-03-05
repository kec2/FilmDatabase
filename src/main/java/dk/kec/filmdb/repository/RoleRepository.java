package dk.kec.filmdb.repository;

import dk.kec.filmdb.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {}
