package im.rubric.filmmakers.filmmaker.filmmaker.domain;

import im.rubric.filmmakers.actor.domain.Actor;
import im.rubric.filmmakers.director.domain.Director;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface FilmMakerInfoMapper {

}
