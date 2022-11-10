package im.rubric.filmmakers.filmmaker.filmmaker.presentation;

import im.rubric.filmmakers.common.model.Gender;
import im.rubric.filmmakers.filmmaker.filmmaker.domain.FilmMaker;
import im.rubric.filmmakers.filmmaker.filmmaker.domain.FilmMakerCommand;
import im.rubric.filmmakers.filmmaker.filmmaker.domain.FilmMakerInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class FilmMakerDto {
    @Getter
    @Setter
    public static class Create {
        @NotEmpty
        private String filmMakerCode;
        @NotEmpty
        private String name;
        @NotNull
        private LocalDate birth;
        @NotNull
        private Gender gender;

        private String nationality;

    }

    @Getter
    @Setter
    public static class Update {
        @NotEmpty
        private String name;
        @NotNull
        private LocalDate birth;
        @NotNull
        private Gender gender;

        private String nationality;
    }

    @Getter
    @Builder
    public static class Condition {
        private String keyword;
        private LocalDate birth;
        private Gender gender;
        private String nationality;
    }


    @Getter
    @Builder
    public static class Main {
        private Long id;
        private String name;
        private LocalDate birth;
        private Gender gender;
        private String nationality;
    }

    @Getter
    public static class Detail {
        private Long id;
        private String filmMakerCode;
        private String name;
        private LocalDate birth;
        private Gender gender;
        private String nationality;
        private Actor actor;
        private Director director;

        public Detail(FilmMakerInfo.Detail filmMaker) {
            this.id = filmMaker.getId();
            this.filmMakerCode = filmMaker.getFilmMakerCode();
            this.name = filmMaker.getName();
            this.birth = filmMaker.getBirth();
            this.gender = filmMaker.getGender();
            this.nationality= filmMaker.getNationality();
            this.actor = new Actor(filmMaker.getActor());
            this.director = new Director(filmMaker.getDirector());
        }
    }


    @Getter
    public static class Actor {
        private Long id;

        public Actor(FilmMakerInfo.Actor actor) {
            this.id = actor.getId();
        }
    }

    @Getter
    public static class Director {
        private Long id;

        public Director(FilmMakerInfo.Director director) {
            this.id = director.getId();
        }
    }

}
