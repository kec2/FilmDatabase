package dk.kec.filmdb.controller;

import dk.kec.filmdb.service.ActorService;
import dk.kec.filmdb.entity.Actor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorService service;

    @GetMapping
    public ResponseEntity<List<Actor>> getActors() {
        log.info("Rest call to get actors");
        List<Actor> actors = service.getActors();
        if (actors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(actors, HttpStatus.OK);
    }

    @GetMapping("/{actorId}")
    public ResponseEntity<Actor> getActor(@PathVariable Long actorId) {
        log.info("Rest call to get actor");

        Actor actor = service.getActor(actorId);
        if (actor == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(actor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Actor> createActor(@RequestBody Actor actor) {
        log.info("Rest call to create actor");
        Actor actor1 = service.createActor(actor);
        if (actor1 != null) {
            return new ResponseEntity<>(actor1, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<Actor> updateActor(@RequestBody Actor actor) {
        log.info("Rest call to update actor");
        Actor actor1 = service.updateActor(actor);
        if (actor1 != null) {
            return new ResponseEntity<>(actor1, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{actorId}")
    public ResponseEntity<Void> deleteActor(@PathVariable Long actorId) {
        log.info("Rest call to delete actor");
        service.deleteActor(actorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}