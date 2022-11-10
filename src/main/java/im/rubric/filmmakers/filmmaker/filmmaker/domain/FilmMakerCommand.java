package im.rubric.filmmakers.filmmaker.filmmaker.domain;

import im.rubric.filmmakers.common.model.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class FilmMakerCommand {

    @Getter
    @Builder
    public static class Create {
        private String filmMakerCode;
        private String name;
        private LocalDate birth;
        private Gender gender;
        private String nationality;
    }

    @Getter
    @Builder
    public static class Update {
        private String name;
        private LocalDate birth;
        private Gender gender;
        private String nationality;
    }

}
