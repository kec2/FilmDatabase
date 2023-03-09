package dk.kec.filmdb.service;

import dk.kec.filmdb.entity.Actor;
import dk.kec.filmdb.repository.ActorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ActorService {

    @Autowired
    private ActorRepository repository;

    public List<Actor> getActors() {
        return repository.findAll();
    }

    public Actor getActor(Long actorId) {
        return repository.findById(actorId).orElse(null);
    }

    public Actor createActor(Actor actor) {
        if (actor.getId() == null) {
            return repository.saveAndFlush(actor);
        }
        log.error("Don't set id when creating an actor");
        return null;
    }

    public Actor updateActor(Actor actor) {
        if (repository.existsById(actor.getId())) {
            return repository.saveAndFlush(actor);
        }
        log.error("Can't update an actor that does not exist");
        return null;
    }

    public void deleteActor(Long actorId) {
        repository.deleteById(actorId);
    }
}
