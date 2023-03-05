package dk.kec.filmdb.service;

import dk.kec.filmdb.entity.Genre;
import dk.kec.filmdb.repository.GenreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GenreService {

    @Autowired
    private GenreRepository repository;

    public List<Genre> getGenres() {
        return repository.findAll();
    }

    public Genre getGenre(Long genreId) {
        return repository.findById(genreId).orElse(null);
    }

    public Genre createGenre(Genre genre) {
        if (genre.getId() == null) {
            return repository.saveAndFlush(genre);
        }
        log.error("Don't set id when creating an genre");
        return null;
    }

    public Genre updateGenre(Genre genre) {
        if (repository.existsById(genre.getId())) {
            return repository.saveAndFlush(genre);
        }
        log.error("Can't update an genre that does not exist");
        return null;
    }

    public void deleteGenre(Long genreId) {
        repository.deleteById(genreId);
    }
}
