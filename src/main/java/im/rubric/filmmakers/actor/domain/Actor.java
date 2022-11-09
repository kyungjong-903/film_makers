package im.rubric.filmmakers.actor.domain;


import im.rubric.filmmakers.filmmaker.domain.FilmMaker;
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

    @ManyToOne(fetch = FetchType.LAZY)
    private FilmMaker filmMaker;

}
