package im.rubric.filmmakers.filmmaker.filmmaker.domain;


import im.rubric.filmmakers.filmmaker.actor.domain.Actor;
import im.rubric.filmmakers.common.exception.InvalidParamException;
import im.rubric.filmmakers.common.model.Gender;
import im.rubric.filmmakers.filmmaker.director.domain.Director;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity(name = "film_makers")
@NoArgsConstructor
public class FilmMaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String filmMakerCode;

    private String name;

    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String nationality;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "filmMaker")
    private Actor actor;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "filmMaker")
    private Director director;

    public static FilmMaker create(String filmMakerCode, String name, Gender gender, LocalDate birth, String nationality) {
        FilmMaker filmMaker = new FilmMaker();
        filmMaker.filmMakerCode = filmMakerCode;
        filmMaker.name = name;
        filmMaker.birth = birth;
        filmMaker.gender = gender;
        filmMaker.nationality = nationality;
        return filmMaker;
    }

    public void update(String name, LocalDate birth, Gender gender, String nationality) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.nationality = nationality;
    }

    public void validate() {
        validateName()
            .validateBirth()
            .validateGender()
            .validateFilmMakerCode();
    }

    private FilmMaker validateGender() {
        if (this.gender == null)
            throw new InvalidParamException("FilmMaker Gender can not be null");
        return this;
    }

    private FilmMaker validateFilmMakerCode() {
        if (filmMakerCode == null || filmMakerCode.isBlank())
            throw new InvalidParamException("FilmMaker Code can not be empty");
        return this;
    }

    private FilmMaker validateBirth() {
        if (this.birth == null)
            throw new InvalidParamException("FilmMaker Gender can not be null");
        return this;
    }

    private FilmMaker validateName() {
        if (name == null || name.isBlank())
            throw new InvalidParamException("FilmMaker Name can not be empty");
        return this;
    }

}
