package dk.kec.filmdb.controller;

import dk.kec.filmdb.entity.Role;
import dk.kec.filmdb.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @GetMapping // does it make sense to get ALL roles???
    public ResponseEntity<List<Role>> getRoles() {
        log.info("Rest call to get roles");
        List<Role> roles = service.getRoles();
        if (roles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/actor/{actorId}")
    public ResponseEntity<List<Role>> getRolesByActorId(@PathVariable Long actorId) {
        log.info("Rest call to get roles");
        List<Role> roles = service.getRolesByActorId(actorId);
        if (roles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Role>> getRolesByMovieId(@PathVariable Long movieId) {
        log.info("Rest call to get roles");
        List<Role> roles = service.getRolesByMovieId(movieId);
        if (roles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<Role> getRole(@PathVariable Long roleId) {
        log.info("Rest call to get role");

        Role role = service.getRole(roleId);
        if (role == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        log.info("Rest call to create role");
        Role role1 = service.createRole(role);
        if (role1 != null) {
            return new ResponseEntity<>(role1, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<Role> updateRole(@RequestBody Role role) {
        log.info("Rest call to update role");
        Role role1 = service.updateRole(role);
        if (role1 != null) {
            return new ResponseEntity<>(role1, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long roleId) {
        log.info("Rest call to delete role");
        service.deleteRole(roleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}