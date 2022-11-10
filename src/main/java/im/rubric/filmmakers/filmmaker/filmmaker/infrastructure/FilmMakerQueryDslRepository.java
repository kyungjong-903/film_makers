package im.rubric.filmmakers.filmmaker.filmmaker.infrastructure;

import im.rubric.filmmakers.filmmaker.filmmaker.domain.FilmMakerInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FilmMakerQueryDslRepository {
    Page<FilmMakerInfo.Main> getFilmMakersByCondition(FilmMakerInfo.Condition condition, Pageable pageable);
}
