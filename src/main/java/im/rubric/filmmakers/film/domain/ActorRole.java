package im.rubric.filmmakers.film.domain;


import im.rubric.filmmakers.filmmaker.actor.domain.Actor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "actor_roles")
public class ActorRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Actor actor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Film film;
}
