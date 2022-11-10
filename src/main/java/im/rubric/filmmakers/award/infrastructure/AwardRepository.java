package im.rubric.filmmakers.award.infrastructure;

import im.rubric.filmmakers.filmmaker.actor.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwardRepository extends JpaRepository<Actor, Long>, AwardQueryDslRepository {
}
