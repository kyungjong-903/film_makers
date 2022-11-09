package im.rubric.filmmakers.director.domain;


import im.rubric.filmmakers.filmmaker.domain.FilmMaker;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "directors")
@Table(indexes = { @Index(columnList = "film_maker_id", unique = true) })
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private FilmMaker filmMaker;
    
}
