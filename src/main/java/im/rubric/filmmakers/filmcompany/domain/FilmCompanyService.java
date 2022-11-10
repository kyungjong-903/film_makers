package im.rubric.filmmakers.filmcompany.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FilmCompanyService {
    void create(FilmCompanyCommand.Create command);

    void update(Long id, FilmCompanyCommand.Update update);

    Page<FilmCompanyQuery.Main> getFilmCompaniesByCondition(FilmCompanyQuery.Condition condition, Pageable pageable);

    FilmCompanyQuery.Detail getFilmCompanyById(Long id);
}