package im.rubric.filmmakers.filmcompany.infrastructure;

import im.rubric.filmmakers.filmcompany.domain.FilmCompanyQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FilmCompanyQueryDslRepository {
    Page<FilmCompanyQuery.Main> findAllByCondition(FilmCompanyQuery.Condition condition, Pageable pageable);

}
