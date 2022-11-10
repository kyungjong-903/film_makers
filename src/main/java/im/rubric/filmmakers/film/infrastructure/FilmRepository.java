package im.rubric.filmmakers.film.infrastructure;

import im.rubric.filmmakers.film.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long>, FilmQueryDslRepository {
}
