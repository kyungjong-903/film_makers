package im.rubric.filmmakers.filmcompany.infrastructure;

import im.rubric.filmmakers.filmcompany.domain.FilmCompany;
import im.rubric.filmmakers.filmcompany.domain.FilmCompanyQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmCompanyRepository extends JpaRepository<FilmCompany, Long>, FilmCompanyQueryDslRepository {
    boolean existsByCompanyCode(String companyCode);
}
