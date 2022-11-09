package im.rubric.filmmakers.filmcompany.application;

import im.rubric.filmmakers.filmcompany.domain.FilmCompanyCommand;
import im.rubric.filmmakers.filmcompany.domain.FilmCompanyQuery;
import im.rubric.filmmakers.filmcompany.domain.FilmCompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilmCompanyFacade {

    private final FilmCompanyService filmCompanyService;

    public void create(FilmCompanyCommand.Create command) {
        filmCompanyService.create(command);
    }

    public void update(Long id, FilmCompanyCommand.Update update) {
        filmCompanyService.update(id, update);
    }

    public Page<FilmCompanyQuery.Main> getFilmCompaniesPage(FilmCompanyQuery.Condition condition, Pageable pageable) {
        return filmCompanyService.getFilmCompaniesByCondition(condition, pageable);
    }

    public FilmCompanyQuery.Detail getFilmCompanyDetail(Long id) {
        return filmCompanyService.getFilmCompanyByIdCondition(id);
    }
}
