package im.rubric.filmmakers.filmmaker.filmmaker.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FilmMakerService {
    void create(FilmMakerCommand.Create create);

    void update(Long id, FilmMakerCommand.Update update);

    Page<FilmMakerInfo.Main> getFilmMakersByCondition(FilmMakerInfo.Condition condition, Pageable pageable);

    FilmMakerInfo.Detail getFilmMakerById(Long id);
}