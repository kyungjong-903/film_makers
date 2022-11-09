package im.rubric.filmmakers.filmcompany.presentation;

import im.rubric.filmmakers.filmcompany.domain.FilmCompanyCommand;
import im.rubric.filmmakers.filmcompany.domain.FilmCompanyQuery;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface FilmCompanyDtoMapper {
    FilmCompanyCommand.Create of(FilmCompanyDto.Create req);

    FilmCompanyCommand.Update of(FilmCompanyDto.Update req);

    @Mappings({
            @Mapping(expression = "java(req.getId())", target = "super.id")
    })
    FilmCompanyQuery.Condition of(FilmCompanyDto.Condition req);

    FilmCompanyDto.Main of(FilmCompanyQuery.Main main);

    FilmCompanyDto.Detail of(FilmCompanyQuery.Detail filmCompany);
}
