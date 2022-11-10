package im.rubric.filmmakers.filmmaker.filmmaker.infrastructure;

import im.rubric.filmmakers.filmmaker.filmmaker.domain.FilmMaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmMakerRepository extends JpaRepository<FilmMaker, Long>, FilmMakerQueryDslRepository {
    boolean existsByFilmMakerCode(String filmMakerCode);
}
