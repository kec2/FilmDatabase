package dk.kec.filmdb.service;

import dk.kec.filmdb.entity.Owner;
import dk.kec.filmdb.repository.OwnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OwnerService {

    @Autowired
    private OwnerRepository repository;

    public List<Owner> getOwners() {
        return repository.findAll();
    }

    public Owner getOwner(Long ownerId) {
        return repository.findById(ownerId).orElse(null);
    }

    public Owner createOwner(Owner owner) {
        if (owner.getId() == null) {
            return repository.saveAndFlush(owner);
        }
        log.error("Don't set id when creating an owner");
        return null;
    }

    public Owner updateOwner(Owner owner) {
        if (repository.existsById(owner.getId())) {
            return repository.saveAndFlush(owner);
        }
        log.error("Can't update an owner that does not exist");
        return null;
    }

    public void deleteOwner(Long ownerId) {
        repository.deleteById(ownerId);
    }
}
