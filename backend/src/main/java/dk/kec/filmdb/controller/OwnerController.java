package dk.kec.filmdb.controller;

import dk.kec.filmdb.entity.Owner;
import dk.kec.filmdb.service.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService service;

    @GetMapping
    public ResponseEntity<List<Owner>> getOwners() {
        log.info("Rest call to get owners");
        List<Owner> owners = service.getOwners();
        if (owners.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(owners, HttpStatus.OK);
    }

    @GetMapping("/{ownerId}")
    public ResponseEntity<Owner> getOwner(@PathVariable Long ownerId) {
        log.info("Rest call to get owner");

        Owner owner = service.getOwner(ownerId);
        if (owner == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(owner, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
        log.info("Rest call to create owner");
        Owner owner1 = service.createOwner(owner);
        if (owner1 != null) {
            return new ResponseEntity<>(owner1, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<Owner> updateOwner(@RequestBody Owner owner) {
        log.info("Rest call to update owner");
        Owner owner1 = service.updateOwner(owner);
        if (owner1 != null) {
            return new ResponseEntity<>(owner1, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{ownerId}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long ownerId) {
        log.info("Rest call to delete owner");
        service.deleteOwner(ownerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}