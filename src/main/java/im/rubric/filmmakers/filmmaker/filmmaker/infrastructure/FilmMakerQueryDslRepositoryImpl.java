package im.rubric.filmmakers.filmmaker.filmmaker.infrastructure;

import com.querydsl.jpa.impl.JPAQuery;
import im.rubric.filmmakers.common.AbstractQuerydslRepository;
import im.rubric.filmmakers.filmcompany.domain.FilmCompanyInfoMapper;
import im.rubric.filmmakers.filmmaker.filmmaker.domain.FilmMaker;
import im.rubric.filmmakers.filmmaker.filmmaker.domain.FilmMakerInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class FilmMakerQueryDslRepositoryImpl extends AbstractQuerydslRepository implements FilmMakerQueryDslRepository {

    private final FilmCompanyInfoMapper filmCompanyInfoMapper;

    @Override
    public Page<FilmMakerInfo.Main> getFilmMakersByCondition(FilmMakerInfo.Condition condition, Pageable pageable) {
        JPAQuery<FilmMaker> query = buildQueryFindAllByCondition(condition);
        JPAQuery<Long> countQuery = buildQueryCountByCondition(condition);
        Page<FilmMaker> res = applyPagination(pageable, FilmMaker.class, contents -> query, count -> countQuery);
        return res.map(filmCompanyInfoMapper::of);
    }

    private JPAQuery<FilmMaker> buildQueryFindAllByCondition(FilmMakerInfo.Condition condition) {

        return null;
    }

    private JPAQuery<Long> buildQueryCountByCondition(FilmMakerInfo.Condition condition) {
        return null;
    }

}
