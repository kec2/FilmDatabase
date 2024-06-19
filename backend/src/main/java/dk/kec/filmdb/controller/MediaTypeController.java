package dk.kec.filmdb.controller;

import dk.kec.filmdb.entity.MediaType;
import dk.kec.filmdb.service.MediaTypeService;
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
@RequestMapping("/mediaType")
public class MediaTypeController {

    private final MediaTypeService service;

    public MediaTypeController(MediaTypeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MediaType>> getMediaTypes() {
        log.info("Rest call to get mediaTypes");
        List<MediaType> mediaTypes = service.getMediaTypes();
        if (mediaTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(mediaTypes, HttpStatus.OK);
    }

    @GetMapping("/{mediaTypeId}")
    public ResponseEntity<MediaType> getMediaType(@PathVariable Long mediaTypeId) {
        log.info("Rest call to get mediaType");

        MediaType mediaType = service.getMediaType(mediaTypeId);
        if (mediaType == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(mediaType, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MediaType> createMediaType(@RequestBody MediaType mediaType) {
        log.info("Rest call to create mediaType");
        MediaType mediaType1 = service.createMediaType(mediaType);
        if (mediaType1 != null) {
            return new ResponseEntity<>(mediaType1, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<MediaType> updateMediaType(@RequestBody MediaType mediaType) {
        log.info("Rest call to update mediaType");
        MediaType mediaType1 = service.updateMediaType(mediaType);
        if (mediaType1 != null) {
            return new ResponseEntity<>(mediaType1, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{mediaTypeId}")
    public ResponseEntity<Void> deleteMediaType(@PathVariable Long mediaTypeId) {
        log.info("Rest call to delete mediaType");
        service.deleteMediaType(mediaTypeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}