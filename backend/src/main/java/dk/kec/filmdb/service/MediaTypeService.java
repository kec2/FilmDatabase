package dk.kec.filmdb.service;

import dk.kec.filmdb.entity.MediaType;
import dk.kec.filmdb.repository.MediaTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MediaTypeService {

    private final MediaTypeRepository repository;

    public MediaTypeService(MediaTypeRepository repository) {
        this.repository = repository;
    }

    public List<MediaType> getMediaTypes() {
        return repository.findAll();
    }

    public MediaType getMediaType(Long mediaTypeId) {
        return repository.findById(mediaTypeId).orElse(null);
    }

    public MediaType createMediaType(MediaType MediaType) {
        if (MediaType.getId() == null) {
            return repository.saveAndFlush(MediaType);
        }
        log.error("Don't set id when creating an MediaType");
        return null;
    }

    public MediaType updateMediaType(MediaType MediaType) {
        if (repository.existsById(MediaType.getId())) {
            return repository.saveAndFlush(MediaType);
        }
        log.error("Can't update an MediaType that does not exist");
        return null;
    }

    public void deleteMediaType(Long mediaTypeId) {
        repository.deleteById(mediaTypeId);
    }
}
