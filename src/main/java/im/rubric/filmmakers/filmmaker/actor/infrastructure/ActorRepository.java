package im.rubric.filmmakers.filmmaker.actor.infrastructure;

import im.rubric.filmmakers.filmmaker.actor.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long>, ActorQueryDslRepository {
}
