package im.rubric.filmmakers.actor.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class ActorCommand {

    @Getter
    @Builder
    @ToString
    public static class Register {

        public Object toEntity() {
            return null;
        }
    }

}
