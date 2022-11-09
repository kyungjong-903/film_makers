package im.rubric.filmmakers.film.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class FilmCommand {

    @Getter
    @Builder
    @ToString
    public static class Register {

        public Object toEntity() {
            return null;
        }
    }

}
