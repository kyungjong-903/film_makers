package im.rubric.filmmakers.filmmaker.infrastructure;

import im.rubric.filmmakers.filmmaker.domain.FilmMaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmMakerRepository extends JpaRepository<FilmMaker, Long> {
}
