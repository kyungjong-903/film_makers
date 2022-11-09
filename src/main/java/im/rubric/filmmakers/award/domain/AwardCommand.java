package im.rubric.filmmakers.award.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class AwardCommand {

    @Getter
    @Builder
    @ToString
    public static class Register {

        public Object toEntity() {
            return null;
        }
    }

}
