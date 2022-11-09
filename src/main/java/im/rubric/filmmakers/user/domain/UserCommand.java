package im.rubric.filmmakers.user.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class UserCommand {

    @Getter
    @Builder
    @ToString
    public static class Register {

        public Object toEntity() {
            return null;
        }
    }

}
