package im.rubric.filmmakers.filmmaker.domain;


import im.rubric.filmmakers.common.model.Gender;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "film_makers")
@NoArgsConstructor
public class FilmMaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filmMakerCode;

    private String name;

    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String nationality;

}
