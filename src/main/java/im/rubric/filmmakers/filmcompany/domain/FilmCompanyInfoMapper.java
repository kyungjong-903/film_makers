package im.rubric.filmmakers.filmcompany.domain;

import im.rubric.filmmakers.film.domain.Film;
import im.rubric.filmmakers.filmmaker.filmmaker.domain.FilmMaker;
import im.rubric.filmmakers.filmmaker.filmmaker.domain.FilmMakerInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface FilmCompanyInfoMapper {

    FilmCompanyQuery.Main of(FilmCompany filmCompany);

    FilmCompanyQuery.Detail of(FilmCompany filmCompany, List<Film> films);

    FilmMakerInfo.Main of(FilmMaker filmMaker);
}
