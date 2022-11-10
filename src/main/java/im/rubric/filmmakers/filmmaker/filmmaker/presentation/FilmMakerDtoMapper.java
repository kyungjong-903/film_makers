package im.rubric.filmmakers.filmmaker.filmmaker.presentation;

import im.rubric.filmmakers.filmmaker.filmmaker.domain.FilmMakerCommand;
import im.rubric.filmmakers.filmmaker.filmmaker.domain.FilmMakerInfo;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface FilmMakerDtoMapper {

    FilmMakerCommand.Create of(FilmMakerDto.Create req);

    FilmMakerCommand.Update of(FilmMakerDto.Update req);

    FilmMakerInfo.Condition of(FilmMakerDto.Condition req);

    FilmMakerDto.Main of(FilmMakerInfo.Main main);
}
