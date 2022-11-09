package im.rubric.filmmakers.actor.infrastructure;

import im.rubric.filmmakers.actor.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long>, ActorQueryDslRepository {
}
