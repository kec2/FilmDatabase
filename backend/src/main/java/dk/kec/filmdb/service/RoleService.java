package dk.kec.filmdb.service;

import dk.kec.filmdb.entity.Role;
import dk.kec.filmdb.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RoleService {

    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }


    public List<Role> getRoles() {
        return repository.findAll();
    }

    public List<Role> getRolesByActorId(Long actorId) {
        return repository.findByActor_Id(actorId);
    }

    public List<Role> getRolesByMovieId(Long movieId) {
        return repository.findByMovie_Id(movieId);
    }

    public Role getRole(Long roleId) {
        return repository.findById(roleId).orElse(null);
    }

    public Role createRole(Role role) {
        if (role.getId() == null) {
            return repository.saveAndFlush(role);
        }
        log.error("Don't set id when creating an role");
        return null;
    }

    public Role updateRole(Role role) {
        if (repository.existsById(role.getId())) {
            return repository.saveAndFlush(role);
        }
        log.error("Can't update an role that does not exist");
        return null;
    }

    public void deleteRole(Long roleId) {
        repository.deleteById(roleId);
    }
}
