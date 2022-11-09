package im.rubric.filmmakers.filmcompany.infrastructure;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import im.rubric.filmmakers.common.AbstractQuerydslRepository;
import im.rubric.filmmakers.filmcompany.domain.FilmCompany;
import im.rubric.filmmakers.filmcompany.domain.FilmCompanyInfoMapper;
import im.rubric.filmmakers.filmcompany.domain.FilmCompanyQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;

import static im.rubric.filmmakers.filmcompany.domain.QFilmCompany.filmCompany;

@RequiredArgsConstructor
public class FilmCompanyQueryDslRepositoryImpl extends AbstractQuerydslRepository implements FilmCompanyQueryDslRepository {

    private final FilmCompanyInfoMapper filmCompanyInfoMapper;

    @Override
    public Page<FilmCompanyQuery.Main> findAllByCondition(FilmCompanyQuery.Condition condition, Pageable pageable) {
        JPAQuery<FilmCompany> query = buildQueryFindAllByCondition(condition);
        JPAQuery<Long> countQuery = buildQueryCountByCondition(condition);
        Page<FilmCompany> res = applyPagination(pageable, FilmCompany.class, contents -> query, count -> countQuery);
        return res.map(filmCompanyInfoMapper::of);
    }

    private JPAQuery<Long> buildQueryCountByCondition(FilmCompanyQuery.Condition condition) {
        return select(filmCompany.id.count())
                .from(filmCompany)
                .where(
                        containsKeyword(condition.getKeyword()),
                        equalsCompanyCode(condition.getCompanyCode())
                );
    }

    private JPAQuery<FilmCompany> buildQueryFindAllByCondition(FilmCompanyQuery.Condition condition) {
        return selectFrom(filmCompany)
                .where(
                        containsKeyword(condition.getKeyword()),
                        equalsCompanyCode(condition.getCompanyCode())
                );
    }

    private BooleanExpression equalsId(Long id) {
        if (id == null) return null;
        return filmCompany.id.eq(id);
    }

    private BooleanExpression equalsCompanyCode(String companyCode) {
        if (ObjectUtils.isEmpty(companyCode)) return null;
        return filmCompany.companyCode.containsIgnoreCase(companyCode);
    }

    private BooleanExpression containsKeyword(String keyword) {
        if (ObjectUtils.isEmpty(keyword)) return null;
        return filmCompany.name.containsIgnoreCase(keyword);
    }

}
