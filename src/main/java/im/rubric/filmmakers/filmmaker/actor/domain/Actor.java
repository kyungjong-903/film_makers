package im.rubric.filmmakers.filmmaker.actor.domain;


import im.rubric.filmmakers.filmmaker.filmmaker.domain.FilmMaker;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "actors")
@Table(indexes = { @Index(columnList = "film_maker_id", unique = true) })
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private FilmMaker filmMaker;

}
