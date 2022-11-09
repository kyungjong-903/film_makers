package im.rubric.filmmakers.director.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class DirectorCommand {

    @Getter
    @Builder
    @ToString
    public static class Register {

        public Object toEntity() {
            return null;
        }
    }

}
