package im.rubric.filmmakers.filmmaker.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class FilmMakerCommand {

    @Getter
    @Builder
    @ToString
    public static class Register {

        public Object toEntity() {
            return null;
        }
    }

}
