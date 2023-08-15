package dk.kec.filmdb.repository;

import dk.kec.filmdb.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findByActor_Id(Long actorId);

    List<Role> findByMovie_Id(Long movieId);
}
