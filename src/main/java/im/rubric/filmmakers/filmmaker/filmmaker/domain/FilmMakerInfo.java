package im.rubric.filmmakers.filmmaker.filmmaker.domain;

import im.rubric.filmmakers.common.model.Gender;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

public class FilmMakerInfo {

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

        public Detail(FilmMaker filmMaker) {
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

        public Actor(im.rubric.filmmakers.filmmaker.actor.domain.Actor actor) {
            this.id = actor.getId();
        }
    }

    @Getter
    public static class Director {
        private Long id;

        public Director(im.rubric.filmmakers.filmmaker.director.domain.Director director) {
            this.id = director.getId();
        }
    }

}
