package im.rubric.filmmakers.filmmaker.filmmaker.application;

import im.rubric.filmmakers.filmmaker.filmmaker.domain.FilmMakerCommand;
import im.rubric.filmmakers.filmmaker.filmmaker.domain.FilmMakerInfo;
import im.rubric.filmmakers.filmmaker.filmmaker.domain.FilmMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilmMakerFacade {

    private final FilmMakerService filmMakerService;

    public void create(FilmMakerCommand.Create create) {
        filmMakerService.create(create);
    }

    public void update(Long id, FilmMakerCommand.Update update) {
        filmMakerService.update(id, update);
    }
    public Page<FilmMakerInfo.Main> getFilmMakersPage(FilmMakerInfo.Condition condition, Pageable pageable) {
        return filmMakerService.getFilmMakersByCondition(condition, pageable);
    }

    public FilmMakerInfo.Detail getFilmMakerDetail(Long id) {
        return filmMakerService.getFilmMakerById(id);
    }

}
