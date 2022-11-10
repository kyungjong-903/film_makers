package im.rubric.filmmakers.filmmaker.filmmaker.domain;

import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface FilmMakerInfoMapper {

}
