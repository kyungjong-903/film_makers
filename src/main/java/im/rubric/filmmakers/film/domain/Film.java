package im.rubric.filmmakers.film.domain;

import im.rubric.filmmakers.filmcompany.domain.FilmCompany;
import lombok.Getter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Getter
@Entity(name = "films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID filmCode;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private FilmCompany filmCompany;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
    private Set<ActorRole> actors;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
    private Set<DirectorRole> directors;

    /* 생략 필드
     * 관객수
     * 개봉년도
     * 제작 비용
     * 제작 국가
     *  */
}
